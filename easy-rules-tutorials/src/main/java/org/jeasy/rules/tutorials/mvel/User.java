package org.jeasy.rules.tutorials.mvel;


import java.util.Map;

public class User {
    private Integer age;
    private String name;
    private Map<Object,Object> userinfo;
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Object, Object> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Map<Object, Object> userinfo) {
        this.userinfo = userinfo;
    }
}
