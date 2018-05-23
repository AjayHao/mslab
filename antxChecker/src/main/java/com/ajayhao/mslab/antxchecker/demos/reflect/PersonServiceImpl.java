package com.ajayhao.mslab.antxchecker.demos.reflect;

import com.ajayhao.mslab.antxchecker.demos.PersonVO;

/**
 * Created by haozhenjie on 2017/10/2.
 */
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonVO buildVO(int id, String name) {
        PersonVO vo = new PersonVO();
        vo.setId(id);
        vo.setName(name);
        return vo;
    }
}
