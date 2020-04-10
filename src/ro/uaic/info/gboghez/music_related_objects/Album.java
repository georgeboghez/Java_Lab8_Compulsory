package ro.uaic.info.gboghez.music_related_objects;

/**
 * A class representing an album having an id equal to the one inside the database, its name and its release year
 */
public class Album {
    private int id;
    private String name;
    private int release_year;

    public Album(int id, String name, int release_year) {
        this.id = id;
        this.name = name;
        this.release_year = release_year;
    }

    /**
     * gets the id of the album
     * @return an integer representing the id of the album
     */
    public int getId() {
        return id;
    }

    /**
     * gets the name of the album
     * @return a String representing the name of the album
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the album
     * @param name a String representing the name of the album
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the realease_year of the album
     * @return an integer representing the release year of the album
     */
    public int getRelease_year() {
        return release_year;
    }

    /**
     * sets the name of the album
     * @param release_year an integer representing the release year of the album
     */
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
