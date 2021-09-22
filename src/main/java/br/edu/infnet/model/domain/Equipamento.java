package br.edu.infnet.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.infnet.model.exceptions.EquipamentoSemNivel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int nivel;
	private float peso;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@OneToOne
	@JoinColumn(name = "idPersonagem")
	private Personagem personagem;

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

	protected abstract void setAtributos() throws EquipamentoSemNivel;


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
