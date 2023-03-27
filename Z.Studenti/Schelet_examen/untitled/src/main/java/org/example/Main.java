package org.example;

import org.example.Domain.Student;
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
        String password="123456abcdef";
        String url="jdbc:postgresql://localhost:5432/studenti";
        Repository0 entityRepository =
                new DbRepository(url, username, password, new EntitateValidator());
        Iterable<Student> entities = entityRepository.findAll();
        List<Student> entities2 = new ArrayList<>();
        for(Student s:entities)
            entities2.add(s);

        InMemoryRepo repo = new InMemoryRepo(entities2);
        Service service = new Service(repo);
        UI ui = new UI(service);
        ui.runMenu();
    }
}