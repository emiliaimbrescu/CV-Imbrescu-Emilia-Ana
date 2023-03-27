package org.example.Repository;

import org.example.Domain.Excursie;

import java.util.List;

public class InMemoryRepo implements Repository0{
    private List<Excursie> entities;

    public InMemoryRepo(List<Excursie> entities) {
        this.entities = entities;
    }

    public List<Excursie> getEntities() {
        return entities;
    }

    public void setEntities(List<Excursie> entities) {
        this.entities = entities;
    }


    @Override
    public Excursie findOne(Long id) {
        if (id==null)
            return null;
        return entities.get(Math.toIntExact(id));
    }


    @Override
    public Iterable<Excursie> findAll() {
        return entities;
    }

    @Override
    public Excursie save(Excursie entity) {
        entities.add(entity);
        return entity;
    }

    @Override
    public Excursie delete(Long id) {
        Excursie e = entities.get(Math.toIntExact(id));
        entities.remove(e);
        return e;
    }

}
