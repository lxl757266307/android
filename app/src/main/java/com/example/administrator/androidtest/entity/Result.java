package com.example.administrator.androidtest.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class Result {
    String message;
    String status;
    List<Person> data;


    public Result() {
    }

    public Result(String message, String status, List<Person> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public List<Person> getData() {
        return data;
    }

    public static class Person {
        String name;
        String age;


        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
