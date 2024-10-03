import java.util.Scanner;

public class Meniu {
    Magazin_de_haine magazin_de_haine;
    Meniuri_magazin decizie_meniuri;


    public Meniu(Magazin_de_haine magazin_de_haine, Meniuri_magazin decizie_meniuri) {
        this.magazin_de_haine = magazin_de_haine;
        this.decizie_meniuri = decizie_meniuri;

    }

    public void afisareMeniu() {
        int decizie;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Selectati: ");
            System.out.println(" 1. Pentru a gestiona produsele! ");
            System.out.println(" 2. Pentru a gestiona stocurile! ");
            System.out.println(" 3. Pentru vanzari si comenzi! ");
            System.out.println(" 4. //Pentru gestionarea utilizatorilor! ");
            System.out.println(" 5. Pentru filtrarea si cautarea produselor! ");
            System.out.println(" 6. //Pentru optiuni reducere si oferte! ");
            System.out.println(" 7. //Pentru administrarea magazinului (de catre manageri)! ");
            System.out.println(" 8. Pentru a iesi din program! ");

            decizie = sc.nextInt();
            if (decizie == 1) {
                decizie_meniuri.afisare_meniu_dec1();
            } else if (decizie == 2) {
                decizie_meniuri.afisare_meniu_dec2();
            } else if (decizie == 3) {
                decizie_meniuri.afisare_meniu_dec3();
            } else if (decizie == 4) {
                decizie_meniuri.afisare_meniuri_dec4();
            } else if (decizie == 5) {
                decizie_meniuri.afisare_meniuri_dec5();
            } else if (decizie == 6) {
                decizie_meniuri.afisare_meniuri_dec6();
            } else if (decizie == 7) {
                decizie_meniuri.afisare_meniuri_dec7();
            } else if (decizie == 8) {
                System.out.println("Va multumim si va mai asteptam. O zi frumoasa! ");
            }

        } while (decizie != 8);
    }
}
