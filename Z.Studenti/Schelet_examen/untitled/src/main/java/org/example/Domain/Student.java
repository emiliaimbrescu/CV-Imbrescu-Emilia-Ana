package org.example.Domain;

import java.util.Objects;

public class Student extends Entity{
    //public Student(Long id) {super(id);}
    String nume;
    String prenume;
    String grupa;
    Double media;


    public Student(Long id, String nume, String prenume, String grupa, Double media) {
        super(id);
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.media = media;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) && Objects.equals(prenume, student.prenume) && Objects.equals(grupa, student.grupa) && Objects.equals(media, student.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, grupa, media);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", media=" + media +
                '}';
    }
}
