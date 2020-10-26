CREATE TABLE persistent_logins
(
    username  varchar(64)                         NOT NULL,
    series    varchar(64)                         NOT NULL
        PRIMARY KEY,
    token     varchar(64)                         NOT NULL,
    last_used timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
);

