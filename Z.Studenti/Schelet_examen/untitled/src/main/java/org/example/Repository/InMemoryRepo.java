package org.example.Repository;

import org.example.Domain.Student;

import java.util.List;

public class InMemoryRepo implements Repository0{
    private List<Student> entities;

    public InMemoryRepo(List<Student> entities) {
        this.entities = entities;
    }

    public List<Student> getEntities() {
        return entities;
    }

    public void setEntities(List<Student> entities) {
        this.entities = entities;
    }


    @Override
    public Student findOne(Long id) {
        if (id==null)
            return null;
        return entities.get(Math.toIntExact(id));
    }


    @Override
    public Iterable<Student> findAll() {
        return entities;
    }

    @Override
    public Student save(Student entity) {
        entities.add(entity);
        return entity;
    }

    @Override
    public Student delete(Long id) {
        Student e = entities.get(Math.toIntExact(id));
        entities.remove(e);
        return e;
    }

}
