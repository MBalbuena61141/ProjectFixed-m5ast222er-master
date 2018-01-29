package Model;

public class YoutubeUrl {

    private char url;
    private int movieID;
    private int urlID;


    public YoutubeUrl(char url, int movieID, int urlID) {

        this.url = url;
        this.movieID = movieID;
        this.urlID = urlID;
    }

    public char getUrl() { return url;
    }

    public void setUrl(char url) { this.url = url;
    }

    public int getMovieID() { return movieID;
    }

    public void setMovieID(int movieID) { this.movieID = movieID;
    }

    public int getUrlID() {
        return urlID;
    }

    public void setUrlID(int urlID) {
        this.urlID = urlID;
    }

    @Override
    public String toString() {
        return "YoutubeUrl{" +
                "url=" + url +
                '}';
    }
}

