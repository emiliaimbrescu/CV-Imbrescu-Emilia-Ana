package org.example.UI;

import org.example.Domain.Student;
import org.example.Service.Service;

import java.util.List;
import java.util.Scanner;

public class UI {
    private Service serv;
    private Scanner scanner;

    public UI(Service serv) {
        this.serv = serv;
        this.scanner = new Scanner(System.in);
    }

    private String readLine(String str){
        System.out.print(str);
        return scanner.nextLine();
    }

    public void printAll(){
        System.out.println();
        serv.printAll();
        System.out.println();
    }



    public void runMenu(){
        String opt;
        do{
            System.out.println("1. Afiseaza toti studentii.");
            System.out.println("2. Cautarea studentului 'Pop Ion'.");
            System.out.println("3. Filtrare studenti din grupa 222.");
            System.out.println("4. Filtrare studenti din grupa 222 cu media > 5.");
            System.out.println("5. Sortare dupa nume si prenume, alfabetic, crescator.");
            System.out.println("6. Sortare dupa grupa crescator.");
            System.out.println("7. Sortare dupa medie descrescator.");


            System.out.println("0. Iesire");
            opt = readLine("Dati optiunea: ");


            switch (opt) {
                case "1" -> printAll();

                case "2" ->{
                    System.out.println();
                    Student student = serv.searchByNumeAndPrenume("Pop", "Ion");
                    if(student != null)
                        System.out.println(student);
                    else
                        System.out.println("Studentul nu a fost gasit!");
                    System.out.println();
                }

                case "3" ->{
                    System.out.println();
                    serv.filterByGrupa("222").forEach(System.out::println);
                    System.out.println();
                }

                case "4" ->{
                    System.out.println();
                    serv.filterByGrupaAndMedie("222", 5.0).forEach(System.out::println);
                    System.out.println();
                }

                case "5" ->{
                    System.out.println();
                    List<Student> studenti = serv.sortByNumeAndPrenume();
                    System.out.println();
                    studenti.forEach(s -> System.out.println("Id: " + s.getId() +
                            ", Nume: " + s.getNume() +
                            ",  Prenume: " + s.getPrenume()));
                    System.out.println();
                }

                case "6" ->{
                    System.out.println();
                    List<Student> studenti = serv.sortByGrupa();
                    System.out.println();
                    studenti.forEach(s-> System.out.println("Nume: " + s.getNume() +
                            ",  Prenume: " + s.getPrenume() +
                            ", Grupa: " + s.getGrupa()));
                    System.out.println();
                }

                case "7" ->{
                    System.out.println();
                    List<Student> studenti = serv.filterByMedie();
                    System.out.println();
                    studenti.forEach(s-> System.out.println("Id: " + s.getId() +
                            ",  Media: " + s.getMedia()));
                    System.out.println();
                }

                default -> System.out.println("Optiune gresita! Reincercati!");
            }
        }while(!opt.equals("0"));
        }

}
