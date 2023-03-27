package org.example.Domain;

import java.util.Objects;

public class Produs extends Entity{

    String nume;
    String categorie;
    String descriere;
    Double pret;
    public Produs(Long id) {
        super(id);
    }

    public Produs(Long id, String nume, String categorie, String descriere, Double pret) {
        super(id);
        this.nume = nume;
        this.categorie = categorie;
        this.descriere = descriere;
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return Objects.equals(nume, produs.nume) && Objects.equals(categorie, produs.categorie) && Objects.equals(descriere, produs.descriere) && Objects.equals(pret, produs.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, categorie, descriere, pret);
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", categorie='" + categorie + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                '}';
    }
}
