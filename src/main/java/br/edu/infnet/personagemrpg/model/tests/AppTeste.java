package br.edu.infnet.personagemrpg.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.personagemrpg.model.domain.Arma;
import br.edu.infnet.personagemrpg.model.domain.Armadura;
import br.edu.infnet.personagemrpg.model.domain.Consumivel;
import br.edu.infnet.personagemrpg.model.domain.Equipe;
import br.edu.infnet.personagemrpg.model.domain.Personagem;
import br.edu.infnet.personagemrpg.model.exceptions.EquipamentoSemNivel;
import br.edu.infnet.personagemrpg.model.exceptions.PersonagemSemEquipe;
import br.edu.infnet.personagemrpg.model.exceptions.PersonagemSemNome;

public class AppTeste {

	public static void main(String[] args) {

		String dir = System.getProperty("user.dir");
		String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("/yyyyMMdd")) + ".txt";

		try {
			try {
				InputStream resource = new ClassPathResource("personagem.txt").getInputStream();
				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

				String linha = leitura.readLine();

				while (linha != null) {
					String campos[] = linha.split(";");

					switch (campos[0].toUpperCase()) {
						case "0":
							Equipe e1 = new Equipe(campos[4], campos[5], Integer.valueOf(campos[6]));
							Personagem p1 = new Personagem(campos[1], campos[2], campos[3]);
							p1.setEquipe(e1);
							escrita.write(p1.infoToSave());
							escrita.write(e1.infoToSave());
							System.out.println(p1);
							break;
						case "W":
							Arma w1 = new Arma(campos[1], Integer.valueOf(campos[2]), Float.valueOf(campos[3]),
									campos[4], campos[6]);
							System.out.println("Arma: " + w1);
							escrita.write(w1.infoToSave());
							break;

						case "A":
							Armadura a1 = new Armadura(campos[1], Integer.valueOf(campos[2]), Float.valueOf(campos[3]),
									campos[4], campos[5]);
							System.out.println("Armadura: " + a1);
							escrita.write(a1.infoToSave());
							break;

						case "C":
							Consumivel c1 = new Consumivel(campos[1], Integer.valueOf(campos[2]),
									Float.valueOf(campos[3]), "positivo".equalsIgnoreCase(campos[4]),
									Integer.valueOf(campos[5]));
							escrita.write(c1.infoToSave());
							System.out.println("Consumivel: " + c1);
							break;

						default:
							System.out.println("Entrada invalida");
							break;
					}
					linha = leitura.readLine();
				}
				leitura.close();
				escrita.close();
				fileW.close();

			} catch (PersonagemSemNome | EquipamentoSemNivel | PersonagemSemEquipe | IOException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			System.out.println("Processamento finalizado -> " + (dir + arq));
		}

	}

}