package com.evans.models;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "vacancies")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 50)
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max = 50)
	private String name;

	@Column(name = "description", nullable = false, length = 200)
	@NotBlank(message = "La descripcion es obligatoria")
	//@Min(value = 10, message = "La cantidad minima de caracteres permitida es 10")
	//@Max(value = 255, message = "La cantidad maxima de caracteres permitida es 255")
	@Size(min = 10, max = 255, message = "Caracteres: Min: 10, Max: 255")
	private String description;

	@Column(name = "status", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "El status no puede ser null")
	private Status status;

	@Column(name = "publication_date", nullable = false)
	@NotNull(message = "La fecha no puede ser null")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date publicationDate;

	@Column(name = "salary", nullable = false, precision = 15, scale = 2)
	@NotNull(message = "El salario no debe ser null")
	@DecimalMin(message = "El valor minimo debe ser 0", value = "0.00")
	private BigDecimal salary;

	@Column(name = "image", nullable = false, length = 255)
	@NotBlank(message = "La imagen es obligatoria")
	private String image = "no-image.jpg";

	@Column(name = "details", nullable = false, length = 1000)
	@NotBlank(message = "Los detalles son obligatorios")
	//@Min(value = 50, message = "La cantidad minima de caracteres es 50")
	//@Max(value = 1000, message = "La cantidad maxima de caracteres es 1000")
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
