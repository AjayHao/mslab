-- 资讯采集 股权明细
-- Create table
create table COMBS_ZXCJ_GQMX
(
  id               VARCHAR2(36) not null,
  ent_id           VARCHAR2(20),
  ent_name         VARCHAR2(100),
  pull_date        VARCHAR2(10),
  subject_type     VARCHAR2(10),
  trace_level      NUMBER(3) not null,
  node_id          VARCHAR2(36);
  parent_node_id   VARCHAR2(36);
  node_name        VARCHAR2(100),
  tags              VARCHAR2(10),
  con_name         VARCHAR2(100),
  con_prop          NUMBER(9,6),
  real_con_prop    NUMBER(9,6),
  position         VARCHAR2(64),
  id_card          VARCHAR2(30),
  cer_type         VARCHAR2(10),
  address          VARCHAR2(600),
  unique_token    VARCHAR2(36) default '0' not null,
  created_at       TIMESTAMP(6) default systimestamp,
  creator          VARCHAR2(20) default 'system',
  updated_at      TIMESTAMP(6) default systimestamp,
  updater         VARCHAR2(20) default 'system',
  is_delete        NUMBER(1) default 0 not null
)
tablespace AJAY_DATA;
-- Add comments to the table
comment on table COMBS_ZXCJ_GQMX
  is '资讯采集-工商信息';
-- Add comments to the columns
comment on column COMBS_ZXCJ_GQMX.id
  is '物理主键';
comment on column COMBS_ZXCJ_GQMX.ent_id
  is '企业id(元素)';
comment on column COMBS_ZXCJ_GQMX.ent_name
  is '企业名称';
comment on column COMBS_ZXCJ_GQMX.pull_date
  is '抓取日期';
comment on column COMBS_ZXCJ_GQMX.subject_type
  is '持股主体类型';
comment on column COMBS_ZXCJ_GQMX.trace_level
  is '所在路径层数(自下到上)';
comment on column COMBS_ZXCJ_GQMX.node_id
  is '节点ID';
comment on column COMBS_ZXCJ_GQMX.parent_node_id
  is '父节点ID';
comment on column COMBS_ZXCJ_GQMX.node_name
  is '节点名称';
comment on column COMBS_ZXCJ_GQMX.tags
  is '节点类型';
comment on column COMBS_ZXCJ_GQMX.con_name
  is '上级节点名称';
comment on column COMBS_ZXCJ_GQMX.con_prop
  is '上级节点投资比例';
comment on column COMBS_ZXCJ_GQMX.real_con_prop
  is '目标节点投资比例';
comment on column COMBS_ZXCJ_GQMX.position
  is '职位';
comment on column COMBS_ZXCJ_GQMX.id_card
  is '证件号码';
comment on column COMBS_ZXCJ_GQMX.cer_type
  is '证件类型';
comment on column COMBS_ZXCJ_GQMX.address
  is '地址';
comment on column COMBS_ZXCJ_GQMX.unique_token
  is '唯一性控制 软删除后翻转为id';
comment on column COMBS_ZXCJ_GQMX.created_at
  is '创建日期';
comment on column COMBS_ZXCJ_GQMX.creator
  is '创建人';
comment on column COMBS_ZXCJ_GQMX.updated_at
  is '修改日期';
comment on column COMBS_ZXCJ_GQMX.updater
  is '修改人';
comment on column COMBS_ZXCJ_GQMX.is_delete
  is '是否失效 0-否 1-是';
-- Create/Recreate indexes
create index IDX_COMBS_ZXCJ_GQMX_1 on COMBS_ZXCJ_GQMX (ENT_NAME)
  tablespace AJAY_IDX;
create index IDX_COMBS_ZXCJ_GQMX_2 on COMBS_ZXCJ_GQMX (NODE_NAME)
  tablespace AJAY_IDX;
create index IDX_COMBS_ZXCJ_GQMX_3 on COMBS_ZXCJ_GQMX (ent_id)
  tablespace AJAY_IDX;
-- Create/Recreate primary, unique and foreign key constraints
alter table COMBS_ZXCJ_GQMX
  add constraint PK_COMBS_ZXCJ_GQMX primary key (ID)
  using index
  tablespace AJAY_IDX;
