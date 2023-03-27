package org.example.Domain;

public interface Validator<E extends Entity> {
    void validate(Excursie entity) throws ValidationException;
}
