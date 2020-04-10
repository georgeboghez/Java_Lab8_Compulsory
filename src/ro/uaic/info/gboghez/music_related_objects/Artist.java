package ro.uaic.info.gboghez.music_related_objects;

/**
 * A class representing a person (who is an artist) or a band having an id equal to the one inside the database, a name and a country
 */
public class Artist {
    private int id;
    private String name;
    private String country;

    public Artist(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    /**
     * gets the id of the artist
     * @return an integer representing the id of the artist
     */
    public int getId() {
        return id;
    }

    /**
     * gets the name of the artist
     * @return a String representing the name of the artist
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the artist
     * @param name a String representing the name of the artist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the artist's country
     * @return a String representing the artist's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets the artist's country
     * @param country a String representing the artist's country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
