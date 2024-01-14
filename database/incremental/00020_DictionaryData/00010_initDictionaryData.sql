
SET search_path TO public;
DO $$DECLARE
	i integer;
	salt_value numeric(10, 0);
BEGIN
	-- Roles
	INSERT INTO role(name, description, message_key) VALUES 
	('ROLE_PROJECT_MANAGER', 'Project Manager', 'role.project_manager'),
	('ROLE_ADMIN', 'System administrator', 'role.system_administrator'),
	('ROLE_USER', 'The most common user of the application', 'role.user'),
	('ROLE_RADIO_OPERATOR', 'Radio operator', 'role.radio_operator');
	
	-- Countries
	INSERT INTO country(name, message_key) VALUES 
	('Afghanistan', 'country.afghanistan'),
	('Mexico', 'country.mexico' ),
	('Ethiopia', 'country.ethiopia'),
	('Chad', 'country.chad'),
	('Lebanon', 'country.lebanon');
	
	-- Personal titles
	INSERT INTO personal_title(id, name, message_key) VALUES
	(1, 'Mr', 'personal_title.mr'),
	(2, 'Miss', 'personal_title.miss');
	
	-- Phone types
	INSERT INTO phone_type(id, name, message_key) VALUES
	(1, 'Mobile', 'phone.mobile'),
	(2, 'Alternative mobile', 'phone.alternative_mobile'),
	(3, 'International mobile', 'phone.international_mobile'),
	(4, 'Satelite phone', 'phone.satelite_phone');
	
		
END$$;
