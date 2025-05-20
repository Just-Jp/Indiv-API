package org.serratec.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@NotBlank
	@Column(nullable = false)
	private String rua;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@NotBlank
	@Column(nullable = false)
	private String estado;
		
	@NotBlank
	@Size(max = 9)
	@Column(nullable = false, length = 9)
	private String cep;

	public Endereco(String rua, String cidade, String estado, String cep) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	} 
	
	public Endereco() {
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}	
}