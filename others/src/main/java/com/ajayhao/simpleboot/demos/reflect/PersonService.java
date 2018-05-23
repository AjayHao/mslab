package com.ajayhao.simpleboot.demos.reflect;

import com.ajayhao.simpleboot.demos.PersonVO;

/**
 * Created by haozhenjie on 2017/10/2.
 */
public interface PersonService {

    PersonVO buildVO(int id, String name);
}
