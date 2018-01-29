package Model;

public class UserWatchList {
    private int userID;
    private int movieID;
    private String movieName;

    public UserWatchList(int userID, int movieID, String movieName) {
        this.userID = userID;
        this.movieID = movieID;
        this.movieName = movieName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "userWatchList{" +
                "movieName='" + movieName + '\'' +
                '}';
    }
}

