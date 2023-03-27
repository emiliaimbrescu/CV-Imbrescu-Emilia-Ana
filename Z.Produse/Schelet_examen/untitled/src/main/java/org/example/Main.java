package org.example;

import org.example.Domain.Produs;
import org.example.Domain.EntitateValidator;
import org.example.Repository.DbRepository;
import org.example.Repository.InMemoryRepo;
import org.example.Repository.Repository0;
import org.example.Service.Service;
import org.example.UI.UI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String username="postgres";
        String password="1234";
        String url="jdbc:postgresql://localhost:5432/produse";
        Repository0 entityRepository =
                new DbRepository(url, username, password, new EntitateValidator());
        Iterable<Produs> entities = entityRepository.findAll();
        List<Produs> entities2 = new ArrayList<>();
        for(Produs s:entities)
            entities2.add(s);

        InMemoryRepo repo = new InMemoryRepo(entities2);
        Service service = new Service(repo);
        UI ui = new UI(service);
        ui.runMenu();

    }
}