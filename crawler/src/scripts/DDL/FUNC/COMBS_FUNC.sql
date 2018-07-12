CREATE OR REPLACE FUNCTION now_milli RETURN NUMBER IS
v_datenumber NUMBER(15);
BEGIN
SELECT TO_NUMBER(SYSDATE -
                TO_DATE('1970-01-01 8:0:0', 'YYYY-MM-DD HH24:MI:SS')) * 24 * 60 * 60 * 1000
 INTO v_datenumber
 FROM DUAL;
 RETURN v_datenumber;
END;
/

CREATE OR REPLACE FUNCTION time_milli(datestr IN VARCHAR2,
                                      dateformat IN VARCHAR2) RETURN NUMBER IS
   v_datenumber NUMBER(15);
BEGIN
SELECT TO_NUMBER(to_date(datestr, dateformat) -
                TO_DATE('1970-01-01 8:0:0', 'YYYY-MM-DD HH24:MI:SS')) * 24 * 60 * 60 * 1000
 INTO v_datenumber
 FROM DUAL;
 RETURN v_datenumber;
END;
