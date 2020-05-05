package com.morganstanley.batch.sequential.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement(name = "book")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "id")
	private Long id;
	@XmlElement(name = "isbn")
	private String isbn;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "author")
	private String author;
	@XmlElement(name = "publisher")
	private String publisher;
	@XmlElement(name = "published-year")
	@Column(name = "published_year")
	private Integer publishedYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", pulisher="
				+ publisher + ", publishedYear=" + publishedYear + "]";
	}

	public Book(String isbn, String title, String author, String pulisher, Integer publishedYear) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = pulisher;
		this.publishedYear = publishedYear;
	}

	public Book() {
		super();
	}

}
