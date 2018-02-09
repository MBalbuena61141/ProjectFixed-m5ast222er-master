package Model;

public class MovieGenre {
    private int movieID;
    private int genreID;

    public MovieGenre (int movieID, int genreID){

        this.movieID = movieID;
        this.genreID = genreID;

    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }
}
