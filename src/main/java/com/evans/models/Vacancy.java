package com.evans.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacancies")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

	@Column(name = "status", nullable = false, length = 20)
	private String status;

	@Column(name = "publication_date", nullable = false)
	private LocalDate publicationDate;

	@Column(name = "salary", nullable = false, precision = 15, scale = 2)
	private BigDecimal salary;

	@Column(name = "image", nullable = false, length = 255)
	private String image = "no-image.jpg";

	@Column(name = "details", nullable = false, length = 1000)
	private String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Vacancy [name=" + name + ", description=" + description + ", status=" + status + ", publicationDate="
				+ publicationDate + ", salary=" + salary + ", image=" + image + ", details=" + details + "]";
	}

}
