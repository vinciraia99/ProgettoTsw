package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrelloDAO {
    /***
     *
     * @param e_mail of the owner
     * @return The cart belonged to the owner
     */
    public Carrello doRetrievebyEmail(String e_mail){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT e_mail , prodotto ,prezzo_effettivo" +
                            "FROM carrello where e_mail= ?;");
            ps.setString(1,e_mail);
            ResultSet rs =  ps.executeQuery();
            Carrello carrello= new Carrello();
            if(rs.next()){
                carrello.setE_mail(rs.getString(1));
                carrello.setCodProdotto(rs.getString(2));
                carrello.setPrezzoEffettivo(rs.getDouble(3));
            }
            return carrello;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
