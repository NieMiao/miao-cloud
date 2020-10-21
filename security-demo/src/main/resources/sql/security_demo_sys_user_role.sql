CREATE TABLE sys_user_role
(
    pk_id   int AUTO_INCREMENT
        PRIMARY KEY,
    user_id int NULL,
    role_id int NULL,
    version int NULL COMMENT '乐观锁'
);

INSERT INTO security_demo.sys_user_role (pk_id, user_id, role_id, version) VALUES (1, 1, 1, null);
INSERT INTO security_demo.sys_user_role (pk_id, user_id, role_id, version) VALUES (2, 2, 2, null);