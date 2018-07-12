-- 资讯采集 股权明细
-- Create table
CREATE TABLE COMBS_ZXCJ_GQMX
(
  id             VARCHAR2(36)             NOT NULL,
  ent_id         VARCHAR2(20),
  ent_name       VARCHAR2(100),
  pull_date      VARCHAR2(10),
  subject_type   VARCHAR2(10),
  trace_level    NUMBER(3)                NOT NULL,
  node_id        VARCHAR2(36),
  parent_node_id VARCHAR2(36),
  node_name      VARCHAR2(100),
  tags           VARCHAR2(10),
  con_name       VARCHAR2(100),
  con_prop       NUMBER(9, 6),
  real_con_prop  NUMBER(9, 6),
  reg_amt        NUMBER(15, 2),
  position       VARCHAR2(64),
  id_card        VARCHAR2(30),
  cer_type       VARCHAR2(10),
  address        VARCHAR2(600),
  unique_token   VARCHAR2(36) DEFAULT '0' NOT NULL,
  created_at     NUMBER(15)               NOT NULL,
  creator        VARCHAR2(20) DEFAULT 'system',
  updated_at     NUMBER(15)               NOT NULL,
  updater        VARCHAR2(20) DEFAULT 'system',
  is_delete      NUMBER(1) DEFAULT 0      NOT NULL
)
TABLESPACE AJAY_DATA;
-- Add comments to the table
COMMENT ON TABLE COMBS_ZXCJ_GQMX
IS '资讯采集-工商信息';
-- Add comments to the columns
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.id
IS '物理主键';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.ent_id
IS '企业id(元素)';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.ent_name
IS '企业名称';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.pull_date
IS '抓取日期';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.subject_type
IS '持股主体类型';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.trace_level
IS '所在路径层数(自下到上)';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.node_id
IS '节点ID';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.parent_node_id
IS '父节点ID';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.node_name
IS '节点名称';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.tags
IS '节点类型';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.con_name
IS '上级节点名称';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.con_prop
IS '上级节点投资比例';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.real_con_prop
IS '目标节点投资比例';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.reg_amt
IS '认缴金额（万元）';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.position
IS '职位';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.id_card
IS '证件号码';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.cer_type
IS '证件类型';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.address
IS '地址';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.unique_token
IS '唯一性控制 软删除后翻转为id';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.created_at
IS '创建日期';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.creator
IS '创建人';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.updated_at
IS '修改日期';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.updater
IS '修改人';
COMMENT ON COLUMN COMBS_ZXCJ_GQMX.is_delete
IS '是否失效 0-否 1-是';
-- Create/Recreate indexes
CREATE INDEX IDX_COMBS_ZXCJ_GQMX_1 ON COMBS_ZXCJ_GQMX (ENT_NAME)
TABLESPACE AJAY_IDX;
CREATE INDEX IDX_COMBS_ZXCJ_GQMX_2 ON COMBS_ZXCJ_GQMX (NODE_NAME)
TABLESPACE AJAY_IDX;
CREATE INDEX IDX_COMBS_ZXCJ_GQMX_3 ON COMBS_ZXCJ_GQMX (ent_id)
TABLESPACE AJAY_IDX;
-- Create/Recreate primary, unique and foreign key constraints
ALTER TABLE COMBS_ZXCJ_GQMX
  ADD CONSTRAINT PK_COMBS_ZXCJ_GQMX PRIMARY KEY (ID)
  USING INDEX
  TABLESPACE AJAY_IDX;
