package Model;

public class UserWatchList {
    private int userID;
    private int movieID;


    public UserWatchList(int userID, int movieID) {
        this.userID = userID;
        this.movieID = movieID;

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
}


