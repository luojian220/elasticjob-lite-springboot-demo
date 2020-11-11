package com.example.demo.elasticjob.model;

/**
 * @author luojian
 * @version 1.0
 * @date 2020年11月10日 17:17
 */
public class Foo {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                '}';
    }
}
