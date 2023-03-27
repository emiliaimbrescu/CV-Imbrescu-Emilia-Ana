package org.example.UI;

import org.example.Domain.Produs;
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
            System.out.println("1. Afiseaza toate produsele.");
            System.out.println("2. Cautare 'iaurt' in produse.");
            System.out.println("3. Filtrare produse 'alimente'.");
            System.out.println("4. Filtrare produse 'alimente' cu pret <10.");
            System.out.println("5. Sortare produse dupa categorie si nume, alfabetic, crescator.");
            System.out.println("6. Sortare produse dupa descriere, descrescator.");
            System.out.println("7. Sortare produse dupa pret, crescator.");

            System.out.println("0. Iesire");
            opt = readLine("Dati optiunea: ");


            switch (opt) {
                case "1" -> printAll();

                case "2" ->{
                    Produs produs = serv.searchProdusByName("iaurt");
                    if(produs != null)
                        System.out.println(produs);
                    else
                        System.out.println("Produsul nu a fost gasit!");
                }

                case "3" ->{
                    serv.filterByCategorie("alimente").forEach(System.out::println);
                }

                case "4" ->{
                    serv.filterByCategorieAndPret("alimente", 10).forEach(System.out::println);
                }

                case "5" ->{
                    List<Produs> produse = serv.sortByCategorieAndNume();
                    System.out.println();
                    produse.forEach(c -> System.out.println("Id: " + c.getId() + ", Nume: " + c.getNume()
                            + ", Categorie: " + c.getCategorie()));
                }
                case "6" -> {
                    List<Produs> produse = serv.sortByDescriere();
                    System.out.println();
                    produse.forEach(c -> System.out.println("Nume: " + c.getNume()
                            + ", Categorie: " + c.getCategorie()
                            + ", Descriere: " + c.getDescriere()));
                }

                case "7" -> {
                    List<Produs> produse = serv.sortByPret();
                    System.out.println();
                    produse.forEach(c -> System.out.println("Id: " + c.getId()
                            + ", Pret: " + c.getPret()));
                }

                default -> System.out.println("Optiune gresita! Reincercati!");
            }
        }while(!opt.equals("0"));
        }

}
