package Model;

public class Movie {

    private int movieID;
    private String movieTitle;
    private String movieUrl;
    private  String movieImage;

    public Movie(int movieID, String movieTitle, String movieUrl) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieUrl = movieUrl;
        this.movieImage = movieImage;

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

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieUrl='" + movieUrl + '\'' +
                ", movieImage='" + movieImage + '\'' +
                '}';
    }
}



