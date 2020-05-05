package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MediaDAO {
    /***
     *
     * @return An ArrayList of all the media
     */
    public ArrayList<Media> doRetrieveAll(){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT categoria, immagine,data  FROM prodotto ");
            ResultSet rs = ps.executeQuery();
            ArrayList<Media> m = new ArrayList<>();
            while (rs.next()) {
                Media media_add = new Media(rs.getString(1),rs.getString(2),
                        rs.getString(3));
                m.add(media_add);
            }
            return m;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     *
     * @param categoria Category of the media
     * @return An ArrayList of the media belonging to the same category
     */
    public ArrayList<Media> doRetrievebyCategoria(String categoria){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT categoria , immagine , data " +
                            "FROM media where categoria= ?;");
            ps.setString(1,categoria);
            ResultSet rs =  ps.executeQuery();
            ArrayList<Media> m = new ArrayList<>();
            while (rs.next()) {
                Media media_add = new Media(rs.getString(1), rs.getString(2) ,
                                        rs.getString(3));
                m.add(media_add);
            }
            return m;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
