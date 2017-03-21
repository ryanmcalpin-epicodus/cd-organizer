public class CD {
  private String mArtist;
  private String mAlbum;
  private String mGenre;
  private int mRelease;

  public CD(String artist, String album, String genre, int release) {
    mArtist = artist;
    mAlbum = album;
    mGenre = genre;
    mRelease = release;
  }

  public String getArtist() {
    return mArtist;
  }

  public String getAlbum() {
    return mAlbum;
  }

  public String getGenre() {
    return mGenre;
  }

  public int getRelease() {
    return mRelease;
  }

}
