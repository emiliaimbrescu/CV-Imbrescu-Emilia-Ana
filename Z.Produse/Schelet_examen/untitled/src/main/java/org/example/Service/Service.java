package org.example.Service;

import org.example.Domain.Produs;
import org.example.Repository.InMemoryRepo;

import java.util.Comparator;
import java.util.List;

public class Service {
    private InMemoryRepo repo;

    public Service(InMemoryRepo repo) {
        this.repo = repo;
    }
    public void printAll(){repo.findAll().forEach(System.out::println);}
    public List<Produs> getEntities() {return repo.getEntities();}
    public Iterable<Produs> findAll(){return repo.findAll();}
    public Produs findOne(Long id){return repo.findOne(id);}
    public Produs save(Produs entity){return repo.save(entity);}
    public Produs delete(Long id) {return repo.delete(id);}

    public Produs searchProdusByName(String nume) {
        Iterable<Produs> produse = repo.findAll();

        for(Produs produs:produse)
            if(produs.getNume().equalsIgnoreCase(nume))
                return produs;
        return null;
    }

    public List<Produs> filterByCategorie(String categorie) {
        return repo.getEntities().stream().filter(e->e.getCategorie().equals(categorie)).toList();
    }

    public List<Produs> filterByCategorieAndPret(String categorie, int pret) {
        return repo.getEntities().stream().filter(e->e.getCategorie().equals(categorie))
                .filter(e->e.getPret() < 10).toList();
    }

    public List<Produs> sortByCategorieAndNume() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Produs::getCategorie))
                .sorted(Comparator.comparing(Produs::getNume)).toList();
    }

    public List<Produs> sortByDescriere() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Produs::getDescriere).reversed())
                .toList();
    }

    public List<Produs> sortByPret() {
        return repo.getEntities().stream().sorted(Comparator.comparing(Produs::getPret)).toList();
    }
}
