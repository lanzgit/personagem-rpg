package br.edu.infnet.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.model.exceptions.EquipamentoSemNivel;

@Entity
public class Arma extends Equipamento {
	private String tipo;
	private int dano;
	private String material;

	public Arma() {
	}

	public Arma(String nome, int nivel, float peso) {
		super(nome, nivel, peso);
	}

	public Arma(String nome, int nivel, float peso, String tipo, String material) throws EquipamentoSemNivel {
		super(nome, nivel, peso);
		this.tipo = tipo;
		this.material = material;
		this.setAtributos();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.tipo);
		sb.append(";");
		sb.append(this.dano);
		sb.append(";");
		sb.append(this.material);

		return sb.toString();
	}

	@Override
	public String infoToSave() {

		StringBuilder sb = new StringBuilder();
		sb.append("---- Arma ----");
		sb.append(super.infoToSave());
		sb.append("- Tipo: " + this.tipo);
		sb.append("\r\n");
		sb.append("- Material: " + this.material);
		sb.append("\r\n");
		sb.append("- Poder de ataque: " + this.dano);
		sb.append("\r\n");

		return sb.toString();
	}

	@Override
	public void setAtributos() throws EquipamentoSemNivel{
		if (getNivel() <= 0){
			throw new EquipamentoSemNivel("a Arma precisa ter nivel!");
		}
		this.dano = getNivel() * 2;
		if ("nobre".equalsIgnoreCase(this.material)){
			this.dano = getNivel() * 3;
		}
	}

	public void calcDano() {
		this.dano = getNivel() * 2;
		if ("nobre".equalsIgnoreCase(this.material)){
			this.dano = getNivel() * 3;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
