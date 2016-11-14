/**
 * 
 */
package com.jcg.jaxb.json;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class UnmarshallerDemo {

	/**
	 * @param args
	 * @throws JAXBException
	 *             Unmarshaller JSON to POJO using EclipseLink MOXy
	 */
	public static void main(String[] args) throws JAXBException {

		// Create a JaxBContext
		JAXBContext jc = JAXBContext.newInstance(Person.class);

		// Create the Unmarshaller Object using the JaxB Context
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		// Set the Unmarshaller media type to JSON or XML
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,
				"application/json");

		// Set it to true if you need to include the JSON root element in the
		// JSON input
		unmarshaller
				.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

		// Create the StreamSource by creating StringReader using the JSON input
		StreamSource json = new StreamSource(
				new StringReader(
						//"{\"employee\":{\"id\":1,\"name\":\"Ashraf\",\"skills\":[\"java\",\"sql\"]}}"));
						"{\"age\":21,\"name\":\"John\"}"));

		//"{\"employee\":{\"name\":\"John\",\"age\":\"21\"}"));
		// Getting the employee pojo again from the json
		Person person = unmarshaller.unmarshal(json, Person.class)
				.getValue();

		// Print the employee data to console
		System.out.println("Employee Id: " + person.getAge());
		System.out.println("\nEmployee Name: " + person.getName());

	}

}
