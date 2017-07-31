SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

BEGIN;

INSERT INTO `user_profile` (user_profile_id, email, first_name, last_name, password, phone_number, role) VALUES ('2', 'ivica@gmail.com', 'Ivica', 'Vojinovic', '$2a$06$kEcAZMqeT4gAglOBV99ucuIk.XkNcw81V6Wft6F8R81j9SkT6GnFK', '+38164543765756', 'ROLE_USER');

COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
