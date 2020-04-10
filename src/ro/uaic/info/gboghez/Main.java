package ro.uaic.info.gboghez;

import ro.uaic.info.gboghez.controllers.AlbumController;
import ro.uaic.info.gboghez.controllers.ArtistController;
import ro.uaic.info.gboghez.music_related_objects.Album;
import ro.uaic.info.gboghez.music_related_objects.Artist;

public class Main {

    public static void main(String[] args) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        insertRows(albumController, artistController);
        findData(albumController, artistController);

        artistController.closeConnection();
        albumController.closeConnection();
    }

    /**
     * inserts into the database some artists and their albums
     * @param albumController
     * @param artistController
     */
    private static void insertRows(AlbumController albumController, ArtistController artistController) {
        String[] artists = {"Scorpions", "AC/DC", "Queen", "Imagine Dragons", "Jungle"};
        String[] countries = {"Germany", "Australia", "Great Britain", "USA", "Great Britain"};
        String[] albums = {"Blackout", "BACK IN BLACK", "A Night At The Opera", "Evolve", "For Ever"};
        int[] release_years = {1982, 1980, 1975, 2017, 2018};

        for (int i = 0; i < release_years.length; i++) {
            artistController.create(artists[i], countries[i]);
            Artist artist = artistController.findByName(artists[i]);
            albumController.create(albums[i], artist.getId(), release_years[i]);
        }
    }

    /**
     * searches the database for some artists and their albums
     * @param albumController
     * @param artistController
     */
    private static void findData(AlbumController albumController, ArtistController artistController) {
        Artist artist;
        Album album;
        String[] artists = {"Scorpions", "AC/DC", "Queen", "Imagine Dragons", "Jungle"};

        for (String artistName : artists) {
            artist = artistController.findByName(artistName);
            album = albumController.findByName(artist.getId());
            printInfo(album, artist);
        }
    }

    /**
     * prints info about the specified artist and album
     * @param album an Album object
     * @param artist an Artist object
     */
    private static void printInfo(Album album, Artist artist) {
        System.out.println(artist.getName() + " - " + artist.getCountry());
        System.out.println(album.getName() + " - " + album.getRelease_year());
    }
}
