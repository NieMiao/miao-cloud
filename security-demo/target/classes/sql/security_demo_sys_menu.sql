CREATE TABLE sys_menu
(
    pk_id       int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    menu_name   varchar(32)  NULL COMMENT '菜单名称',
    menu_pid    int          NULL COMMENT '父菜单ID',
    menu_pids   varchar(128) NULL COMMENT '所有父菜单',
    menu_url    varchar(128) NULL COMMENT '资源路径',
    enabled     int          NULL COMMENT '状态（0禁用，1启用',
    menu_level  int          NULL COMMENT '菜单层级',
    sort        int          NULL COMMENT '排序',
    version     int          NULL COMMENT '乐观锁',
    create_by   varchar(32)  NULL COMMENT '创建人',
    create_time datetime     NULL COMMENT '创建时间',
    update_by   varchar(32)  NULL COMMENT '更新人',
    update_time datetime     NULL COMMENT '更新时间'
)
    COMMENT '权限表';

INSERT INTO security_demo.sys_menu (pk_id, menu_name, menu_pid, menu_pids, menu_url, enabled, menu_level, sort, version, create_by, create_time, update_by, update_time) VALUES (1, '日志管理', 3, '3', 'sys:log', 1, 2, 1, null, null, null, null, null);
INSERT INTO security_demo.sys_menu (pk_id, menu_name, menu_pid, menu_pids, menu_url, enabled, menu_level, sort, version, create_by, create_time, update_by, update_time) VALUES (2, '用户管理', 3, '3', 'sys:user', 1, 2, 2, null, null, null, null, null);
INSERT INTO security_demo.sys_menu (pk_id, menu_name, menu_pid, menu_pids, menu_url, enabled, menu_level, sort, version, create_by, create_time, update_by, update_time) VALUES (3, '系统管理', 0, '0', 'sys:all', 1, 1, 0, null, null, null, null, null);
INSERT INTO security_demo.sys_menu (pk_id, menu_name, menu_pid, menu_pids, menu_url, enabled, menu_level, sort, version, create_by, create_time, update_by, update_time) VALUES (4, '业务系统A', 3, '3', 'business:A', 1, 2, 3, null, null, null, null, null);
INSERT INTO security_demo.sys_menu (pk_id, menu_name, menu_pid, menu_pids, menu_url, enabled, menu_level, sort, version, create_by, create_time, update_by, update_time) VALUES (5, '业务系统B', 3, '3', 'business:B', 1, 2, 4, null, null, null, null, null);