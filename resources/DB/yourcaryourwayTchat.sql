-- Deleting tables
DROP TABLE IF EXISTS accounts_tchats;
DROP TABLE IF EXISTS tchat;

-- Creation of the "tchat" table
CREATE TABLE tchat (
    tchatuuid uuid PRIMARY KEY UNIQUE DEFAULT gen_random_uuid(),
    sender_senderuuid uuid NOT NULL,
    createdat TIMESTAMP NOT NULL,
    updatedat TIMESTAMP NOT NULL,
    active BOOLEAN DEFAULT true,
    content VARCHAR(2048)
);

-- Creation of the "accounts_tchats" table
CREATE TABLE accounts_tchats (
    tchat_tchatuuid uuid REFERENCES tchat(tchatuuid),
    account_useruuid uuid NOT NULL
);


-- Pre-populate with 1 meesage for each user

TRUNCATE TABLE tchat CASCADE;
TRUNCATE TABLE accounts_tchats CASCADE;

DO $$
DECLARE
    tchat_uuid_user uuid; 
    tchat_uuid_employee uuid;    
BEGIN
INSERT INTO tchat (sender_senderuuid, createdat, updatedat, active, content) VALUES ('784b9cbd-acfd-4aa0-8eb9-57561fba2bf9', NOW(), NOW(), true, 'User question') RETURNING tchatuuid INTO tchat_uuid_user;
INSERT INTO accounts_tchats (tchat_tchatuuid, account_useruuid) VALUES (tchat_uuid_user, '74054662-52db-46d7-80db-d4339dca6bb6');
INSERT INTO tchat (sender_senderuuid, createdat, updatedat, active, content) VALUES ('74054662-52db-46d7-80db-d4339dca6bb6', NOW() + INTERVAL '2 minute', NOW() + INTERVAL '2 minute', true, 'Employee response') RETURNING tchatuuid INTO tchat_uuid_employee;
INSERT INTO accounts_tchats (tchat_tchatuuid, account_useruuid) VALUES (tchat_uuid_employee, '784b9cbd-acfd-4aa0-8eb9-57561fba2bf9');
END $$;