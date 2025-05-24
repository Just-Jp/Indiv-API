package org.serratec.backend.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Endereco {

    @NotBlank(message = "O CEP não pode estar em branco.")
    private String cep;

    @NotBlank(message = "A rua não pode estar em branco.")
    private String rua;

    @NotBlank(message = "A cidade não pode estar em branco.")
    private String cidade;

    @NotBlank(message = "O estado não pode estar em branco.")
    private String estado;
    
    public Endereco(String cep, String rua, String cidade, String estado) {
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}
    
    public Endereco() {
    }

	public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
}