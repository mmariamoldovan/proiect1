import java.io.*;
import java.util.Scanner;

public class Magazin_de_haine {

    Tip_produs[] listaProduse;
    private int total_haine;
    Tip_produs cerinta;


    public Magazin_de_haine() {
        int numarProduse = numaraProduseInFisier("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_produse");
        listaProduse = new Tip_produs[numarProduse];
        citesteProduseDinFisier();


        total_haine = calculeazaTotalHaine();

    }


    private void citesteProduseDinFisier() {
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_produse"));
            int index = 0;
            while (sc.hasNextLine() && index < listaProduse.length) {
                String linie = sc.nextLine();
                String[] dateProdus = linie.split(", ");

                String categorie = dateProdus[0].trim();
                double pret = Double.parseDouble(dateProdus[1].trim());
                String marime = dateProdus[2].trim();

                int cantitate = Integer.parseInt(dateProdus[3].trim());

                listaProduse[index] = new Tip_produs(categorie, pret, marime, cantitate);
                index++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }
    }


    public void citire() {

        citesteProduseDinFisier();

    }


    private int numaraProduseInFisier(String numeFisier) {
        int count = 0;
        try {
            Scanner sc = new Scanner(new File(numeFisier));
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }
        return count;

    }


    private int calculeazaTotalHaine() {
        int total = 0;
        for (Tip_produs produs : listaProduse) {
            if (produs != null) {
                total += produs.getCantitate();
            }
        }
        return total;
    }

    public void selecteazaProdus() {
        Scanner sc = new Scanner(System.in);
        cerinta = null;

        System.out.println("Selectati categoria de produs (Pantaloni, Bluze, Tricouri): ");
        String categorie = sc.nextLine();

        System.out.println("Selectati marimea produsului (S, M, L, XL): ");
        String marime = sc.nextLine();


        for (Tip_produs produs : listaProduse) {
            if (produs.getCategorie().equalsIgnoreCase(categorie) && produs.getMarime().equalsIgnoreCase(marime)) {
                cerinta = produs;
                break;
            }
        }

        if (cerinta != null) {
            System.out.println("Produsul selectat este: " + cerinta.getCategorie() + ", mărimea: " + cerinta.getMarime());
        } else {
            System.out.println("Produsul introdus nu a fost găsit.");
        }
    }

    public void adaugareProduse(int total_haine) {
        this.total_haine += total_haine;


    }

    public void stergereProduse(int total_haine) {
        this.total_haine -= total_haine;
    }

    public void actualizareProduse() {
        if (cerinta == null) {
            System.out.println("Nu ați selectat niciun produs. Vă rugăm să selectați unul mai întâi.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti ce anume doriți să modificați (pret, cantitate): ");
        String ce_sa_se_modifice = sc.nextLine();

        if (ce_sa_se_modifice.equalsIgnoreCase("pret")) {
            System.out.println("Introduceti noul pret: ");
            double nou_pret = sc.nextDouble();
            sc.nextLine();

            cerinta.setPret(nou_pret);
            System.out.println("Pretul pentru " + cerinta.getCategorie() + " mărimea " + cerinta.getMarime() + " a fost actualizat la: " + nou_pret + "LEI");
        } else if (ce_sa_se_modifice.equalsIgnoreCase("cantitate")) {
            System.out.println("Introduceti noua cantitate: ");
            int nou_cantitate = sc.nextInt();
            sc.nextLine();

            cerinta.setCantitate(nou_cantitate);

            System.out.println("Cantitatea pentru " + cerinta.getCategorie() + " mărimea " + cerinta.getMarime() + " a fost actualizată la: " + nou_cantitate);
        }

        total_haine = calculeazaTotalHaine();

        actualizare();

    }

    public void afiseazaTotalProduse() {
        citesteProduseDinFisier();
        System.out.println(" Produsele magazinului sunt urmatoarele: ");
        for (Tip_produs produs : listaProduse) {
            System.out.println(" Produsul " + produs.getCategorie() + " cu marime " + produs.getMarime() + ", pret de " + produs.getPret() + " si cantitate de " + produs.getCantitate());

        }


    }


    public void afisare_tip_produs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Va rugam sa introduceti categoria de produs pentru care doriti informatii (Pantaloni, Bluze, Tricouri): ");
        String categorie = sc.nextLine();

        System.out.println("Stocuri disponibile pentru categoria " + categorie + ":");
        for (Tip_produs produs : listaProduse) {
            if (produs.getCategorie().equalsIgnoreCase(categorie)) {
                System.out.println(produs.getCategorie() + " mărimea " + produs.getMarime() + ", Stoc: " + produs.getCantitate());
            }
        }
    }

    public void adaugareProduseStoc() {
        selecteazaProdus();
        Scanner sc = new Scanner(System.in);
        if (cerinta != null) {
            if (cerinta.getCantitate() < 30) {
                System.out.println("Introduceti cantitatea pe care doriti sa o adaugati: ");
                int cantitate_noua = sc.nextInt();
                cerinta.setCantitate(cerinta.getCantitate() + cantitate_noua);
                System.out.println("Stocul actualizat pentru aceasta selectie este: " + cerinta.getCantitate());


                total_haine = calculeazaTotalHaine();


                actualizare();
                scrieProduseInFisier();

            } else {
                System.out.println("Produsul are mai mult de 30 de bucati pe stoc!");
            }
        } else {
            System.out.println("Produsul sau marimea selectata nu exista.");
        }
    }

    public void prod_nume() {
        selecteazaProdus();
        if (cerinta != null) {
            System.out.println("Detaliile produsului selectat sunt: ");
            System.out.println("Pret: " + cerinta.getPret() + " LEI.");
            System.out.println("Cantitate: " + cerinta.getCantitate() + " buc.");
        } else {
            System.out.println("Produsul selectat nu exista in stoc!");
        }
    }

    public int getTotal_haine() {
        return total_haine;
    }

    public Tip_produs[] getListaProduse() {
        return listaProduse;
    }

    public void actualizare() {

        try {

            FileWriter fw = new FileWriter("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_produse", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Tip_produs produs : listaProduse) {
                bw.write(produs.getCategorie() + ", " + produs.getPret() + ", " + produs.getMarime() + ", " + produs.getCantitate());
                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println(" Actualizare finalizata. ");


        } catch (IOException e) {
            System.out.println("A aparut o eroare la actualizare. " + e.getMessage());

        }

    }

    private void scrieProduseInFisier() {
        try {

            FileWriter fw = new FileWriter("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_produse", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Tip_produs produs : listaProduse) {
                if (produs != null) {
                    bw.write(produs.getCategorie() + ", " + produs.getPret() + ", " + produs.getMarime() + ", " + produs.getCantitate());
                    bw.newLine();
                }
            }

            bw.close();
            fw.close();

            System.out.println(" Actualizare finalizata. ");


        } catch (IOException e) {
            System.out.println("A aparut o eroare la actualizare. " + e.getMessage());

        }
    }

    public void scriere() {
        scrieProduseInFisier();
    }


    public void afisare_dupa_categorie() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Va rugam sa introduceti categoria de produs: ");

        String categorie = sc.nextLine();


        for (Tip_produs produs : listaProduse) {

            if (produs.getCategorie().equalsIgnoreCase(categorie)) {
                System.out.println(produs.ToString());
            }

        }

        sc.close();
    }


    public void afisare_dupa_marime() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Va rugam sa introduceti marimea dorita: ");

        String marime = sc.nextLine();


        for (Tip_produs produs : listaProduse) {

            if (produs.getMarime().equalsIgnoreCase(marime)) {
                System.out.println(produs.ToString());
            }

        }
        sc.close();

    }


    public void afisare_dupa_pret() {

        Scanner sc = new Scanner(System.in);

        System.out.println(" Introduceti cum ati dori sa fie afisate produsele (crescator, descrescator): ");

        String alegere = sc.nextLine();


        if (alegere.equalsIgnoreCase("crescator")) {
            for (int i = 0; i < listaProduse.length - 1; ++i) {
                int min = i;
                for (int j = i; j < listaProduse.length; ++j) {
                    if (listaProduse[j] != null && listaProduse[min] != null) {
                        if (listaProduse[j].getPret() < listaProduse[min].getPret()) {
                            min = j;
                        }
                    }
                }

                if (min != i) {
                    Tip_produs temp = listaProduse[i];
                    listaProduse[i] = listaProduse[min];
                    listaProduse[min] = temp;
                }
            }
            System.out.println("Produse sortate crescator dupa pret:");
            for (Tip_produs produs : listaProduse) {
                if (produs != null) {
                    System.out.println(produs.ToString());
                }
            }

        } else if (alegere.equalsIgnoreCase("descrescator")) {
            for (int i = 0; i < listaProduse.length - 1; ++i) {
                int max = i;
                for (int j = i; j < listaProduse.length; ++j) {
                    if (listaProduse[j] != null && listaProduse[max] != null) {
                        if (listaProduse[j].getPret() > listaProduse[max].getPret()) {
                            max = j;
                        }
                    }
                }

                if (max != i) {
                    Tip_produs temp = listaProduse[i];
                    listaProduse[i] = listaProduse[max];
                    listaProduse[max] = temp;
                }
            }

            System.out.println("Produse sortate descrescator dupa pret:");
            for (Tip_produs produs : listaProduse) {
                if (produs != null) {
                    System.out.println(produs.ToString());
                }
            }
        }


    }
}
