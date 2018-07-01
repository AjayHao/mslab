-- 资讯采集：企业控股信息
create table COMBS_ZXCJ_QYKGXX
(
  id               VARCHAR2(36) not null,
  ent_id           VARCHAR2(20),
  ent_name         VARCHAR2(100),
  pull_date       VARCHAR2(10),
  subject_type     VARCHAR2(10),
  id_card          VARCHAR2(30),
  cer_type         VARCHAR2(10),
  final_ent_name   VARCHAR2(100),
  address          VARCHAR2(600),
  final_ratio     NUMBER(7,4),
  final_subs_num  NUMBER(17,4),
  final_acc_num  NUMBER(17,4),
  ratio_road      VARCHAR2(2000),
  position          VARCHAR2(64),
  capital_chain  VARCHAR2(3000),
  unique_token    VARCHAR2(36) default '0' not null,
  created_at       TIMESTAMP(6) default systimestamp,
  creator          VARCHAR2(20) default 'system',
  updated_at      TIMESTAMP(6) default systimestamp,
  updater         VARCHAR2(20) default 'system',
  is_delete        NUMBER(1) default 0 not null
)
tablespace AJAY_DATA;
-- Add comments to the table
comment on table COMBS_ZXCJ_QYKGXX
  is '数据采集-企业控股信息';
-- Add comments to the columns
comment on column COMBS_ZXCJ_QYKGXX.id
  is '物理主键';
comment on column COMBS_ZXCJ_QYKGXX.ent_id
  is '企业id(元素)';
comment on column COMBS_ZXCJ_QYKGXX.pull_date
  is '拉取时间';
  comment on column COMBS_ZXCJ_QYKGXX.ent_name
  is '企业名称';
comment on column COMBS_ZXCJ_QYKGXX.subject_type
  is '控股主体类型';
comment on column COMBS_ZXCJ_QYKGXX.id_card
  is '证件号码';
comment on column COMBS_ZXCJ_QYKGXX.cer_type
  is '证件类型';
comment on column COMBS_ZXCJ_QYKGXX.final_ent_name
  is '受益人姓名';
comment on column COMBS_ZXCJ_QYKGXX.address
  is '地址';
comment on column COMBS_ZXCJ_QYKGXX.final_ratio
  is '最终占比';
comment on column COMBS_ZXCJ_QYKGXX.final_subs_num
  is '最终认缴';
comment on column COMBS_ZXCJ_QYKGXX.final_acc_num
  is '最终实缴';
comment on column COMBS_ZXCJ_QYKGXX.ratio_road
  is '出资计算过程';
comment on column COMBS_ZXCJ_QYKGXX.position
  is '职位';
comment on column COMBS_ZXCJ_QYKGXX.capital_chain
  is '出资链';
comment on column COMBS_ZXCJ_QYKGXX.unique_token
  is '唯一性控制 软删除后翻转为id';
comment on column COMBS_ZXCJ_QYKGXX.created_at
  is '创建日期';
comment on column COMBS_ZXCJ_QYKGXX.creator
  is '创建人';
comment on column COMBS_ZXCJ_QYKGXX.updated_at
  is '修改日期';
comment on column COMBS_ZXCJ_QYKGXX.updater
  is '修改人';
comment on column COMBS_ZXCJ_QYKGXX.is_delete
  is '是否失效 0-否 1-是';
-- Create/Recreate indexes
create index IDX_COMBS_ZXCJ_QYKGXX_1 on COMBS_ZXCJ_QYKGXX (FINAL_ENT_NAME)
  tablespace AJAY_IDX;
create index IDX_COMBS_ZXCJ_QYKGXX_2 on COMBS_ZXCJ_QYKGXX (ENT_NAME)
  tablespace AJAY_IDX;
-- Create/Recreate primary, unique and foreign key constraints
alter table COMBS_ZXCJ_QYKGXX
  add constraint PK_COMBS_ZXCJ_QYKGXX primary key (ID)
  using index
  tablespace AJAY_IDX;
alter table COMBS_ZXCJ_QYKGXX
  add constraint UK_COMBS_ZXCJ_QYKGXX_1 unique (ENT_ID, UNIQUE_TOKEN, IS_DELETE)
  using index
  tablespace AJAY_IDX;
