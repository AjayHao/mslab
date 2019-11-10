package com.ajayhao.workshop.reflect;

import com.ajayhao.workshop.PersonVO;

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
