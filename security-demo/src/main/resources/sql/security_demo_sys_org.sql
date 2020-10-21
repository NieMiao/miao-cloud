CREATE TABLE sys_org
(
    pk_id       int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    org_name    varchar(32)  NULL COMMENT '组织名称
',
    org_pid     int          NULL COMMENT '父组织ID',
    org_pids    varchar(128) NULL COMMENT '所有父组织',
    org_address varchar(128) NULL COMMENT '组织地址',
    enabled     int          NULL COMMENT '状态（0禁用，1启用',
    org_level   int          NULL COMMENT '组织层级',
    sort        int          NULL COMMENT '排序',
    version     int          NULL COMMENT '乐观锁',
    create_by   varchar(32)  NULL COMMENT '创建人',
    create_time datetime     NULL COMMENT '创建时间',
    update_by   varchar(32)  NULL COMMENT '更新人',
    update_time datetime     NULL COMMENT '更新时间'
);

