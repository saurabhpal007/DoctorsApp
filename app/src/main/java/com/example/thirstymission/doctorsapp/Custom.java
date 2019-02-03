package com.example.thirstymission.doctorsapp;

public class Custom {

    private int id;
    private String name;
    private String age;

    public Custom(){}

    public Custom(String name,String age){
        this.name=name;
        this.age=age;
    }

    public Custom(int id,String name,String age){
        this.id=id;
        this.name=name;
        this.age=age;
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
    public String getage() {
        return age;
    }
    public void setage(String age) {
        this.age = age;
    }
}
