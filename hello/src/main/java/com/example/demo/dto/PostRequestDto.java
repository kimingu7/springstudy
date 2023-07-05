package com.example.demo.dto;

public class PostRequestDto {

    private String name;
    private int age;
    private String account;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account='" + account + '\'' +
                '}';
    }
}
