package net.jjn99.climax.controller;

import net.jjn99.climax.entity.Client;
import net.jjn99.climax.services.ClientService;
import java.util.List;
import java.util.Map;

public class ClientController {

    public static List<Client> extraireDonneesClient(String path) {
       try {
              return ClientService.extraireDonneesClient(path);
       }
       catch (Exception e) {
           e.fillInStackTrace();
       }
        return null;
    }

    public static Map<String, Double> calculerMoyenneSalairesParProfession(List<Client> clients) {
        try {
            return ClientService.calculerMoyenneSalairesParProfession(clients);
        }catch (Exception e) {
            e.fillInStackTrace();
    }
        return null;
    }
}
