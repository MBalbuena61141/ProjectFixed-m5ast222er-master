package Model;

public class Movie {

    private int movieID;
    private String movieTitle;
    private String movieUrl;

    public Movie(int movieID, String movieTitle, String fileName) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieUrl = fileName;

    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }


    @Override
    public String toString() {
        return "movie{" +
                "movieID=" + movieID +
                ", movieTitle='" + movieTitle + '\'' +
                ", fileName='" + movieUrl + '\'' +
                '}';
    }
}



