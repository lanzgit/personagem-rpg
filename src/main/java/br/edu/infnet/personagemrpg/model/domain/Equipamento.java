package br.edu.infnet.personagemrpg.model.domain;

import br.edu.infnet.personagemrpg.model.exceptions.EquipamentoSemNivel;

public abstract class Equipamento {
	private String nome;
	private int nivel;
	private float peso;

	public Equipamento() {
	}

	public Equipamento(String nome, int nivel, float peso) {
		this.nome = nome;
		this.nivel = nivel;
		this.peso = peso;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.nivel);
		sb.append(";");
		sb.append(this.peso);

		return sb.toString();
	}

	public String infoToSave() {

		StringBuilder sb = new StringBuilder();
		sb.append("\r\n");
		sb.append("- Nome: " + this.nome);
		sb.append("\r\n");
		sb.append("- Nivel: " + this.nivel);
		sb.append("\r\n");
		sb.append("- Peso: " + this.peso);
		sb.append("\r\n");

		return sb.toString();
	}

	public abstract void setAtributos() throws EquipamentoSemNivel;

	public String getNome() {
		return nome;
	}

	public int getNivel() {
		return nivel;
	}

	public float getPeso() {
		return peso;
	}

}
