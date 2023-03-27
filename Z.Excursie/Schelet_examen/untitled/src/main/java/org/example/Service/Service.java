package org.example.Service;

import org.example.Domain.Excursie;
import org.example.Repository.InMemoryRepo;

import java.util.Comparator;
import java.util.List;

public class Service {
    private InMemoryRepo repo;

    public Service(InMemoryRepo repo) {
        this.repo = repo;
    }
    public void printAll(){repo.findAll().forEach(System.out::println);}
    public List<Excursie> getEntities() {return repo.getEntities();}
    public Iterable<Excursie> findAll(){return repo.findAll();}
    public Excursie findOne(Long id){return repo.findOne(id);}
    public Excursie save(Excursie entity){return repo.save(entity);}
    public Excursie delete(Long id) {return repo.delete(id);}

    public Excursie getByOrasAndAtractie(String oras, String atractie) {
        List<Excursie> excursii = repo.getEntities();

        for(Excursie excursie : excursii)
            if(excursie.getOras().equals(oras) && excursie.getAtractie().equals(atractie))
                return excursie;
        return null;
    }

    public List<Excursie> filterByCategorie(String categorie) {
        return repo.getEntities().stream().filter(c->c.getCategorie().equals(categorie)).toList();
    }

    public List<Excursie> filterByCategorieAndPret(String categorie) {
        return repo.getEntities().stream().filter(c->c.getCategorie().equals(categorie))
                .filter(c->c.getPret() > 2500.0).toList();
    }

    public List<Excursie> sortByAtractieAndOras() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Excursie::getAtractie))
                .sorted(Comparator.comparing(Excursie::getOras)).toList();
    }

    public List<Excursie> sortByCategorie() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Excursie::getCategorie)).toList();
    }

    public List<Excursie> sortByPret() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Excursie::getPret).reversed())
                .toList();
    }
}
