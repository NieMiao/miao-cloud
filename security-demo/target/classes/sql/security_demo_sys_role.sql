CREATE TABLE sys_role
(
    pk_id       int AUTO_INCREMENT COMMENT '主键ID'
        PRIMARY KEY,
    role_code   varchar(32)  NOT NULL COMMENT '角色code',
    role_desc   varchar(512) NULL COMMENT '角色描述',
    sort        int          NULL COMMENT '顺序',
    enabled     int          NULL COMMENT '状态（0禁用，1启用）',
    version     int          NULL COMMENT '乐观锁',
    create_by   varchar(32)  NULL COMMENT '创建人',
    create_time datetime     NULL COMMENT '创建时间',
    update_by   varchar(32)  NULL COMMENT '更新人',
    update_time datetime     NULL COMMENT '更新时间'
)
    COMMENT '角色表';

INSERT INTO security_demo.sys_role (pk_id, role_code, role_desc, sort, enabled, version, create_by, create_time, update_by, update_time) VALUES (1, 'ROLE_admin', '管理员用户', 1, 1, null, null, null, null, null);
INSERT INTO security_demo.sys_role (pk_id, role_code, role_desc, sort, enabled, version, create_by, create_time, update_by, update_time) VALUES (2, 'ROLE_common', '普通用户', 1, 1, null, null, null, null, null);