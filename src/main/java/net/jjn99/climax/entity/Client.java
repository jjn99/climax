package net.jjn99.climax.entity;

public class Client {
    private String nom;
    private String prenom;
    private Integer age;
    private String profession;
    private Double salaire;

    public Client() {
    }

    public Client(String nom, String prenom, Integer age, String profession, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.profession = profession;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", salaire=" + salaire +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }


}
