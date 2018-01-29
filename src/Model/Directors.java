package Model;

public class Directors {
    private int directorID;
    private String directorName;

    public Directors(int directorID, String directorName) {
        this.directorID = directorID;
        this.directorName = directorName;
    }


    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;

    }

    @Override
    public String toString() {
        return directorName;
    }
}