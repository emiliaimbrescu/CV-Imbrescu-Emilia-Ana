package org.example.Service;

import org.example.Domain.Student;
import org.example.Repository.InMemoryRepo;

import java.util.Comparator;
import java.util.List;

public class Service {
    private InMemoryRepo repo;

    public Service(InMemoryRepo repo) {
        this.repo = repo;
    }
    public void printAll(){repo.findAll().forEach(System.out::println);}
    public List<Student> getEntities() {return repo.getEntities();}
    public Iterable<Student> findAll(){return repo.findAll();}
    public Student findOne(Long id){return repo.findOne(id);}
    public Student save(Student entity){return repo.save(entity);}
    public Student delete(Long id) {return repo.delete(id);}

    public Student searchByNumeAndPrenume(String nume, String prenume) {
        Iterable<Student> studenti = repo.findAll();

        for(Student student:studenti)
            if(student.getNume().equalsIgnoreCase(nume) && student.getPrenume().equalsIgnoreCase(prenume))
                return student;
        return null;
    }

    public List<Student> filterByGrupa(String grupa) {
        return repo.getEntities().stream().filter(s->s.getGrupa().equals(grupa)).toList();
    }

    public List<Student> filterByGrupaAndMedie(String grupa, double media) {
        return repo.getEntities().stream().filter(s->s.getGrupa().equals(grupa))
                .filter(s->s.getMedia() > media).toList();
    }

    public List<Student> sortByNumeAndPrenume() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Student::getPrenume))
                .sorted(Comparator.comparing(Student::getNume)).toList();
    }

    public List<Student> sortByGrupa() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Student::getGrupa)).toList();
    }

    public List<Student> filterByMedie() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Student::getMedia)
                .reversed()).toList();
    }
}
