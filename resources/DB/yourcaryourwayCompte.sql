-- Deleting tables
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user_language;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS currency;

-- Creation of the "currency" table
CREATE TABLE currency (
    currencyuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    currencyiso VARCHAR(3) NOT NULL
);

-- Creation of the "country" table
CREATE TABLE country (
    countryuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    currency_currencyuuid uuid REFERENCES currency(currencyuuid),
    countryiso VARCHAR(3) NOT NULL,
    country VARCHAR(128)
);

-- Creation of the "address" table
CREATE TABLE address (
    addressuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    country_countryuuid uuid REFERENCES country(countryuuid),
    address VARCHAR(2048),
    zipcode VARCHAR(128),
    town VARCHAR(256),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

-- Creation of the "company" table
CREATE TABLE company (
    companyuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    address_addressuuid uuid REFERENCES address(addressuuid),
    email VARCHAR(384) NOT NULL UNIQUE,
    companyname VARCHAR(256) NOT NULL,
    phone VARCHAR(20),
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    active BOOLEAN DEFAULT true
);

-- Creation of the "user_role" table
CREATE TABLE user_role (
    user_roleuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    user_role_name VARCHAR(128)
);

-- Creation of the "user_language" table
CREATE TABLE user_language (
    languageuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    language_code VARCHAR(3) NOT NULL,
    language_name VARCHAR(128)
);

-- Creation of the "account" table
CREATE TABLE account (
    useruuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    address_addressuuid uuid REFERENCES address(addressuuid),
    company_companyuuid uuid REFERENCES company(companyuuid),
    user_role_roleuuid uuid REFERENCES user_role(user_roleuuid),
    language_languageuuid uuid REFERENCES user_language(languageuuid),
    email VARCHAR(384) NOT NULL UNIQUE,
    accountpassword VARCHAR(80) NOT NULL,
    accountname VARCHAR(256),
    surname VARCHAR(256),
    phone VARCHAR(20),
    updatedat TIMESTAMP,
    createdat TIMESTAMP,
    active BOOLEAN DEFAULT true
);

-- Pre-populate with 1 user account and 1 employee account

TRUNCATE TABLE currency CASCADE;
TRUNCATE TABLE country CASCADE;
TRUNCATE TABLE address CASCADE;
TRUNCATE TABLE company CASCADE;
TRUNCATE TABLE user_role CASCADE;
TRUNCATE TABLE user_language CASCADE;
TRUNCATE TABLE account CASCADE;

DO $$
DECLARE
    currency_uuid uuid;
    country_uuid uuid;
    address_uuid uuid;
    role_user_uuid uuid;
    role_employee_uuid uuid;
    language_uuid uuid;
    company_uuid uuid;
BEGIN
    INSERT INTO currency (currencyiso) VALUES ('EUR') RETURNING currencyuuid INTO currency_uuid;
    INSERT INTO country (currency_currencyuuid, countryiso, country) VALUES (currency_uuid, 'FRA', 'France') RETURNING countryuuid INTO country_uuid;
    INSERT INTO address (country_countryuuid, address, zipcode, town, latitude, longitude) VALUES (country_uuid, '1 Rue de la Paix', '75001', 'Paris', 48.8566, 2.3522) RETURNING addressuuid INTO address_uuid;
    INSERT INTO user_role (user_role_name) VALUES ('USER') RETURNING user_roleuuid INTO role_user_uuid;
    INSERT INTO user_role (user_role_name) VALUES ('EMPLOYEE') RETURNING user_roleuuid INTO role_employee_uuid;
    INSERT INTO user_language (language_code, language_name) VALUES ('fra', 'Français') RETURNING languageuuid INTO language_uuid;
    INSERT INTO account (useruuid,address_addressuuid, company_companyuuid, user_role_roleuuid, language_languageuuid, email, accountpassword, accountname, surname, phone, updatedat, createdat, active) VALUES ('784b9cbd-acfd-4aa0-8eb9-57561fba2bf9',address_uuid, NULL, role_user_uuid,language_uuid, 'user@example.com', '$2a$10$/T0HZF.3NUxjJcUduu6DXOJ5NFQJTadHw51UH8nasNqvf7iTwxHwy', 'John', 'Doe', '1234567890', NOW(), NOW(), true);
	INSERT INTO company (address_addressuuid, email, companyname, phone, createdat, updatedat, active) VALUES (address_uuid, 'company@example.com', 'Your Car Your Way France', '1234567890', NOW(), NOW(), true) RETURNING companyuuid INTO company_uuid;
    INSERT INTO account (useruuid,address_addressuuid, company_companyuuid, user_role_roleuuid, language_languageuuid, email, accountpassword, accountname, surname, phone, updatedat, createdat, active) VALUES ('74054662-52db-46d7-80db-d4339dca6bb6',address_uuid, company_uuid, role_employee_uuid, language_uuid, 'employee@example.com', '$2a$10$/T0HZF.3NUxjJcUduu6DXOJ5NFQJTadHw51UH8nasNqvf7iTwxHwy', 'Jane', 'Doe', '1234567890', NOW(), NOW(), true);
END $$;