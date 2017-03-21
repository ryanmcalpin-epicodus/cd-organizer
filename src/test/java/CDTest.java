import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly() {
    CD testCD = new CD("artist", "album", "genre", 2017);
    assertEquals(true, testCD instanceof CD);
  }

  @Test
  public void getArtist_returnsCorrectly_String() {
    CD testCD = new CD("artist", "album", "genre", 2017);
    assertEquals("artist", testCD.getArtist());
  }

  @Test
  public void getAlbum_returnsCorrectly_String() {
    CD testCD = new CD("artist", "album", "genre", 2017);
    assertEquals("album", testCD.getAlbum());
  }

  @Test
  public void getGenre_returnsCorrectly_String() {
    CD testCD = new CD("artist", "album", "genre", 2017);
    assertEquals("genre", testCD.getGenre());
  }

  @Test
  public void getRelease_returnsCorrectly_2017() {
    CD testCD = new CD("artist", "album", "genre", 2017);
    assertEquals(2017, testCD.getRelease());
  }

}
