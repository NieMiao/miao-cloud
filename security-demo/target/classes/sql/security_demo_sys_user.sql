CREATE TABLE sys_user
(
    pk_id       int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    username    varchar(32)  NOT NULL COMMENT '用户名',
    password    varchar(128) NOT NULL COMMENT '密码',
    phone       varchar(32)  NULL COMMENT '电话',
    org_id      varchar(32)  NULL COMMENT '组织结构ID',
    enabled     int          NULL COMMENT '状态（0禁用，1启用）',
    create_by   varchar(32)  NULL COMMENT '创建人',
    create_time datetime     NULL COMMENT '创建时间',
    update_by   varchar(32)  NULL COMMENT '更新人',
    update_time datetime     NULL COMMENT '更新时间'
)
    COMMENT '用户表';

INSERT INTO security_demo.sys_user (pk_id, username, password, phone, org_id, enabled, create_by, create_time, update_by, update_time) VALUES (1, 'admin', '$2a$10$oy4dUHDzD1toknm17LR1uOtRan4ioXRRhcWesxSB7qsao2tzxz.5e', '123456789', null, 1, null, null, null, null);
INSERT INTO security_demo.sys_user (pk_id, username, password, phone, org_id, enabled, create_by, create_time, update_by, update_time) VALUES (2, 'zhangsan', '$2a$10$oy4dUHDzD1toknm17LR1uOtRan4ioXRRhcWesxSB7qsao2tzxz.5e', '123456789', null, 1, null, null, null, null);