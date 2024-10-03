import java.util.Scanner;

public class Meniuri_magazin {
    Meniu MeniuPrincipal;
    Magazin_de_haine MagazinTotal;
    Magazin_de_haine Actualizare;
    Cos_cumparaturi cos = new Cos_cumparaturi();


    public Meniuri_magazin(Meniu MeniuPrincipal, Magazin_de_haine MagazinTotal, Magazin_de_haine Actualizare) {
        this.MeniuPrincipal = MeniuPrincipal;
        this.MagazinTotal = MagazinTotal;
        this.Actualizare = Actualizare;
    }

    public void afisare_meniu_dec1() {
        int decizie;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Adauga produse. ");
            System.out.println(" 2. Sterge produse. ");
            System.out.println(" 3. Actualizeaza produse. ");
            System.out.println(" 4. Vizualizeaza toate produsele. ");
            System.out.println(" 5. Finalizare actiuni. ");


            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {
                System.out.println(" Va rugam sa introduceti numarul de produse pe care doriti sa-l adaugati: ");
                int numar_de_adaugat = sc.nextInt();
                sc.nextLine();
                MagazinTotal.adaugareProduse(numar_de_adaugat);
                System.out.println(" Numarul de produse actual dupa adaugarea a " + numar_de_adaugat + " de produse este: " + MagazinTotal.getTotal_haine());


            } else if (decizie == 2) {
                System.out.println(" Va rugam sa introduceti numarul de produse pe care doriti sa-l stergeti: ");
                int numar_de_sters = sc.nextInt();
                sc.nextLine();
                MagazinTotal.stergereProduse(numar_de_sters);
                System.out.println(" Numarul de produse actual dupa stergerea a " + numar_de_sters + " de produse este: " + MagazinTotal.getTotal_haine());

            } else if (decizie == 3) {
                Actualizare.selecteazaProdus();
                Actualizare.actualizareProduse();
            } else if (decizie == 4) {
                MagazinTotal.afiseazaTotalProduse();
            }
        } while (decizie != 5);
    }


    Scanner sc = new Scanner(System.in);

    public void afisare_meniu_dec2() {
        int decizie;

        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Verifică stocuri. ");
            System.out.println(" 2. Reaprovizionează produs. ");
            System.out.println(" 3. Caută produs după nume. ");
            System.out.println(" 4. Finalizare actiuni. ");
            decizie = sc.nextInt();
            sc.nextLine();

            if (decizie == 1) {
                MagazinTotal.afisare_tip_produs();
            } else if (decizie == 2) {
                MagazinTotal.adaugareProduseStoc();
            } else if (decizie == 3) {
                MagazinTotal.prod_nume();
            } else {
                System.out.println(" Meniul principal! ");
            }
        } while (decizie != 4);

    }


    public void afisare_meniu_dec3() {
        int decizie;
        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Adauga produse in cos. ");
            System.out.println(" 2. Vizualizează coșul de cumpărături. ");
            System.out.println(" 3. Stergere produs din cos. ");
            System.out.println(" 4. Finalzare comanda. ");
            System.out.println(" 5. Finalizare actiuni. ");

            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {
                cos.coscomplet();
            } else if (decizie == 2) {
                cos.afisare_total_cos();
            } else if (decizie == 3) {
                cos.stergere_prod_cos();
            } else if (decizie == 4) {
                cos.finalizare_comanda();

            }
        } while (decizie != 5);
    }


    public void afisare_meniuri_dec4() {
        int decizie;


        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Creare cont client. ");
            System.out.println(" 2. Actualizează datele clientului. ");
            System.out.println(" 3. Vizualizează istoricul comenzilor. ");
            System.out.println(" 4. Finalizare actiuni. ");
            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {

            } else if (decizie == 2) {

            } else if (decizie == 3) {

            }

        } while (decizie != 4);
    }


    public void afisare_meniuri_dec5() {
        int decizie;


        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Filtrează produse după categorie. ");
            System.out.println(" 2. Filtrează produse după mărime. ");
            System.out.println(" 3. Filtrează produse după preț. ");
            System.out.println(" 4. Finalizare actiuni. ");
            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {
                MagazinTotal.afisare_dupa_categorie();
            } else if (decizie == 2) {
                MagazinTotal.afisare_dupa_marime();
            } else if (decizie == 3) {
                MagazinTotal.afisare_dupa_pret();
            }


        } while (decizie != 4);

    }


    public void afisare_meniuri_dec6() {
        int decizie;


        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Aplică discount. ");
            System.out.println(" 2. Vizualizează produse la reducere. ");
            System.out.println(" 3. Finalizare actiuni. ");
            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {

            } else if (decizie == 2) {

            }

        } while (decizie != 3);

    }


    public void afisare_meniuri_dec7() {

        int decizie;


        do {
            System.out.println(" Pentru aceasta optiune alege una din urmatoarele: ");
            System.out.println(" 1. Generare raport vânzări. ");
            System.out.println(" 2. Raport stocuri. ");
            System.out.println(" 3. Raport clienți fideli. ");
            System.out.println(" 4. Finalizare actiuni. ");
            decizie = sc.nextInt();
            sc.nextLine();


            if (decizie == 1) {

            } else if (decizie == 2) {

            } else if (decizie == 3) {

            }

        } while (decizie != 4);


    }

}
