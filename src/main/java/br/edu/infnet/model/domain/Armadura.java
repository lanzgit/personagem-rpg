package br.edu.infnet.model.domain;

import javax.persistence.Entity;
import br.edu.infnet.model.exceptions.EquipamentoSemNivel;

@Entity
public class Armadura extends Equipamento {

	private String tipo;
	private int defesa;
	private String material;

	public Armadura() {
	}

	public Armadura(String nome, int nivel, float peso) {
		super(nome, nivel, peso);
	}

	public Armadura(String nome, int nivel, float peso, String tipo, String material) throws EquipamentoSemNivel {
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
		sb.append(this.defesa);
		sb.append(";");
		sb.append(this.material);

		return sb.toString();
	}

	@Override
	public String infoToSave() {

		StringBuilder sb = new StringBuilder();
		sb.append("---- Armadura ----");
		sb.append(super.infoToSave());
		sb.append("- Tipo: " + this.tipo);
		sb.append("\r\n");
		sb.append("- Material: " + this.material);
		sb.append("\r\n");
		sb.append("- Defesa: " + this.defesa);
		sb.append("\r\n");

		return sb.toString();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void setAtributos() throws EquipamentoSemNivel{
		if (getNivel() <= 0) {
			throw new EquipamentoSemNivel("a Armadura precisa ter nivel!");
		}
		this.defesa = getNivel() * 2;
		if ("nobre".equalsIgnoreCase(this.material)) {
			this.defesa = getNivel() * 3;
		}
	}

	public void calcDef() {
		this.defesa = getNivel() * 2;
		if ("nobre".equalsIgnoreCase(this.material)) {
			this.defesa = getNivel() * 3;
		}
	}

}
