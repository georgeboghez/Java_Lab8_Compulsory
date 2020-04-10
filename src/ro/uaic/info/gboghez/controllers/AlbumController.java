package ro.uaic.info.gboghez.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ro.uaic.info.gboghez.db.DatabaseConnection;
import ro.uaic.info.gboghez.music_related_objects.Album;

/**
 * A DAO class meant to give the user access to the database through its methods, specifically to search or insert albums
 */
public class AlbumController {
    private DatabaseConnection databaseConnection;

    /**
     * calls the getInstance static method from DatabaseConnection in order to get the unique DatabaseConnection object
     */
    public AlbumController() {
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * inserts an album into the database
     * @param name a String representing the name of the album
     * @param artistId an integer representing the id of the artist from the database
     * @param releaseYear an integer representing the release year of the artist
     * @return whether the row was inserted or not
     */
    public boolean create(String name, int artistId, int releaseYear) {
        try {
            String sqlStatement = "INSERT INTO albums(name, artist_id, release_year) values(" + "'" + name + "'" + "," + artistId + "," + releaseYear + ")";
            Statement stm = databaseConnection.getConnection().createStatement();

            int rs = stm.executeUpdate(sqlStatement);
            if(rs > 0) {
                System.out.println("Succesfully inserted album " + name + " into the database");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * searches the album searched by its name
     * @param artistId an integer representing the id of the album
     * @return an Album object with afferent data to the one searched by a name inside the db or null if the database doesn't contain any row with the given name
     */
    public Album findByName(int artistId) {
        Album album = null;
        try {
            String sqlStatement = "SELECT id, name, release_year FROM albums WHERE artist_id = " + artistId;
            Statement stm = databaseConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sqlStatement);
            if(rs.next()) {
                album = new Album(rs.getInt("id"), rs.getString("name"), rs.getInt("release_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return album;
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
