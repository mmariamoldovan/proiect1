import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Magazin_de_haine MagazinTotal = new Magazin_de_haine();
        Magazin_de_haine Actualizare = new Magazin_de_haine();
        Meniu meniu_principal = null;
        Meniuri_magazin decizie_meniuri = new Meniuri_magazin(meniu_principal, MagazinTotal, Actualizare);
        meniu_principal = new Meniu(MagazinTotal, decizie_meniuri);

        Scanner sc = new Scanner(System.in);

        System.out.println(" Buna ziua! Doriti sa continuati catre meniul principal? ");

        String raspuns = sc.nextLine();

        if (raspuns.equalsIgnoreCase("da")) {
            meniu_principal.afisareMeniu();


        } else if (raspuns.equalsIgnoreCase("nu")) {
            System.out.println(" Va dorim o zi frumoasa. La revedere! ");


        }


    }
}
