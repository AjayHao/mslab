-- 资讯采集 工商信息
-- Create table
create table COMBS_ZXCJ_GSXX
(
  id               VARCHAR2(36) not null,
  ent_id           VARCHAR2(20),
  ent_name         VARCHAR2(100),
  pull_date       VARCHAR2(10),
  reg_no           VARCHAR2(50),
  ori_reg_no       VARCHAR2(50),
  credit_code      VARCHAR2(30),
  fr_name          VARCHAR2(100),
  reg_cap          NUMBER(15,2),
  reg_cap_cur      VARCHAR2(64),
  rec_cap          NUMBER(15,2),
  rec_cap_cur      VARCHAR2(64),
  ent_status       VARCHAR2(64),
  ent_type         VARCHAR2(64),
  es_date          VARCHAR2(10),
  op_from          VARCHAR2(10),
  op_to            VARCHAR2(10),
  reg_addr         VARCHAR2(600),
  reg_org          VARCHAR2(64),
  reg_org_code     VARCHAR2(20),
  reg_org_province VARCHAR2(20),
  emp_num          NUMBER(10),
  tel              VARCHAR2(20),
  op_location      VARCHAR2(600),
  industry_code    VARCHAR2(100),
  industry_name    VARCHAR2(200),
  op_scope         VARCHAR2(3000),
  unique_token    VARCHAR2(36) default '0' not null,
  created_at       TIMESTAMP(6) default systimestamp,
  creator          VARCHAR2(20) default 'system',
  updated_at      TIMESTAMP(6) default systimestamp,
  updater         VARCHAR2(20) default 'system',
  is_delete        NUMBER(1) default 0 not null
)
tablespace AJAY_DATA;
-- Add comments to the table
comment on table COMBS_ZXCJ_GSXX
  is '资讯采集-工商信息';
-- Add comments to the columns
comment on column COMBS_ZXCJ_GSXX.id
  is '物理主键';
comment on column COMBS_ZXCJ_GSXX.ent_id
  is '企业id(元素)';
comment on column COMBS_ZXCJ_GSXX.ent_name
  is '企业名称';
comment on column COMBS_ZXCJ_GSXX.pull_date
  is '抓取日期';
comment on column COMBS_ZXCJ_GSXX.reg_no
  is '注册号';
comment on column COMBS_ZXCJ_GSXX.ori_reg_no
  is '原注册号';
comment on column COMBS_ZXCJ_GSXX.credit_code
  is '统一社会认证编码';
comment on column COMBS_ZXCJ_GSXX.fr_name
  is '法定代表人姓名';
comment on column COMBS_ZXCJ_GSXX.reg_cap
  is '注册资本（万元）';
comment on column COMBS_ZXCJ_GSXX.reg_cap_cur
  is '注册币种';
comment on column COMBS_ZXCJ_GSXX.rec_cap
  is '实缴资本（万元）';
comment on column COMBS_ZXCJ_GSXX.rec_cap_cur
  is '实缴币种';
comment on column COMBS_ZXCJ_GSXX.ent_status
  is '经营状态';
comment on column COMBS_ZXCJ_GSXX.ent_type
  is '机构类型';
comment on column COMBS_ZXCJ_GSXX.es_date
  is '开业日期';
comment on column COMBS_ZXCJ_GSXX.op_from
  is '经营期限自';
comment on column COMBS_ZXCJ_GSXX.op_to
  is '经营期限至';
comment on column COMBS_ZXCJ_GSXX.reg_addr
  is '注册地址';
comment on column COMBS_ZXCJ_GSXX.reg_org
  is '登记机关';
comment on column COMBS_ZXCJ_GSXX.reg_org_code
  is '注册机构行政区号';
comment on column COMBS_ZXCJ_GSXX.reg_org_province
  is '注册机构所在省份';
comment on column COMBS_ZXCJ_GSXX.emp_num
  is '员工人数';
comment on column COMBS_ZXCJ_GSXX.tel
  is '联系电话';
comment on column COMBS_ZXCJ_GSXX.op_location
  is '经营场所';
comment on column COMBS_ZXCJ_GSXX.industry_code
  is '行业门类代码';
comment on column COMBS_ZXCJ_GSXX.industry_name
  is '行业门类名称';
comment on column COMBS_ZXCJ_GSXX.op_scope
  is '经营范围';
comment on column COMBS_ZXCJ_GSXX.unique_token
  is '唯一性控制 软删除后翻转为id';
comment on column COMBS_ZXCJ_GSXX.created_at
  is '创建日期';
comment on column COMBS_ZXCJ_GSXX.creator
  is '创建人';
comment on column COMBS_ZXCJ_GSXX.updated_at
  is '修改日期';
comment on column COMBS_ZXCJ_GSXX.updater
  is '修改人';
comment on column COMBS_ZXCJ_GSXX.is_delete
  is '是否失效 0-否 1-是';
-- Create/Recreate indexes
create index IDX_COMBS_ZXCJ_GSXX_1 on COMBS_ZXCJ_GSXX (ENT_NAME)
  tablespace AJAY_IDX;
-- Create/Recreate primary, unique and foreign key constraints
alter table COMBS_ZXCJ_GSXX
  add constraint PK_COMBS_ZXCJ_GSXX primary key (ID)
  using index
  tablespace AJAY_IDX;
alter table COMBS_ZXCJ_GSXX
  add constraint UK_COMBS_ZXCJ_GSXX_1 unique (ENT_ID, UNIQUE_TOKEN, IS_DELETE)
  using index
  tablespace AJAY_IDX;