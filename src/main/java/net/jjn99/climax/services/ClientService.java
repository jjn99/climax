package net.jjn99.climax.services;

import net.jjn99.climax.entity.Client;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
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
