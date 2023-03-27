package org.example.Domain;

public interface Validator<E extends Entity> {
    void validate(Produs entity) throws ValidationException;
}
