package br.edu.infnet.personagemrpg.model.domain;

public class Arma extends Equipamento {
	private String tipo;
	private int poderDeAtaque;
	private String material;

	public Arma(String nome, float peso, float valor, String tipo, int poderDeAtaque, String material) {
		super(nome, peso, valor);
		this.tipo = tipo;
		this.poderDeAtaque = poderDeAtaque;
		this.material = material;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.tipo);
		sb.append(";");
		sb.append(this.poderDeAtaque);
		sb.append(";");
		sb.append(this.material);
		sb.append(";");

		return super.toString();
	}

	@Override
	public float calcularAtributosSecundarios(int atributoPrincipal) {
		float atk = (float) (this.poderDeAtaque + (atributoPrincipal * 0.5));

		return atk;
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
