package Model;

import java.util.Objects;

public class Carrello {
    private String e_mail;
    private String codProdotto;
    private double prezzoEffettivo;

    public String toString() {
        return "Carrello{" +
                "e_mail='" + e_mail + '\'' +
                ", codProdotto='" + codProdotto + '\'' +
                ", prezzoEffettivo=" + prezzoEffettivo +
                '}';
    }
    public String getE_mail() {
        return e_mail;
    }

    public String getCodProdotto() {
        return codProdotto;
    }

    public double getPrezzoEffettivo() {
        return prezzoEffettivo;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setCodProdotto(String codProdotto) {
        this.codProdotto = codProdotto;
    }

    public void setPrezzoEffettivo(double prezzoEffettivo) {
        this.prezzoEffettivo = prezzoEffettivo;
    }

    public Carrello(){
    }
    public Carrello(String e_mail, String codProdotto, double prezzoEffettivo){
        this.e_mail = e_mail;
        this.codProdotto = codProdotto;
        this.prezzoEffettivo=prezzoEffettivo;
    }

}
