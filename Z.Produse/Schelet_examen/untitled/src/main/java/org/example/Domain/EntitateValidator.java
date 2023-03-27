package org.example.Domain;

public class EntitateValidator implements Validator<Produs> {
    @Override
    public void validate(Produs entity) throws ValidationException {
        if (entity.getId() == 0L)
            throw new ValidationException("Id-ul nu poate fi nul!");


    }
}
