package org.example.Domain;

public class EntitateValidator implements Validator<Student> {
    @Override
    public void validate(Student entity) throws ValidationException {
        if (entity.getId() == 0L)
            throw new ValidationException("Id-ul nu poate fi nul!");
        if(entity.getNume() == null)
            throw new ValidationException("Numele nu poate fi null!");
        if(entity.getPrenume() == null)
            throw new ValidationException("Prenumele nu poate fi null!");
        if(entity.getGrupa() == null)
            throw new ValidationException("Grupa nu poate fi null-a!");
        if(entity.getMedia() < 0)
            throw new ValidationException("Media nu poate fi mai mica decat 0!");
    }
}
