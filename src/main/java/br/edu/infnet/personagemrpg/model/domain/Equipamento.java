package br.edu.infnet.personagemrpg.model.domain;

public abstract class Equipamento {
	private String nome;
	private float valor;
	private float peso;

	public Equipamento(String nome, float valor, float peso) {
		this.nome = nome;
		this.valor = valor;
		this.peso = peso;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.peso);

		return sb.toString();
	}

	public abstract float calcularAtributosSecundarios(int atributoPrincipal);

	public String getNome() {
		return nome;
	}

	public float getValor() {
		return valor;
	}

	public float getPeso() {
		return peso;
	}

}
