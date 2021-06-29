package br.edu.infnet.personagemrpg.model.domain;

public class Arma extends Equipamento {
	private String tipo;
	private int poderDeAtaque;
	private String material;

	public Arma(String tipo, int poderDeAtaque, String material) {
		super();
		this.tipo = tipo;
		this.poderDeAtaque = poderDeAtaque;
		this.material = material;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPoderDeAtaque() {
		return poderDeAtaque;
	}
	public void setPoderDeAtaque(int poderDeAtaque) {
		this.poderDeAtaque = poderDeAtaque;
	}

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
}
