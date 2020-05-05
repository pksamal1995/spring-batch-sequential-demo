package com.morganstanley.batch.sequential.demo.config;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.morganstanley.batch.sequential.demo.entities.Book;
import com.morganstanley.batch.sequential.demo.entities.Employee;
import com.morganstanley.batch.sequential.demo.entities.Library;
import com.morganstanley.batch.sequential.demo.entities.Product;
import com.morganstanley.batch.sequential.demo.entities.Student;


@Configuration
public class BatchWriterConfig {

	@Value("book")
	private String book;

	@Value("employee")
	private String employee;

	@Value("library")
	private String library;

	@Value("product")
	private String product;

	@Value("student")
	private String student;

	@Qualifier("bookWriter")
	@Bean
	public StaxEventItemWriter<Book> bookWriter() {

		return new StaxEventItemWriterBuilder<Book>().name("BOOK-WRITER")
				.resource(new FileSystemResource(book)).overwriteOutput(true)
				.rootTagName("book").marshaller(marshaller(Book.class))
				.build();
	}

	@Qualifier("libraryWriter")
	@Bean
	public StaxEventItemWriter<Library> libraryWriter() {

		return new StaxEventItemWriterBuilder<Library>().name("library-writer")
				.resource(new FileSystemResource(library)).overwriteOutput(true)
				.rootTagName("library").marshaller(marshaller(Library.class))
				.build();
	}

	@Qualifier("productWriter")
	@Bean
	public StaxEventItemWriter<Product> productWriter() {

		return new StaxEventItemWriterBuilder<Product>().name("product-writer")
				.resource(new FileSystemResource(product)).overwriteOutput(true)
				.rootTagName("product").marshaller(marshaller(Product.class))
				.build();
	}

	@Qualifier("studentWriter")
	@Bean
	public StaxEventItemWriter<Student> studentWriter() {

		return new StaxEventItemWriterBuilder<Student>().name("Student-writer")
				.resource(new FileSystemResource(student)).overwriteOutput(true)
				.rootTagName("student").marshaller(marshaller(Student.class))
				.build();
	}

	@Qualifier("employeeWriter")
	@Bean
	public StaxEventItemWriter<Employee> employeeWriter() {

		return new StaxEventItemWriterBuilder<Employee>().name("Employee-writer")
				.resource(new FileSystemResource(employee)).overwriteOutput(true)
				.rootTagName("employee").marshaller(marshaller(Employee.class))
				.build();
	}

	private Jaxb2Marshaller marshaller(Class<?> clazz) {
		
		Jaxb2Marshaller bookMarshaller = new Jaxb2Marshaller();
		bookMarshaller.setClassesToBeBound(clazz);
		return bookMarshaller;
	}

}
