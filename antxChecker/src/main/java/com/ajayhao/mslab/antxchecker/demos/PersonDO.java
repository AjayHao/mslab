package com.ajayhao.mslab.antxchecker.demos;

import com.ajayhao.mslab.antxchecker.demos.annotation.Column;
import com.ajayhao.mslab.antxchecker.demos.annotation.Table;

import java.io.Serializable;

/**
 * Created by AjayHao on 2018/2/12.
 */
@Table("user")
public class PersonDO implements Serializable{

    private int id;

    @Column
    private int age;

    @Column("userName")
    private String name;

    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
