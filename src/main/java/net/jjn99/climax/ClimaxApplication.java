package net.jjn99.climax;

import net.jjn99.climax.controller.ClientController;
import net.jjn99.climax.entity.Client;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ClimaxApplication {


    public static void main(String[] args) {

		String csvPath = "src/main/resources/data/dataTest.csv";
		String jsonPath = "src/main/resources/data/dataTest.json";
		String xmlPath = "src/main/resources/data/dataTest.xml";

		//Partie CSV
		List<Client> clients = ClientController.extraireDonneesClient(csvPath);
		Map<String, Double> moyenneSalairesParProfession = ClientController.calculerMoyenneSalairesParProfession(clients);
		System.out.println(" Moyenne des salaires par type de profession CSV " + moyenneSalairesParProfession);

		//Partie JSON
		List<Client> clientsJson = ClientController.extraireDonneesClient(jsonPath);
		Map<String, Double> moyenneSalairesParProfessionJson = ClientController.calculerMoyenneSalairesParProfession(clientsJson);
		System.out.println(" Moyenne des salaires par type de profession JSON " + moyenneSalairesParProfessionJson);

		//Partie XML
		List<Client> clientsXml = ClientController.extraireDonneesClient(xmlPath);
		Map<String, Double> moyenneSalairesParProfessionXml = ClientController.calculerMoyenneSalairesParProfession(clientsXml);
		System.out.println(" Moyenne des salaires par type de profession XML " + moyenneSalairesParProfessionXml);
	}



}
