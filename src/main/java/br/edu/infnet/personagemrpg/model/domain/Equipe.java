package br.edu.infnet.personagemrpg.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Equipe {

	private String nome;
	private String descricao;
	private LocalDateTime dataFundacao;
	private int numMembros;

	public Equipe() {
		dataFundacao = LocalDateTime.now();
	}
	public Equipe(String nome, String descricao, int numMembros) {
		this();
		this.nome = nome;
		this.descricao = descricao;
		this.numMembros = numMembros;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.dataFundacao);
		sb.append(";");
		sb.append(this.numMembros);

		return sb.toString();

	}

	public String infoToSave() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append("---- Detalhes da Equipe ----");
		sb.append("\r\n");
		sb.append("- Nome: " + this.nome);
		sb.append("\r\n");
		sb.append("- Descricao: " + this.descricao);
		sb.append("\r\n");
		sb.append("- Data da Fundacao: " + this.dataFundacao.format(formato));
		sb.append("\r\n");
		sb.append("- Numero de Membros: " + this.numMembros);
		sb.append("\r\n");

		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDateTime dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getNumMembros() {
		return numMembros;
	}

	public void setNumMembros(int numMembros) {
		this.numMembros = numMembros;
	}
}
