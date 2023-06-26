package com.evans.requests.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResponseVacancy {

	private String name;
	private String status;
	private String descripcion;
	private BigDecimal salary;
	private LocalDate publicationDate;
	private String image;
	private String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ResponseVacancy [name=" + name + ", status=" + status + ", descripcion=" + descripcion + ", salary="
				+ salary + ", publicationDate=" + publicationDate + ", image=" + image + ", details=" + details + "]";
	}

}
