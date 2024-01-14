
SET search_path TO public;
DO $$DECLARE
	i integer;
	counter integer = 1;
	salt_value numeric(10, 0);
BEGIN
	-- Duty stations
	INSERT INTO duty_station(country_id, name) VALUES 
	(1, 'James Bond''s Duty Station'),
	(1, 'Vladimir Putin''s Duty Station'),
	(1, 'Top Secret Duty Station'),
	(2, 'Duty Station 24h with beer'),
	(2, 'Obama''s Duty Station');
	
	-- Create 10 PM users
	FOR i IN 1..10 LOOP
   
		salt_value = round(random() * 9999999999);
		INSERT INTO user_profile(first_name, 
			last_name, 
			email, 
			password, 
			salt, 
			is_consultant, 
			contract_end_date,
			usage_agreement_date,
			dob,
			active,
			failed_attempts,
			last_attempt_date) 
		VALUES ('First name' || counter, 
			'Last name' || counter, 
			'pm'|| counter || '@smt.com',
			sha512(('qwe' || '{' || salt_value || '}')::bytea), 
			salt_value,
			false,
			now() + interval '1 month' * counter,
			case when counter % 2 = 0 then now() else null end,
			(now() - interval '1 year' * ( 20 + counter))::date,
			true,
			case when counter % 10 = 0 then 3 else null end,
			case when counter % 5 = 0 then now() - interval '1 day' * counter else null end
			)
		RETURNING id INTO i;

		-- Link initial users with roles
		INSERT INTO user_role(user_id, role_id) values (i, 1);
		
		counter = counter + 1;
   
	END LOOP;
						
END$$;
