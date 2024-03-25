package net.jjn99.climax.controller;

import net.jjn99.climax.entity.Client;

import java.util.List;
import java.util.Map;

public interface ClientRest {
    public List<Client> extraireDonneesClient(String path);
    public Map<String, Double> calculerMoyenneSalairesParProfession(List<Client> clients);
}
