package Model;

public class YoutubeUrl {

    private String movieUrl;
    private int movieID;
    private int urlID;


    public YoutubeUrl(String movieUrl, int movieID, int urlID) {

        this.movieUrl = movieUrl;
        this.movieID = movieID;
        this.urlID = urlID;

    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public int getUrlID() {
        return urlID;
    }

    public void setUrlID(int urlID) {
        this.urlID = urlID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;


    }

    @Override
    public String toString() {
        return "YoutubeUrl{" +
                "movieUrl='" + movieUrl + '\'' +
                '}';
    }
}



