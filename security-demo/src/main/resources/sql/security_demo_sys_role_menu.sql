CREATE TABLE sys_role_menu
(
    pk_id   int AUTO_INCREMENT
        PRIMARY KEY,
    role_id int NULL,
    menu_id int NULL,
    version int NULL COMMENT '乐观锁'
);

INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (1, 1, 1, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (2, 1, 2, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (3, 1, 3, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (4, 1, 4, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (5, 1, 5, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (6, 2, 4, null);
INSERT INTO security_demo.sys_role_menu (pk_id, role_id, menu_id, version) VALUES (7, 2, 5, null);