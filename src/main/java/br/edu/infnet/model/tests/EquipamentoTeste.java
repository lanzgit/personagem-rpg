package br.edu.infnet.model.tests;

import br.edu.infnet.model.domain.Arma;
import br.edu.infnet.model.domain.Armadura;
import br.edu.infnet.model.domain.Consumivel;
import br.edu.infnet.model.exceptions.EquipamentoSemNivel;

public class EquipamentoTeste {
	public static void main(String[] args) {

		try {
			Arma w1 = new Arma("faca", 3, 10);	
			w1.setAtributos();
			System.out.println(w1);
		} catch (EquipamentoSemNivel e) {
			System.out.println(e.getMessage());
		}

		try {
			Armadura a1 = new Armadura("couraca", 0, 10);
			a1.setAtributos();
			System.out.println(a1);
		} catch (EquipamentoSemNivel e) {
			System.out.println(e.getMessage());
		}

		try {
			Consumivel c1 = new Consumivel("pocao", 0, 1);
			c1.setAtributos();
		} catch (EquipamentoSemNivel e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
