-- 资讯采集 工商信息
-- Create table
CREATE TABLE COMBS_ZXCJ_GSXX
(
  id               VARCHAR2(36)             NOT NULL,
  ent_id           VARCHAR2(20),
  ent_name         VARCHAR2(100),
  pull_date        VARCHAR2(10),
  reg_no           VARCHAR2(50),
  ori_reg_no       VARCHAR2(50),
  credit_code      VARCHAR2(30),
  fr_name          VARCHAR2(100),
  reg_cap          NUMBER(15, 2),
  reg_cap_cur      VARCHAR2(64),
  rec_cap          NUMBER(15, 2),
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
  amac_flag        VARCHAR2(1),
  custody_flag     VARCHAR2(1),
  unique_token     VARCHAR2(36) DEFAULT '0' NOT NULL,
  created_at       TIMESTAMP(6) DEFAULT systimestamp,
  creator          VARCHAR2(20) DEFAULT 'system',
  updated_at       TIMESTAMP(6) DEFAULT systimestamp,
  updater          VARCHAR2(20) DEFAULT 'system',
  is_delete        NUMBER(1) DEFAULT 0      NOT NULL
)
TABLESPACE AJAY_DATA;
-- Add comments to the table
COMMENT ON TABLE COMBS_ZXCJ_GSXX
IS '资讯采集-工商信息';
-- Add comments to the columns
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.id
IS '物理主键';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.ent_id
IS '企业id(元素)';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.ent_name
IS '企业名称';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.pull_date
IS '抓取日期';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_no
IS '注册号';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.ori_reg_no
IS '原注册号';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.credit_code
IS '统一社会认证编码';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.fr_name
IS '法定代表人姓名';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_cap
IS '注册资本（万元）';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_cap_cur
IS '注册币种';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.rec_cap
IS '实缴资本（万元）';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.rec_cap_cur
IS '实缴币种';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.ent_status
IS '经营状态';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.ent_type
IS '机构类型';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.es_date
IS '开业日期';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.op_from
IS '经营期限自';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.op_to
IS '经营期限至';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_addr
IS '注册地址';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_org
IS '登记机关';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_org_code
IS '注册机构行政区号';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.reg_org_province
IS '注册机构所在省份';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.emp_num
IS '员工人数';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.tel
IS '联系电话';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.op_location
IS '经营场所';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.industry_code
IS '行业门类代码';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.industry_name
IS '行业门类名称';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.op_scope
IS '经营范围';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.amac_flag
IS '协会标识 1-是 0-否';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.custody_flag
IS '托管标识 1-是 0-否';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.unique_token
IS '唯一性控制 软删除后翻转为id';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.created_at
IS '创建日期';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.creator
IS '创建人';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.updated_at
IS '修改日期';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.updater
IS '修改人';
COMMENT ON COLUMN COMBS_ZXCJ_GSXX.is_delete
IS '是否失效 0-否 1-是';
-- Create/Recreate indexes
CREATE INDEX IDX_COMBS_ZXCJ_GSXX_1 ON COMBS_ZXCJ_GSXX (ENT_NAME)
TABLESPACE AJAY_IDX;
-- Create/Recreate primary, unique and foreign key constraints
ALTER TABLE COMBS_ZXCJ_GSXX
  ADD CONSTRAINT PK_COMBS_ZXCJ_GSXX PRIMARY KEY (ID)
  USING INDEX
  TABLESPACE AJAY_IDX;
ALTER TABLE COMBS_ZXCJ_GSXX
  ADD CONSTRAINT UK_COMBS_ZXCJ_GSXX_1 UNIQUE (ENT_ID, UNIQUE_TOKEN, IS_DELETE)
  USING INDEX
  TABLESPACE AJAY_IDX;