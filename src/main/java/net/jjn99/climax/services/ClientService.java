package net.jjn99.climax.services;

import net.jjn99.climax.entity.Client;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientService {
    public Client createClient(Client client) {
        Client newClient = new Client();
        newClient.setNom(client.getNom());
        newClient.setPrenom(client.getPrenom());
        newClient.setAge(client.getAge());
        newClient.setProfession(client.getProfession());
        newClient.setSalaire(client.getSalaire());
        return newClient;
    }

    public List<Client> lireCSV(String path) {
            try {
                List<Client> clients = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null){
                    String[] parts = line.split(",");
                    String nom = parts[0].trim();
                    String prenom = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String profession = parts[3].trim();
                    double salaire = Double.parseDouble(parts[4].trim());
                    Client client = new Client(nom, prenom, age, profession, salaire);
                    clients.add(client);
                }
            }catch (Exception e){
                e.fillInStackTrace();
            }
            return null;
    }

    public List<Client> lireJSON(String path) {
        return null;
    }

    public List<Client> lireXML(String path) {
        return null;
    }

    public Map<String, Double> calculerMoyenneSalairesParProfession(List<Client> clients) {
        return null;
    }

    public List<Client> extraireDonneesClient(String path) throws IOException {
        String extension = FilenameUtils.getExtension(path);
        if (extension.equalsIgnoreCase("csv")) {
            return lireCSV(path);
        } else if (extension.equalsIgnoreCase("json")) {
            return lireJSON(path);
        } else if (extension.equalsIgnoreCase("xml")) {
            return lireXML(path);
        } else {
            throw new IOException("Format de fichier non supporté");
        }

    }
}
