package net.jjn99.climax.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jjn99.climax.entity.Client;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ClientService {

    public static List<Client> extraireDonneesClientsCSV(String cheminFichier) {

        List<Client> clients = new ArrayList<>();

        try (FileReader lecteurFichier = new FileReader(cheminFichier);
             BufferedReader bufferedReader = new BufferedReader(lecteurFichier)) {

            bufferedReader.readLine();

            String ligne;
            while ((ligne = bufferedReader.readLine()) != null) {
                String[] parties = ligne.split(",");
                String nom = parties[0].trim();
                String prenom = parties[1].trim();
                int age = Integer.parseInt(parties[2].trim());
                String profession = parties[3].trim();
                double salaire = Double.parseDouble(parties[4].trim());

                clients.add(new Client(nom, prenom, age, profession, salaire));
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
            return Collections.emptyList();
        }

        return clients;
    }


    public static List<Client> extraireDonneesClientsJSON(String cheminFichier) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        try (FileInputStream fluxFichier = new FileInputStream(cheminFichier)) {
            return mapper.readValue(fluxFichier, new TypeReference<List<Client>>() {});
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
            throw e;
        }
    }


    public static List<Client> extraireDonneesClientsXML(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource input = new InputSource(new FileReader(path));
        Document result = builder.parse(input);
        NodeList list = result.getElementsByTagName("client");
        List<Client> clients = new ArrayList<>();

        for (int i=0, len=list.getLength(); i<len; ++i) {
            Node node = list.item(i);

            String[] parts = node.getTextContent().trim().split("\n");

            Client c = new Client(
                    parts[0].trim(),
                    parts[1].trim(),
                    Integer.valueOf(parts[2].trim()) ,
                    parts[3].trim(),
                    Double.parseDouble(parts[4].trim())
            );
            clients.add(c);
        }

        return new ArrayList<>(clients);
    }

    public static Map<String, Double> calculerMoyenneSalairesParProfession(List<Client> clients) {
        Map<String, List<Client>> clientsParProfession = clients.stream().collect(Collectors.groupingBy(Client::getProfession));
        Map<String, Double> moyennes = new HashMap<>();

        for (String profession : clientsParProfession.keySet()) {
            List<Client> clientsDeLaProfession = clientsParProfession.get(profession);
            double totalDesSalaires = clientsDeLaProfession.stream().mapToDouble(Client::getSalaire).sum();
            double moyenneDesSalaires = totalDesSalaires / clientsDeLaProfession.size();
            moyennes.put(profession, moyenneDesSalaires);
        }

        return moyennes;
    }

    public static List<Client> extraireDonneesClient(String path) throws IOException, ParserConfigurationException, SAXException {
        String extension = FilenameUtils.getExtension(path);
        if (extension.equalsIgnoreCase("csv")) {
            return extraireDonneesClientsCSV(path);
        } else if (extension.equalsIgnoreCase("json")) {
            return extraireDonneesClientsJSON(path);
        } else if (extension.equalsIgnoreCase("xml")) {
            return extraireDonneesClientsXML(path);
        } else {
            throw new IOException("Format de fichier non supporté");
        }
    }
}
