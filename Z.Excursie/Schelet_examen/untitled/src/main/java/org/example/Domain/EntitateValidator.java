package org.example.Domain;

import java.util.Objects;

public class EntitateValidator implements Validator<Excursie> {
    @Override
    public void validate(Excursie entity) throws ValidationException {
        if (entity.getId() == 0L)
            throw new ValidationException("Id-ul nu poate fi nul!");
        if (entity.getOras() == null)
            throw  new ValidationException("Titlul nu poate fi null!");
        if (entity.getAtractie() == null)
            throw  new ValidationException("Autorul nu poate fi null!");
        if (entity.getCategorie() == null)
            throw new ValidationException("Categoria nu poate fi null!");
        if (!Objects.equals(entity.getCategorie(), "istorie"))
            throw new ValidationException("Categoria trebuie sa fie istorie, natura, eveniment sau sport!");
        if (!Objects.equals(entity.getCategorie(), "natura"))
            throw new ValidationException("Categoria trebuie sa fie istorie, natura, eveniment sau sport!");
        if (!Objects.equals(entity.getCategorie(), "eveniment"))
            throw new ValidationException("Categoria trebuie sa fie istorie, natura, eveniment sau sport!");
        if (!Objects.equals(entity.getCategorie(), "sport"))
            throw new ValidationException("Categoria trebuie sa fie istorie, natura, eveniment sau sport!");
        if (entity.getPret() < 0)
            throw  new ValidationException("Pretul nu poate fi negativ!");
    }
}
