package org.example.Domain;

import java.util.Objects;

public class Excursie extends Entity{

    String oras;
    String atractie;
    String categorie;
    Double pret;
    public Excursie(Long id) {
        super(id);
    }

    public Excursie(Long id, String titlu, String autor, String categorie, Double pret) {
        super(id);
        this.oras = titlu;
        this.atractie = autor;
        this.categorie = categorie;
        this.pret = pret;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAtractie() {
        return atractie;
    }

    public void setAtractie(String atractie) {
        this.atractie = atractie;
    }


    public String getCategorie(){ return categorie;}

    public void setCategorie(String categorie) {this.categorie = categorie; }

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
        Excursie excursie = (Excursie) o;
        return Objects.equals(oras, excursie.oras) && Objects.equals(atractie, excursie.atractie) && Objects.equals(categorie, excursie.categorie) && Objects.equals(pret, excursie.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oras, atractie, categorie, pret);
    }

    @Override
    public String toString() {
        return "Excursie{" +
                "oras='" + oras + '\'' +
                ", atractie='" + atractie + '\'' +
                ", categorie='"+ categorie + '\''+
                ", pret=" + pret +
                '}';
    }
}
