package br.com.estudos.jpa.projetojpa.model;

public enum TipoCombustivel {

	ALCOOL("Álcool"),
	GASOLINA("Gasolina"),
	DIESEL("Diesel"),
	BICOMBUSTIVEL("Bi-Combustível");
	
	private String descricao;

	private TipoCombustivel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
