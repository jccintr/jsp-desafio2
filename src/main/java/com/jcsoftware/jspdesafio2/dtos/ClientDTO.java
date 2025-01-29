package com.jcsoftware.jspdesafio2.dtos;

import java.time.LocalDate;

import com.jcsoftware.jspdesafio2.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class ClientDTO {

	private Long id;
	@NotBlank(message = "Campo requerido")
	private String name;
	private String cpf;
	private Double income;
	@PastOrPresent(message="Data de nascimento deve ser igual ou inferior a data atual")
	private LocalDate birthDate;
	private Integer children;

	public ClientDTO() {

	}

	public ClientDTO(Client c) {
		this.id = c.getId();
		this.name = c.getName();
		this.cpf = c.getCpf();
		this.income = c.getIncome();
		this.birthDate = c.getBirthDate();
		this.children = c.getChildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

}
