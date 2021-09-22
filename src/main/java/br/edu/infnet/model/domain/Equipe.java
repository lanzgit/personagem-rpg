package br.edu.infnet.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	@Transient
	private transient LocalDateTime dataFundacao;
	private String dataFundacaoWeb;
	private int numMembros;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@JoinColumn(name = "idEquipe")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Personagem> personagens;
	@Transient
	private transient DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Equipe() {
		dataFundacaoWeb = LocalDateTime.now().format(FORMATTER);
	}

	public Equipe(String nome, String descricao) {
		this();
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
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
		this.numMembros = personagens.size();
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}

	public String getDataFundacaoWeb() {
		return dataFundacaoWeb;
	}

	public void setDataFundacaoWeb(String dataFundacaoWeb) {
		this.dataFundacaoWeb = dataFundacaoWeb;
	}
}
