package com.ajayhao.simpleboot.test.annotation;

import com.ajayhao.simpleboot.demos.PersonDO;
import com.ajayhao.simpleboot.demos.annotation.DBMappingTool;
import org.testng.annotations.Test;

/**
 * Created by AjayHao on 2018/2/12.
 */
public class TestDBMappingTool {


    @Test
    public void testQuery(){
        DBMappingTool<PersonDO> personMapping = new DBMappingTool();
        PersonDO personDO = new PersonDO();
        personDO.setId(1);
        personDO.setAge(18);
        personDO.setCity("Shanghai");
        personDO.setName("ajay");
        String querySql = personMapping.query(personDO);
        System.out.println(querySql);
    }
}
