package br.edu.infnet.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.infnet.model.exceptions.PersonagemSemEquipe;
import br.edu.infnet.model.exceptions.PersonagemSemNome;

@Entity
@Table(name = "Personagem")
public class Personagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Transient
	private transient LocalDateTime dataCriacao;
	private String dataCriacaoWeb;
	private String raca;
	private String classe;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@JoinColumn(name = "idEquipe")
	@ManyToOne(fetch = FetchType.LAZY)
	private Equipe equipe;
	@Transient
	private transient DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Personagem() {
		dataCriacaoWeb = LocalDateTime.now().format(FORMATTER);
	}

	public Personagem(String nome, String raca, String classe) {
		this();
		this.nome = nome;
		this.raca = raca;
		this.classe = classe;
	}

	@Override
	public String toString() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.dataCriacao.format(formato));
		sb.append(";");
		sb.append(this.raca);
		sb.append(";");
		sb.append(this.classe);
		sb.append(";");
		sb.append(this.equipe);

		return sb.toString();
	}

	public String infoToSave() throws PersonagemSemNome, PersonagemSemEquipe{

		if (this.nome.isBlank() || this.nome.isEmpty()) {
			throw new PersonagemSemNome("Personagem sem nome!");
		}
		if (this.equipe.getNome().isBlank() || this.equipe.getNome().isEmpty()) {
			throw new PersonagemSemEquipe("Personagem sem equipe");
		}

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append("---- Ficha do Personagem ----");
		sb.append("\r\n");
		sb.append("- Nome: " + this.nome);
		sb.append("\r\n");
		sb.append("- Data da criacao: " + this.dataCriacao.format(formato));
		sb.append("\r\n");
		sb.append("- Raca: " + this.raca);
		sb.append("\r\n");
		sb.append("- Classe: " + this.classe);
		sb.append("\r\n");
		sb.append("- Equipe: " + this.equipe.getNome());
		sb.append("\r\n");

		return sb.toString();
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDataCriacaoWeb() {
		return dataCriacaoWeb;
	}

	public void setDataCriacaoWeb(String dataCriacaoWeb) {
		this.dataCriacaoWeb = dataCriacaoWeb;
	}
}
