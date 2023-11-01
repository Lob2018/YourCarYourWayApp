-- Deleting tables
DROP TABLE IF EXISTS tchat;
DROP TABLE IF EXISTS accounts_tchats;

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