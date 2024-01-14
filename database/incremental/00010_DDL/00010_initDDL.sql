SET search_path TO public;
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT USAGE ON schema public TO ipo;
CREATE EXTENSION pgcrypto;


CREATE TABLE public.country (
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL UNIQUE,
  message_key VARCHAR(64) NOT NULL
);
GRANT SELECT ON public.country TO ipo;

COMMENT ON TABLE public.country IS 'Dictionary of countries';
COMMENT ON COLUMN public.country.id IS 'Primary key';
COMMENT ON COLUMN public.country.name IS 'Country name';
COMMENT ON COLUMN public.country.message_key IS 'Message key value processed by Spring Translation framework';


CREATE TABLE public.personal_title (
  id NUMERIC(1,0) PRIMARY KEY,
  name VARCHAR(12) NOT NULL UNIQUE,
  message_key VARCHAR(64) NOT NULL
);
GRANT SELECT ON public.personal_title TO ipo;

COMMENT ON TABLE public.personal_title IS 'Dictionary of personal titles';
COMMENT ON COLUMN public.personal_title.id IS 'Primary key';
COMMENT ON COLUMN public.personal_title.name IS 'Personal title';
COMMENT ON COLUMN public.personal_title.message_key IS 'Message key value processed by Spring Translation framework';


CREATE TABLE public.phone_type (
  id NUMERIC(1,0) PRIMARY KEY,
  name VARCHAR(32) NOT NULL UNIQUE,
  message_key VARCHAR(64) NOT NULL
);
GRANT SELECT ON public.phone_type TO ipo;

COMMENT ON TABLE public.phone_type IS 'Dictionary of phone types';
COMMENT ON COLUMN public.phone_type.id IS 'Primary key';
COMMENT ON COLUMN public.phone_type.name IS 'Name of phone type';
COMMENT ON COLUMN public.phone_type.message_key IS 'Message key value processed by Spring Translation framework';


CREATE TABLE public.duty_station (
  id SERIAL PRIMARY KEY,
  country_id INTEGER REFERENCES country(id) NOT NULL,
  name VARCHAR(32) NOT NULL
);
GRANT SELECT, INSERT, UPDATE, DELETE ON public.duty_station TO ipo;

COMMENT ON TABLE public.duty_station IS 'Duty stations';
COMMENT ON COLUMN public.duty_station.id IS 'Primary key';
COMMENT ON COLUMN public.duty_station.country_id IS 'Id of country which certain Duty Station belongs to';
COMMENT ON COLUMN public.duty_station.name IS 'Name of duty station';


CREATE TABLE public.user_image (
  id SERIAL PRIMARY KEY,
  raw_data BYTEA,
  mime_type VARCHAR(16) NOT NULL
);
GRANT SELECT, INSERT, UPDATE, DELETE ON public.user_image TO ipo;

COMMENT ON TABLE public.user_image IS 'User''s pictures';
COMMENT ON COLUMN public.user_image.id IS 'Primary key';
COMMENT ON COLUMN public.user_image.raw_data IS 'Image stored as binary data';
COMMENT ON COLUMN public.user_image.mime_type IS 'Mime type of stored file';


CREATE TABLE public.user_profile (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  personal_title_id NUMERIC(1,0) REFERENCES personal_title(id),
  job_title VARCHAR(64),
  academic_title VARCHAR(64),
  country_id INTEGER REFERENCES country(id),
  user_image_id INTEGER REFERENCES user_image(id),
  duty_station_id INTEGER REFERENCES duty_station(id),
  residence_location VARCHAR(128),
  contract_end_date DATE,
  email VARCHAR(64) NOT NULL,
  dob DATE,
  password VARCHAR(128) NOT NULL,
  salt NUMERIC(10,0),
  active BOOLEAN NOT NULL,
  failed_attempts INTEGER,
  last_attempt_date TIMESTAMP,
  password_expiry_date TIMESTAMP,
  usage_agreement_date TIMESTAMP,
  is_consultant BOOLEAN NOT NULL,
  token VARCHAR(70),
  message_language VARCHAR(3),
  reset_password_valid_date TIMESTAMP,
  update_date TIMESTAMP,
  updated_by_id INTEGER REFERENCES user_profile(id)
);
create unique index unique_email on user_profile(email) where active;
GRANT SELECT, INSERT, UPDATE, DELETE ON public.user_profile TO ipo;

COMMENT ON TABLE public.user_profile IS 'User accounts';
COMMENT ON COLUMN public.user_profile.id IS 'Primary key';
COMMENT ON COLUMN public.user_profile.first_name IS 'First name';
COMMENT ON COLUMN public.user_profile.last_name IS 'Last name';
COMMENT ON COLUMN public.user_profile.job_title IS 'Job title';
COMMENT ON COLUMN public.user_profile.academic_title IS 'Academic title';
COMMENT ON COLUMN public.user_profile.personal_title_id IS 'Id of personal title';
COMMENT ON COLUMN public.user_profile.country_id IS 'Id of assigned country';
COMMENT ON COLUMN public.user_profile.user_image_id IS 'Id of user''s image';
COMMENT ON COLUMN public.user_profile.duty_station_id IS 'Id of user''s image';
COMMENT ON COLUMN public.user_profile.residence_location IS 'Location of residence';
COMMENT ON COLUMN public.user_profile.contract_end_date IS 'Date when last user''s contract is ending';
COMMENT ON COLUMN public.user_profile.email IS 'Users'' email';
COMMENT ON COLUMN public.user_profile.dob IS 'Birthday';
COMMENT ON COLUMN public.user_profile.password IS 'Encoded password';
COMMENT ON COLUMN public.user_profile.salt IS 'Salt used to password hash generation';
COMMENT ON COLUMN public.user_profile.active IS 'Is user enabled to login and being visible for the others';
COMMENT ON COLUMN public.user_profile.failed_attempts IS 'Amount of failed authorisation attempts. When User is getting to logged in this field is set to 0';
COMMENT ON COLUMN public.user_profile.last_attempt_date IS 'Last date of successful or unsuccessful authorisation';
COMMENT ON COLUMN public.user_profile.password_expiry_date IS 'Max date till user is able to use the current password. After this date he/she will be still able to log in, but changing it will be required. When value is NULL password is valid all the time';
COMMENT ON COLUMN public.user_profile.usage_agreement_date IS 'Timestamp when user accepted policy of usign ipo application';
COMMENT ON COLUMN public.user_profile.is_consultant IS 'Is consultant or not (Can be modified only by person with role Project Management)';
COMMENT ON COLUMN public.user_profile.update_date IS 'Date when any of table''s field has been changed or when someone confirmed that stored data are still valid';
COMMENT ON COLUMN public.user_profile.updated_by_id IS 'Id of user who changed any of table''s field or confirmed that stored data are still valid';
COMMENT ON COLUMN public.user_profile.token IS 'Token used in reset password';
COMMENT ON COLUMN public.user_profile.message_language IS 'Message language used for specific user';
COMMENT ON COLUMN public.user_profile.reset_password_valid_date IS 'Date means the point of time when user sent request related to reset of password need to be valid by 7 days';


CREATE TABLE public.user_phone (
  user_id INTEGER REFERENCES user_profile(id),
  phone_type_id NUMERIC(1,0) REFERENCES phone_type(id),
  phone_number VARCHAR(16) NOT NULL,
  PRIMARY KEY(user_id, phone_type_id)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON public.user_phone TO ipo;

COMMENT ON TABLE public.user_phone IS 'User''s phone numbers';
COMMENT ON COLUMN public.user_phone.user_id IS 'Id of phone''s owner. (Part of composite Primary Key)';
COMMENT ON COLUMN public.user_phone.phone_type_id IS 'Id of phone type numer like MOBILE, SATELITE_PHONE. (Part of composite Primary Key)';
COMMENT ON COLUMN public.user_phone.phone_number IS 'Phone mumber with country prefix (00XX-XXXXXXXX)';
COMMENT ON COLUMN public.user_phone.phone_number IS 'Phone mumber with country prefix (00XX-XXXXXXXX)';


CREATE TABLE public.role (
  id SERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description VARCHAR,
  message_key VARCHAR(64) NOT NULL
);
GRANT SELECT, INSERT, UPDATE, DELETE ON public.role TO ipo;

COMMENT ON TABLE public.role IS 'Roles and their meaning';
COMMENT ON COLUMN public.role.id IS 'Primary key';
COMMENT ON COLUMN public.role.name IS 'Name of the role';
COMMENT ON COLUMN public.role.description IS 'Role description';
COMMENT ON COLUMN public.role.message_key IS 'Message key value processed by Spring Translation framework';


CREATE TABLE public.user_role (
	user_id INTEGER REFERENCES user_profile(id),
	role_id INTEGER REFERENCES role(id),
	PRIMARY KEY(user_id, role_id)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON public.user_role TO ipo;

COMMENT ON TABLE public.user_role IS 'Links system roles with given user';
COMMENT ON COLUMN public.user_role.user_id IS 'Reference to user_profile table. (Part of composite Primary Key)';
COMMENT ON COLUMN public.user_role.role_id IS 'Reference to role table. (Part of composite Primary Key)';


CREATE OR REPLACE FUNCTION sha512(bytea) returns text AS $$
      SELECT encode(digest($1, 'sha512'), 'hex')
    $$ LANGUAGE SQL STRICT IMMUTABLE;
	
GRANT EXECUTE ON FUNCTION public.sha512(bytea) TO ipo;
COMMENT ON FUNCTION public.sha512(bytea) IS 'Calculate SHA-512 hash from given input string';
