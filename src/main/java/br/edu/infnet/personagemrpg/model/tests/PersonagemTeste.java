package br.edu.infnet.personagemrpg.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.personagemrpg.model.domain.Equipe;
import br.edu.infnet.personagemrpg.model.domain.Personagem;

public class PersonagemTeste {
	
	public static void main(String[] args) {
		
		Equipe e1 = new Equipe();
		e1.setDescricao("lorem ipsum");
		e1.setNumMembros(2);
		e1.setNome("Equip1 1");

		
		Personagem p1 = new Personagem();
		p1.setNome("Vinicius");
		p1.setEquipe(e1);
		p1.setDataCriacao(LocalDateTime.now());
		System.out.println("Personagem: " + p1.getEquipe().getNome());
	}
}
