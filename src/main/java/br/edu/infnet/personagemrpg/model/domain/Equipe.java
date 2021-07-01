package br.edu.infnet.personagemrpg.model.domain;
import java.time.LocalDateTime;

public class Equipe {
	
	private String nome;
	private String descricao;
	private LocalDateTime dataFundacao;
	private int numMembros;
	private Personagem personagem;

	public String obterEquipe() {
		return null;
	}

	public String getNome() {
		return nome;
	}
	public Personagem getPersonagem() {
		return personagem;
	}
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
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
