package br.edu.infnet.personagemrpg.model.domain;

public class Armadura extends Equipamento {

	private String tipo;
	private int defesa;
	private String material;

	public Armadura(String nome, float valor, float peso, String tipo, int defesa, String material) {
		super(nome, valor, peso);
		this.tipo = tipo;
		this.defesa = defesa;
		this.material = material;
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
	}public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public float calcularAtributosSecundarios(int atributoPrincipal) {
		float def = (float) (this.getDefesa() + (atributoPrincipal * 0.5));
		
		return def;
	}
	
}
