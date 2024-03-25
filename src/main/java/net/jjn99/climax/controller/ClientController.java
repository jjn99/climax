package net.jjn99.climax.controller;

import net.jjn99.climax.entity.Client;
import net.jjn99.climax.services.ClientService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ClientController implements ClientRest{

    private ClientService clientService;

    @Override
    public List<Client> extraireDonneesClient(String path) {
       try {
              return clientService.extraireDonneesClient(path);
       }
       catch (Exception e) {
           e.fillInStackTrace();
       }
        return null;
    }

    @Override
    public Map<String, Double> calculerMoyenneSalairesParProfession(List<Client> clients) {
        try {
            return clientService.calculerMoyenneSalairesParProfession(clients);
        }catch (Exception e) {
            e.fillInStackTrace();
    }
        return null;
    }
}
