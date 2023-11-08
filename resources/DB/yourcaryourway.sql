-- Deleting tables
DROP TABLE IF EXISTS accounts_tchats;
DROP TABLE IF EXISTS tchat;
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
    currencycurrencyuuid uuid REFERENCES currency(currencyuuid),
    countryiso VARCHAR(3) NOT NULL,
    country VARCHAR(128)
);

-- Creation of the "address" table
CREATE TABLE address (
    addressuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    countrycountryuuid uuid REFERENCES country(countryuuid),
    address VARCHAR(2048),
    zipcode VARCHAR(128),
    town VARCHAR(256),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

-- Creation of the "company" table
CREATE TABLE company (
    companyuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    addressaddressuuid uuid REFERENCES address(addressuuid),
    email VARCHAR(384) NOT NULL UNIQUE,
    companyname VARCHAR(256) UNIQUE,
    phone VARCHAR(20),
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    active BOOLEAN DEFAULT true
);

-- Creation of the "user_role" table
CREATE TABLE user_role (
    userroleuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    userrolename VARCHAR(128)
);

-- Creation of the "user_language" table
CREATE TABLE user_language (
    languageuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    languagecode VARCHAR(3) NOT NULL,
    languagename VARCHAR(128)
);

-- Creation of the "account" table
CREATE TABLE account (
    useruuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    addressaddressuuid uuid REFERENCES address(addressuuid),
    companycompanyuuid uuid REFERENCES company(companyuuid),
    userroleroleuuid uuid REFERENCES user_role(userroleuuid),
    languagelanguageuuid uuid REFERENCES user_language(languageuuid),
    email VARCHAR(384) NOT NULL UNIQUE,
    accountpassword VARCHAR(80) NOT NULL,
    accountname VARCHAR(256),
    surname VARCHAR(256),
    phone VARCHAR(20),
    updatedat TIMESTAMP,
    createdat TIMESTAMP,
    active BOOLEAN DEFAULT true
);

-- Creation of the "tchat" table
CREATE TABLE tchat (
    tchatuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    accountsenderuuid uuid REFERENCES account(useruuid),
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    active BOOLEAN DEFAULT true,
    content VARCHAR(2048)
);

-- Creation of the "accounts_tchats" table
CREATE TABLE accounts_tchats (
    accountstchatsuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    tchattchatuuid uuid REFERENCES tchat(tchatuuid),
    accountuseruuid uuid REFERENCES account(useruuid)
);

-- Pre-populate with 1 user account and 1 employee account

TRUNCATE TABLE currency CASCADE;
TRUNCATE TABLE country CASCADE;
TRUNCATE TABLE address CASCADE;
TRUNCATE TABLE company CASCADE;
TRUNCATE TABLE user_role CASCADE;
TRUNCATE TABLE user_language CASCADE;
TRUNCATE TABLE account CASCADE;
TRUNCATE TABLE tchat CASCADE;
TRUNCATE TABLE accounts_tchats CASCADE;

DO $$
DECLARE
    currencyuuid_ uuid;
    countryuuid_ uuid;
    addressuuid_ uuid;
    roleuseruuid uuid;
    roleemployeeuuid uuid;
    languageuuid_ uuid;
    companyuuid_ uuid;
    tchatuuiduser uuid; 
    tchatuuidemployee uuid;    
BEGIN
    INSERT INTO currency (currencyiso) VALUES ('EUR') RETURNING currencyuuid INTO currencyuuid_;
    INSERT INTO country (currencycurrencyuuid, countryiso, country) VALUES (currencyuuid_, 'FRA', 'France') RETURNING countryuuid INTO countryuuid_;
    INSERT INTO address (countrycountryuuid, address, zipcode, town, latitude, longitude) VALUES (countryuuid_, '1 Rue de la Paix', '75001', 'Paris', 48.8566, 2.3522) RETURNING addressuuid INTO addressuuid_;
    INSERT INTO user_role (userrolename) VALUES ('USER') RETURNING userroleuuid INTO roleuseruuid;
    INSERT INTO user_role (userrolename) VALUES ('EMPLOYEE') RETURNING userroleuuid INTO roleemployeeuuid;
    INSERT INTO user_language (languagecode, languagename) VALUES ('fra', 'Français') RETURNING languageuuid INTO languageuuid_;
    INSERT INTO account (useruuid,addressaddressuuid, companycompanyuuid, userroleroleuuid, languagelanguageuuid, email, accountpassword, accountname, surname, phone, updatedat, createdat, active) VALUES ('784b9cbd-acfd-4aa0-8eb9-57561fba2bf9',addressuuid_, NULL, roleuseruuid,languageuuid_, 'user@example.com', '$2a$10$/T0HZF.3NUxjJcUduu6DXOJ5NFQJTadHw51UH8nasNqvf7iTwxHwy', 'John', 'Doe', '1234567890', NOW(), NOW(), true);
    INSERT INTO company (addressaddressuuid, email, companyname, phone, createdat, updatedat, active) VALUES (addressuuid_, 'company@example.com', 'Your Car Your Way France', '1234567890', NOW(), NOW(), true) RETURNING companyuuid INTO companyuuid_;
    INSERT INTO account (useruuid,addressaddressuuid, companycompanyuuid, userroleroleuuid, languagelanguageuuid, email, accountpassword, accountname, surname, phone, updatedat, createdat, active) VALUES ('74054662-52db-46d7-80db-d4339dca6bb6',addressuuid_, companyuuid_, roleemployeeuuid, languageuuid_, 'employee@example.com', '$2a$10$/T0HZF.3NUxjJcUduu6DXOJ5NFQJTadHw51UH8nasNqvf7iTwxHwy', 'Jane', 'Doe', '1234567890', NOW(), NOW(), true);

INSERT INTO tchat (accountsenderuuid, createdat, updatedat, active, content) VALUES ('784b9cbd-acfd-4aa0-8eb9-57561fba2bf9', NOW(), NOW(), true, 'User question') RETURNING tchatuuid INTO tchatuuiduser;
INSERT INTO accounts_tchats (tchattchatuuid, accountuseruuid) VALUES (tchatuuiduser, '74054662-52db-46d7-80db-d4339dca6bb6');
INSERT INTO tchat (accountsenderuuid, createdat, updatedat, active, content) VALUES ('74054662-52db-46d7-80db-d4339dca6bb6', NOW() + INTERVAL '2 minute', NOW() + INTERVAL '2 minute', true, 'Employee response') RETURNING tchatuuid INTO tchatuuidemployee;
INSERT INTO accounts_tchats (tchattchatuuid, accountuseruuid) VALUES (tchatuuidemployee, '784b9cbd-acfd-4aa0-8eb9-57561fba2bf9');
    
END $$;