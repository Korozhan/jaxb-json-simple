package com.jcg.jaxb.json;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class JaxbUtilsTest {
    @Test
    public void testUnmarshall() throws JAXBException {
        String source = "<person><age>19</age><name>Smith</name></person>";
        Person person = JaxbUtils.unmarshall(Person.class, source);
        Assert.assertEquals(19, person.getAge());
        Assert.assertEquals("Smith", person.getName());
    }
    @Test
    public void testUnmarshallJSON() throws JAXBException {
        //String path = "person.json";
        String path = "{\"age\":21,\"name\":\"John\"}}";
        Person person = JaxbUtils.unmarshallJSON(Person.class, path);
        System.out.println("Employee Id: " + person.getAge());
        System.out.println("\nEmployee Name: " + person.getName());
        Assert.assertEquals(21, person.getAge());
        Assert.assertEquals("John", person.getName());
    }
}
