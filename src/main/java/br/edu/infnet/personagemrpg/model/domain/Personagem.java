package br.edu.infnet.personagemrpg.model.domain;

import java.time.LocalDateTime;

public class Personagem {

	private int id;
	private String nome;
	private LocalDateTime dataCriacao;
	private String raca;
	private String classe;

	private int forca;
	private int inteligencia;
	private int agilidade;
	private Equipamento equipamento;

	public Personagem() {
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(";");
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.dataCriacao);
		sb.append(";");
		sb.append(this.raca);
		sb.append(";");
		sb.append(this.classe);
		sb.append(";");
		sb.append(this.forca);
		sb.append(";");
		sb.append(this.inteligencia);
		sb.append(";");
		sb.append(this.agilidade);

		return sb.toString();
	}

	public void imprimeFichaPersonagem() {
		System.out.println("Personagem " + getId() + ":");
		System.out.println("Nome: " + getNome());
		System.out.println("Criado em: " + getDataCriacao());
		System.out.println("raca: " + getRaca());
		System.out.println("classe: " + getClasse());

		System.out.println("---- Atributos Primarios ----");
		System.out.println("Forca: " + getForca());
		System.out.println("Inteligencia: " + getInteligencia());
		System.out.println("Agilidade: " + getAgilidade());

		System.out.println("---- Atributos Secundarios ----");
		System.out.println("Poder de Ataque: ");
		System.out.println("Defesa: ");
		System.out.println("Velocidade: ");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

}
