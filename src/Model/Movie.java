package Model;

public class Movie {

    private int movieID;
    private String movieTitle;
    private String fileName;

    public Movie(int movieID, String movieTitle, String fileName) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.fileName = fileName;

    }

    public int getmovieID() {
        return movieID;
    }

    public void setmovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getmovieTitle() {
        return movieTitle;
    }

    public void setmovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getfileName() {
        return fileName;
    }

    public void setfileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "movie{" +
                "movieID=" + movieID +
                ", movieTitle='" + movieTitle + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}



