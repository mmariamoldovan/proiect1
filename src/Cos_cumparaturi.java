import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Cos_cumparaturi {


    public int cantitate_cos;
    Magazin_de_haine magazin = new Magazin_de_haine();
    Tip_produs[] cos_cumparaturi;
    Tip_produs produs_selectat;


    public Cos_cumparaturi() {


        cantitate_cos = numaraproduse();

        if (cantitate_cos > 0) {
            cos_cumparaturi = new Tip_produs[cantitate_cos];
        } else {

            cos_cumparaturi = new Tip_produs[1];

        }

        citesteProduseDinFisier();
    }


    public void coscomplet() {

        magazin.selecteazaProdus();
        produs_selectat = magazin.cerinta;

        if (produs_selectat != null) {

            adaugaproduse(produs_selectat);
            System.out.println(" Cosul de cumparaturi are o cantitate de: " + cantitate_cos + " buc. ");

        } else {

            System.out.println(" Produsul nu exista! ");

        }


    }


    public void adaugaproduse(Tip_produs produs) {

        try {

            FileWriter fw = new FileWriter("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_cos_cumparaturi", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(produs.getCategorie() + ", " + produs.getPret() + ", " + produs.getMarime() + ", " + produs.getCantitate());
            bw.newLine();


            bw.close();
            fw.close();

            System.out.println(" Produsul a fost adaugat cu succes in cos. ");

            cantitate_cos++;


        } catch (IOException e) {
            System.out.println(" A aparut o eroare la adaugarea produsului in cos. " + e.getMessage());

        }

        citesteProduseDinFisier();

    }

    public int numaraproduse() {

        int count = 0;

        try {

            Scanner sc = new Scanner(new File("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_cos_cumparaturi"));

            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;

            }


        } catch (IOException e) {

            System.out.println("Fisierul nu a fost gasit! " + e.getMessage());

        }

        return count;
    }


    private void citesteProduseDinFisier() {
        try {
            File file = new File("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_cos_cumparaturi");
            if (file.length() == 0) {
                return;
            }

            Scanner sc = new Scanner(file);
            int index = 0;
            while (sc.hasNextLine()) {
                String linie = sc.nextLine();
                String[] dateProdus = linie.split(", ");

                String categorie = dateProdus[0].trim();
                double pret = Double.parseDouble(dateProdus[1].trim());
                String marime = dateProdus[2].trim();
                int cantitate = Integer.parseInt(dateProdus[3].trim());

                if (index < cos_cumparaturi.length) {
                    cos_cumparaturi[index] = new Tip_produs(categorie, pret, marime, cantitate);
                    index++;
                } else {
                    cos_cumparaturi = Arrays.copyOf(cos_cumparaturi, cos_cumparaturi.length + 1);
                    cos_cumparaturi[index] = new Tip_produs(categorie, pret, marime, cantitate);
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }
    }

    public void afisare_total_cos() {
        System.out.println(" Continutul cosului de cumparaturi este urmatorul:");
        for (Tip_produs produs : cos_cumparaturi) {
            if (produs != null) {
                System.out.println(" Produsul " + produs.getCategorie() + ", marimea " + produs.getMarime() + ", pret de " + produs.getPret() + " lei si cantitate de " + produs.getCantitate() + " buc. ");
            } else {
                System.out.println(" Eroare!");

            }
        }
    }

    public void stergere_prod_cos() {
        citesteProduseDinFisier();
        magazin.selecteazaProdus();
        produs_selectat = magazin.cerinta;

        if (produs_selectat != null) {
            int indexToDelete = -1;


            for (int i = 0; i < cantitate_cos; i++) {
                Tip_produs produs = cos_cumparaturi[i];
                if (produs != null &&
                        produs.getCategorie().equals(produs_selectat.getCategorie()) &&
                        Double.compare(produs.getPret(), produs_selectat.getPret()) == 0 &&
                        produs.getMarime().equals(produs_selectat.getMarime()) &&
                        produs.getCantitate() == produs_selectat.getCantitate()) {
                    indexToDelete = i;
                    break;
                }
            }

            if (indexToDelete != -1) {

                for (int i = indexToDelete; i < cantitate_cos - 1; i++) {
                    cos_cumparaturi[i] = cos_cumparaturi[i + 1];
                }


                cos_cumparaturi[cantitate_cos - 1] = null;


                cantitate_cos--;


                scrieProduseInFisier();
                System.out.println("Produsul a fost șters cu succes.");
            } else {
                System.out.println("Produsul nu există în coș.");
            }
        } else {
            System.out.println("Produsul selectat este nul!");
        }
        citesteProduseDinFisier();
    }


    public void scrieProduseInFisier() {
        try {

            FileWriter fw = new FileWriter("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect1\\src\\lista_cos_cumparaturi", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Tip_produs produs : cos_cumparaturi) {
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

    public void genereaza_factura() {

        Factura factura = new Factura(this);
        factura.creare_factura();

    }


    public void finalizare_comanda() {

        citesteProduseDinFisier();

        Scanner sc = new Scanner(System.in);

        if (cantitate_cos == 0) {
            System.out.println("Cosul de cumparaturi este gol!");
            return;
        }

        System.out.println(" Cosul de cumparaturi: ");

        for (Tip_produs produs : cos_cumparaturi) {
            if (produs != null) {
                System.out.println(produs.ToString());
            } else {
                System.out.println("Eroare!");
            }
        }


        System.out.println(" Doriti sa finalizati comanda? ");
        String raspuns = sc.nextLine();

        if (raspuns.equalsIgnoreCase("da")) {
            magazin.citire();
            Tip_produs[] listaProduse = magazin.getListaProduse();


            if (listaProduse == null || listaProduse.length == 0) {
                System.out.println("Nu există produse disponibile în stoc!");
                return;
            }


            for (Tip_produs produsCos : cos_cumparaturi) {
                if (produsCos != null) {
                    boolean produsGasit = false;
                    for (int i = 0; i < listaProduse.length; i++) {
                        Tip_produs produsLista = listaProduse[i];

                        if (produsLista.getCategorie().equals(produsCos.getCategorie()) &&
                                produsLista.getMarime().equals(produsCos.getMarime()) &&
                                produsLista.getPret() == produsCos.getPret()) {

                            produsGasit = true;
                            if (produsLista.getCantitate() > 0) {

                                listaProduse[i].setCantitate(produsLista.getCantitate() - 1);

                                magazin.scriere();


                            } else {
                                System.out.println("Cantitate insuficientă pentru produsul: " + produsLista.getCategorie());
                            }
                            break;
                        }
                    }
                    if (!produsGasit) {
                        System.out.println("Produsul " + produsCos.getCategorie() + " nu a fost găsit în stoc.");
                    }
                }
            }


            System.out.println("Comanda a fost finalizata cu succes!");

            genereaza_factura();

            for (int i = 0; i < cos_cumparaturi.length; i++) {
                cos_cumparaturi[i] = null;
            }
            cantitate_cos = 0;
            scrieProduseInFisier();
            citesteProduseDinFisier();

        }


    }

    public Tip_produs[] getCos_cumparaturi() {
        return this.cos_cumparaturi;
    }

    public double total_cost() {
        double totalcost = 0;

        for (Tip_produs produs : cos_cumparaturi) {
            totalcost += produs.getPret();
        }
        if (totalcost < 150.00) {
            totalcost += 14;
        }
        return totalcost;
    }
}








