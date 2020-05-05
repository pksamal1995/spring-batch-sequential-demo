package com.morganstanley.batch.sequential.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.morganstanley.batch.sequential.demo.entities.Book;
import com.morganstanley.batch.sequential.demo.entities.Employee;
import com.morganstanley.batch.sequential.demo.entities.Library;
import com.morganstanley.batch.sequential.demo.entities.Product;
import com.morganstanley.batch.sequential.demo.entities.Student;

@Configuration
@Import(value = { BatchReaderConfig.class, BatchWriterConfig.class })
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	private JdbcCursorItemReader<Book> bookReader;
	private JdbcCursorItemReader<Library> libraryReader;
	private JdbcCursorItemReader<Product> productReader;
	private JdbcCursorItemReader<Student> studentReader;
	private JdbcCursorItemReader<Employee> employeeReader;
	private StaxEventItemWriter<Employee> employeeWriter;
	private StaxEventItemWriter<Book> bookWriter;
	private StaxEventItemWriter<Library> libraryWriter;
	private StaxEventItemWriter<Product> productWriter;
	private StaxEventItemWriter<Student> studentWriter;
	
	@Autowired
	public BatchConfig(JdbcCursorItemReader<Book> bookReader, JdbcCursorItemReader<Library> libraryReader,
			JdbcCursorItemReader<Product> productReader, JdbcCursorItemReader<Student> studentReader,
			JdbcCursorItemReader<Employee> employeeReader, StaxEventItemWriter<Employee> employeeWriter,
			StaxEventItemWriter<Book> bookWriter, StaxEventItemWriter<Library> libraryWriter,
			StaxEventItemWriter<Product> productWriter, StaxEventItemWriter<Student> studentWriter) {
		this.bookReader = bookReader;
		this.libraryReader = libraryReader;
		this.productReader = productReader;
		this.studentReader = studentReader;
		this.employeeReader = employeeReader;
		this.employeeWriter = employeeWriter;
		this.bookWriter = bookWriter;
		this.libraryWriter = libraryWriter;
		this.productWriter = productWriter;
		this.studentWriter = studentWriter;
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("seq-read-write")
				.incrementer(new RunIdIncrementer())
				.start(stepEmp())
				.next(stepStd())
				.next(stepProd())
				.next(stepLib())
				.next(stepBook())
				.build();
	}

	private Step stepEmp() {
		return stepBuilderFactory.get("DB->Employee").<Employee, Employee>chunk(100).reader(employeeReader)
				.writer(employeeWriter).build();
	}

	private Step stepStd() {

		return stepBuilderFactory.get("DB->Student").<Student, Student>chunk(100).reader(studentReader)
				.writer(studentWriter).build();
	}

	private Step stepProd() {

		return stepBuilderFactory.get("DB->Product").<Product, Product>chunk(100).reader(productReader)
				.writer(productWriter).build();
	}

	private Step stepLib() {

		return stepBuilderFactory.get("DB->Library").<Library, Library>chunk(100).reader(libraryReader)
				.writer(libraryWriter).build();
	}

	private Step stepBook() {

		return stepBuilderFactory.get("DB->Book").<Book, Book>chunk(50).reader(bookReader).writer(bookWriter).build();
	}
	
}
