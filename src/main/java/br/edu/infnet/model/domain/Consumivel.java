package br.edu.infnet.model.domain;

import javax.persistence.Entity;
import br.edu.infnet.model.exceptions.EquipamentoSemNivel;

@Entity
public class Consumivel extends Equipamento {
	private boolean efeito;
	private int qntUso;
	private int status;

	public Consumivel(String nome, int nivel, float peso) {
		super(nome, nivel, peso);
	}

	public Consumivel(String nome, int nivel, float peso, boolean efeito, int qntUso) throws EquipamentoSemNivel {
		super(nome, nivel, peso);
		this.efeito = efeito;
		this.qntUso = qntUso;
		this.setAtributos();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.efeito ? "positivo" : "negativo");
		sb.append(";");
		sb.append(this.qntUso);
		sb.append(";");
		sb.append(this.status);

		return sb.toString();
	}

	@Override
	public String infoToSave() {

		StringBuilder sb = new StringBuilder();
		sb.append("---- Consumivel ----");
		sb.append(super.infoToSave());
		sb.append(this.efeito ? "- Efeito: postivo" : "- Efeito: negativo");
		sb.append("\r\n");
		sb.append("- Quantidades de Uso: " + this.qntUso);
		sb.append("\r\n");
		sb.append(this.efeito ? "- Status de Efeito: " + "+" + this.status : "- Status de Efeito: " + this.status);
		sb.append("\r\n");

		return sb.toString();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQntUso() {
		return qntUso;
	}

	public void setQntUso(int qntUso) {
		this.qntUso = qntUso;
	}

	public boolean isEfeito() {
		return efeito;
	}

	public void setEfeito(boolean efeito) {
		this.efeito = efeito;
	}

	@Override
	public void setAtributos() throws EquipamentoSemNivel {
		if (getNivel() <= 0) {
			throw new EquipamentoSemNivel("o item Consumivel nao possui nivel!");
		}

		if (this.efeito) {
			this.status = 1 + getNivel();
		} else {
			this.status = -1 - getNivel();
		}
	}

	public void calcConsumivel() {
		if (this.efeito) {
			this.status = 1 + getNivel();
		} else {
			this.status = -1 - getNivel();
		}
	}

}
