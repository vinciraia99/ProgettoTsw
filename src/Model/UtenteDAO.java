package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {
    public Utente doRetrieveByUsernamePassword(String e_mail, String password){ //Funzione per il login
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT e_mail,nome,cognome,data_nascita,password,carta_di_credito FROM utente where e_mail=? and password=SHA1(?)");
            ps.setString(1,e_mail);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            Utente p = new Utente();
            if(rs.next()) {
                p.setE_mail(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setData_nascita(rs.getString(4));
                p.setPassword(rs.getString(5));
                p.setCarta_di_credito(rs.getString(6));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(Utente u){ //Funzione che permette di inserire un utente all'interno del database
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("insert into  utente(e_mail,nome,cognome,data_nascita,password) " +
                                    "values (?,?,?,?,?);");
            ps.setString(1,u.getE_mail());
            ps.setString(2,u.getNome());
            ps.setString(3,u.getCognome());
            ps.setString(4,u.getData_nascita());
            ps.setString(5,u.getPassword());
            ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
