package org.example.Repository;

import org.example.Domain.Produs;

import java.util.List;

public class InMemoryRepo implements Repository0{
    private List<Produs> entities;

    public InMemoryRepo(List<Produs> entities) {
        this.entities = entities;
    }

    public List<Produs> getEntities() {
        return entities;
    }

    public void setEntities(List<Produs> entities) {
        this.entities = entities;
    }


    @Override
    public Produs findOne(Long id) {
        if (id==null)
            return null;
        return entities.get(Math.toIntExact(id));
    }


    @Override
    public Iterable<Produs> findAll() {
        return entities;
    }

    @Override
    public Produs save(Produs entity) {
        entities.add(entity);
        return entity;
    }

    @Override
    public Produs delete(Long id) {
        Produs e = entities.get(Math.toIntExact(id));
        entities.remove(e);
        return e;
    }

}
