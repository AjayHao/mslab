package com.ajayhao.workshop;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/7/13.
 */
public class PersonVO implements Serializable,Cloneable{

    private static Long l = 9999L;

    private int id;
    private String name;
    private int age;
    private String team;

    public PersonVO() {}

    public PersonVO(int id) {
        this.id = id;
        this.name = "Anonymity";
    }

    public PersonVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", team='" + team + '\'' +
                '}';
    }
}
