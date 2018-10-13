package com.clientui.beans;





public class Restaurant {


    private int id;

    private String Nom;

    private String description;

    private Double moyen;

    private Double qnouriture;

    private Double qsalle;
     private Double qservice;
    private String imag;
    public Restaurant() {
    }

    public Restaurant(int id, String nom, String description, Double moyen, Double qnouriture, Double qsalle, Double qservice) {
        this.id = id;
        Nom = nom;
        this.description = description;
        this.moyen = moyen;
        this.qnouriture = qnouriture;
        this.qsalle = qsalle;
        this.qservice = qservice;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMoyen() {
        return moyen;
    }
    public void calculMoyen(Double n, Double s, Double sv){
        qnouriture+=n;
        qsalle+=s;
        qservice+=sv;
        moyen=(qnouriture+qservice+qsalle)/3;
    }
    public void setMoyen(Double moyen) {
        this.moyen = moyen;
    }

    public Double getQnouriture() {
        return qnouriture;
    }

    public void setQnouriture(Double qnouriture) {
        this.qnouriture = qnouriture;
    }

    public Double getQsalle() {
        return qsalle;
    }

    public void setQsalle(Double qsalle) {
        this.qsalle = qsalle;
    }

    public Double getQservice() {
        return qservice;
    }

    public void setQservice(Double qservice) {
        this.qservice = qservice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", description='" + description + '\'' +
                ", moeyen='" + moyen + '\'' +
                ", Qualité de nouriture=" + qnouriture +
                ", Qualité de salle=" + qsalle +
                ", Qualité de service=" + qservice +
                ", image=" + imag +
                '}';
    }


}
