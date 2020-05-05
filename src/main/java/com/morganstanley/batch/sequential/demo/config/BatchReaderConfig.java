package com.morganstanley.batch.sequential.demo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.morganstanley.batch.sequential.demo.entities.Book;
import com.morganstanley.batch.sequential.demo.entities.Employee;
import com.morganstanley.batch.sequential.demo.entities.Library;
import com.morganstanley.batch.sequential.demo.entities.Product;
import com.morganstanley.batch.sequential.demo.entities.Student;

@Configuration
public class BatchReaderConfig {
	
	@Autowired
	private DataSource dataSource;

	@Qualifier("bookReader")
	@Bean(destroyMethod = "")
	@StepScope
	public JdbcCursorItemReader<Book> bookReader() {
		JdbcCursorItemReader<Book> bookReader = new JdbcCursorItemReader<>();
		bookReader.setDataSource(dataSource);
		bookReader.setSql("select id, isbn, title, author, publisher, published_year from book");
		bookReader.setRowMapper((rs, rowNum) -> {
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setIsbn(rs.getString("isbn"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			book.setPublishedYear(rs.getInt("published_year"));
			
			//for debugging
			System.out.println("BOOK READ FROM DB "+book);
			return book;
		});
		return bookReader;
	}

	@Qualifier("libraryReader")
	@Bean(destroyMethod = "")
	@StepScope
	public JdbcCursorItemReader<Library> libraryReader() {
		return new JdbcCursorItemReaderBuilder<Library>().name("library-reader")
				.dataSource(dataSource)
				.sql("select id, name, address from library")
				.rowMapper((rs, rowNum) -> {
					Library library = new Library();
					library.setId(rs.getLong("id"));
					library.setName(rs.getString("name"));
					library.setAddress(rs.getString("address"));
					
					//for debugging
					System.out.println("LIBRARY READ FROM DB "+library);
					return library;
				})
				.build();
	}

	@Qualifier("productReader")
	@Bean(destroyMethod = "")
	@StepScope
	public JdbcCursorItemReader<Product> productReader() {
		
		return new JdbcCursorItemReaderBuilder<Product>().name("product-reader")
				.dataSource(dataSource)
				.sql("select id, product_code, product_type, manufacturer, price from product")
				.rowMapper((rs, rowNum) -> {
					Product product = new Product();
					product.setId(rs.getLong("id"));
					product.setProductCode(rs.getString("product_code"));
					product.setProductType(rs.getString("product_type"));
					product.setManufacturer(rs.getString("manufacturer"));
					product.setPrice(rs.getDouble("price"));
					
					//for debugging
					System.out.println("PRODUCT READ FROM DB "+product);
					
					return product;
				}).build();
	}

	@Qualifier("studentReader")
	@Bean(destroyMethod = "")
	@StepScope
	public JdbcCursorItemReader<Student> studentReader() {
		
		return  new JdbcCursorItemReaderBuilder<Student>().name("student-reader")
				.dataSource(dataSource)
				.sql("select id, first_name, last_name, roll_no, department, academic_year, subjects from student")
				.rowMapper((rs, rowNum) -> {
					Student student = new Student();
					
					student.setId(rs.getLong("id"));
					student.setFirstName(rs.getString("first_name"));
					student.setLastName(rs.getString("last_name"));
					student.setRollNo(rs.getString("roll_no"));
					student.setDepartment(rs.getString("department"));
					student.setAcademicYear(rs.getInt("academic_year"));
					student.setSubjects(rs.getString("subjects"));
					
					//for debugging
					System.out.println("STUDENT READ FROM DB "+student);
					
					return student;
				}).build();
					
	}

	@Qualifier("employeeReader")
	@Bean(destroyMethod = "")
	@StepScope
	public JdbcCursorItemReader<Employee> employeeReader() {
		
		return new JdbcCursorItemReaderBuilder<Employee>().name("employee-reader")
				.dataSource(dataSource)
				.sql("select id, first_name, last_name, age, department, ocupation, salary from employee")
				.rowMapper((rs, rowNum) -> {
					Employee employee = new Employee();
					
					employee.setId(rs.getLong("id"));
					employee.setFirstName(rs.getString("first_name"));
					employee.setLastName(rs.getString("last_name"));
					employee.setAge(rs.getInt("age"));
					employee.setDepartment(rs.getString("department"));
					employee.setOcupation(rs.getString("ocupation"));
					employee.setSalary(rs.getDouble("salary"));
					
					//for debugging
					System.out.println("EMPLOYEE READ FROM DB "+employee);
					
					return employee;
				})
				.build();
				
	}


}
