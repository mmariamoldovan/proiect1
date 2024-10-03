public class Tip_produs {
    private String categorie;
    private double pret;
    private String marime;
    private int cantitate;



    public Tip_produs(String categorie, double pret, String marime, int cantitate){
        this.categorie=categorie;
        this.pret=pret;
        this.marime=marime;
        this.cantitate=cantitate;

    }


    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setMarime(String marime){
        this.marime=marime;
    }

    public void setCantitate(int cantitate){
        this.cantitate=cantitate;
    }

    public double getPret() {
        return pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getMarime(){
        return marime;
    }

    public int getCantitate(){
        return cantitate;
    }




    public String ToString(){
        return " Produsul " + categorie +", marimea " + marime + " cu pretul de: " + pret + " este disponibil in magazinul nostru! Cantitea de bucati este:  " + cantitate;

    }

}
