package com.jcg.jaxb.json;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlRootElement(name = "person")
public class Person {
    private int age;
    private String name;


    public String getName() { return name;  }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
