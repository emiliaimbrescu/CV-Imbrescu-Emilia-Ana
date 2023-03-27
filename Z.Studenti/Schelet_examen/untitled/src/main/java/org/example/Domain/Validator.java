package org.example.Domain;

public interface Validator<E extends Entity> {
    void validate(Student entity) throws ValidationException;
}
