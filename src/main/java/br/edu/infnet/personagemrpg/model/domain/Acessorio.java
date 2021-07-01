package br.edu.infnet.personagemrpg.model.domain;

public class Acessorio extends Equipamento {

	private String efeitoEspecial;
	private int atributoBonusUm;
	private int atributoBonusDois;

	public Acessorio(String nome, float valor, float peso) {
		super(nome, valor, peso);
	}

	@Override
	public String toString() {
		return null;
	}

	public int getAtributoBonusDois() {
		return atributoBonusDois;
	}

	public void setAtributoBonusDois(int atributoBonusDois) {
		this.atributoBonusDois = atributoBonusDois;
	}

	public int getAtributoBonusUm() {
		return atributoBonusUm;
	}

	public void setAtributoBonusUm(int atributoBonusUm) {
		this.atributoBonusUm = atributoBonusUm;
	}

	public String getEfeitoEspecial() {
		return efeitoEspecial;
	}

	public void setEfeitoEspecial(String efeitoEspecial) {
		this.efeitoEspecial = efeitoEspecial;
	}

	@Override
	public void calcularAtributosSecundarios() {
		
	}
	
}
