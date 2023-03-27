package org.example.UI;

import org.example.Service.Service;

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
            System.out.println("1. Afiseaza toate excursiile.");
            System.out.println("2. Afisarea excursiei 'Roma Colosseum'.");
            System.out.println("3. Filtrare excursie istorie.");
            System.out.println("4. Filtrare excursie istorie cu pret >2500.");
            System.out.println("5. Sortarea excursiilor dupa oras si atractie, alfabetic, crescator.");
            System.out.println("6. Sortarea excursiilor dupa categorie, alfabetic, crescator.");
            System.out.println("7. Sortarea excursiilor dupa pret descrescator.");


            System.out.println("0. Iesire");
            opt = readLine("Dati optiunea: ");


            switch (opt) {
                case "1" -> printAll();

                case "2" ->{
                    System.out.println();
                    System.out.println(serv.getByOrasAndAtractie("Roma","Colosseum"));
                    System.out.println();
                }

                case "3" ->{
                    System.out.println();
                    serv.filterByCategorie("istorie").forEach(System.out::println);
                    System.out.println();
                }

                case "4" ->{
                    System.out.println();
                    serv.filterByCategorieAndPret("istorie").forEach(System.out::println);
                    System.out.println();
                }

                case "5" ->{
                    System.out.println();
                    serv.sortByAtractieAndOras().forEach(c -> System.out.println("Id: " + c.getId() +
                            ", Oras: " + c.getOras() +
                            ", Atractie: " + c.getAtractie()));
                    System.out.println();
                }

                case "6" ->{
                    System.out.println();
                    serv.sortByCategorie().forEach(c -> System.out.println("Oras: " + c.getOras() +
                            ", Atractie: " + c.getAtractie() +
                            ", Categorie: " + c.getCategorie()));
                    System.out.println();
                }

                case "7" ->{
                    System.out.println();
                    serv.sortByPret().forEach(c -> System.out.println("Id: " + c.getId() +
                            ", Pret: " + c.getPret()));
                    System.out.println();
                }

                default -> System.out.println("Optiune gresita! Reincercati!");
            }
        }while(!opt.equals("0"));
        }

}
