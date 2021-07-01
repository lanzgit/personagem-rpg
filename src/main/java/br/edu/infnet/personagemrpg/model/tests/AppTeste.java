package br.edu.infnet.personagemrpg.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;

public class AppTeste {

	public static void main(String[] args) {

		String dir = System.getProperty("user.dir");
		String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";

		try {
			try {
				InputStream resource = new ClassPathResource("static/equipes.txt").getInputStream();
				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));
				
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		
	}
	
}