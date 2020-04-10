package ro.uaic.info.gboghez.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ro.uaic.info.gboghez.db.DatabaseConnection;
import ro.uaic.info.gboghez.music_related_objects.Artist;

/**
 * A DAO class meant to give the user access to the database through its methods, specifically to search or insert artists
 */
public class ArtistController {
    private DatabaseConnection databaseConnection;

    /**
     * calls the getInstance static method from DatabaseConnection in order to get the unique DatabaseConnection object
     */
    public ArtistController() {
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * inserts an artist into the database
     * @param name a String representing the name of the artist
     * @param country a String representing the artist's country
     * @return whether the row was inserted or not
     */
    public boolean create(String name, String country) {
        try {
            String sqlStatement = "INSERT INTO artists(name, country) values(" + "'" + name + "'" + "," + "'" + country + "'" + ")";
            Statement stm = databaseConnection.getConnection().createStatement();
            int rs = stm.executeUpdate(sqlStatement);
            if (rs > 0) {
                System.out.println("Succesfully inserted artist " + name + " into the database");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * searches the artist searched by the name
     * @param name a String representing the name of the artist
     * @return an Artist object with afferent data to the one searched by a name or null if the database doesn't contain any row with the given name
     */
    public Artist findByName(String name) {
        Artist artist = null;
        try {
            String sqlStatement = "SELECT id, name, country FROM artists WHERE name = '" + name + "'";
            Statement stm = databaseConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sqlStatement);
            if (rs.next()) {
                artist = new Artist(rs.getInt("id"), rs.getString("name"), rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return artist;
    }

    /**
     * closes the connection to the database
     */
    public void closeConnection() {
        try {
            databaseConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
