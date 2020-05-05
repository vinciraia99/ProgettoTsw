package Model;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO {
    /***
     *
     * @return An ArrayList of all the product in the DB
     */
    public ArrayList<Prodotto> doRetrieveAll(){
            try (Connection con = ConPool.getConnection()) {
        PreparedStatement ps =
                con.prepareStatement("SELECT codice, nome, marca,immagine,sconto,prezzo,categoria,descrizione " +
                                            "FROM prodotto ");
        ResultSet rs = ps.executeQuery();
        ArrayList<Prodotto> p = new ArrayList<>();
        while (rs.next()) {
            Prodotto prodotto_add = new Prodotto(rs.getString(1),rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getDouble(6),rs.getString(7));
            prodotto_add.setSconto(rs.getInt(5));
            prodotto_add.setDescrizione(rs.getString(8));
        }
        return p;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    /***
     *
     * @param categoria Category for the research
     * @return An ArrayList of all the products belonging to the same category
     */
    public ArrayList<Prodotto> doRetrievebyCategoria(String categoria){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, marca,immagine,sconto,prezzo,categoria,descrizione " +
                                    "FROM prodotto where categoria= ?;");
            ps.setString(1,categoria);
            ResultSet rs =  ps.executeQuery();
            ArrayList<Prodotto> p = new ArrayList<>();
            while (rs.next()) {
                Prodotto prodotto_add = new Prodotto(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getDouble(6),rs.getString(7));
                prodotto_add.setSconto(rs.getInt(5));
                prodotto_add.setDescrizione(rs.getString(8));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
