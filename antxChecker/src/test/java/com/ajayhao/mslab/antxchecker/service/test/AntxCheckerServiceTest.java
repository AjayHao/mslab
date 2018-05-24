package com.ajayhao.mslab.antxchecker.service.test;

import com.ajayhao.mslab.antxchecker.service.impl.AntxCheckerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by AjayHao on 2018/2/15.
 */

@Test
@ContextConfiguration(classes = {AntxCheckerServiceImpl.class})
@ActiveProfiles("dev")
public class AntxCheckerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AntxCheckerServiceImpl antxCheckerService;

    @Test
    public void testAntxCheckerServiceNotNull(){
        Assert.assertNotNull(antxCheckerService);
    }

}
