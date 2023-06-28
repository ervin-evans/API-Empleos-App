package com.evans.requests.responses;

import java.math.BigDecimal;
import java.util.Date;

import com.evans.models.Status;

public class RequestVacancy {

	private Long id;
	private String name;
	private Status status;
	private String description;
	private BigDecimal salary;
	private Date publicationDate;
	private String image;
	private String details;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descripcion) {
		this.description = descripcion;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RequestVacancy [id=" + id + ", name=" + name + ", status=" + status + ", description=" + description
				+ ", salary=" + salary + ", publication_date=" + publicationDate + ", image=" + image + ", details="
				+ details + "]";
	}

}
