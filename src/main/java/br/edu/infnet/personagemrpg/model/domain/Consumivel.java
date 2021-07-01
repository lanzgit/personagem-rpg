package br.edu.infnet.personagemrpg.model.domain;

public class Consumivel extends Equipamento {
	private boolean efeito;
	private String descricao;
	private int atributo;

	public Consumivel(String nome, float valor, float peso, boolean efeito, String descricao, int atributo) {
		super(nome, valor, peso);
		this.efeito = efeito;
		this.descricao = descricao;
		this.atributo = atributo;
	}

	public boolean isEfeito() {
		return efeito;
	}

	public void setEfeito(boolean efeito) {
		this.efeito = efeito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAtributo() {
		return atributo;
	}

	public void setAtributo(int atributo) {
		this.atributo = atributo;
	}

	@Override
	public void calcularAtributosSecundarios() {
		
	}


	
}
