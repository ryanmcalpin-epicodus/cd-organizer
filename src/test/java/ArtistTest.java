import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void artist_instantiatesCorrectly_true() {
    Artist testArtist = new Artist("True Widow");
    assertEquals(true, testArtist instanceof Artist);
  }

  @Test
  public void getName_artistInstantiatesWithName_String() {
    Artist testArtist = new Artist("True Widow");
    assertEquals("True Widow", testArtist.getName());
  }

  @Test
  public void all_returnsAllInstancesOfArtist_true() {
    Artist firstArtist = new Artist("True Widow");
    Artist secondArtist = new Artist("Witch Tooth");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }

  @Test
  public void clear_emptiesAllArtitsFromList_0() {
    Artist testArtist = new Artist("True Widow");
    Artist.clear();
    assertEquals(0, Artist.all().size());
  }

  @Test
  public void getId_artistsInstantiatesWithAnId_1() {
    Artist testArtist = new Artist("True Widow");
    assertEquals(1, testArtist.getId());
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist.clear();
    Artist firstArtist = new Artist("True Widow");
    Artist secondArtist = new Artist("Witch Tooth");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

  @Test
  public void getCDs_initiallyReturnsEmptyList_ArrayList() {
    Artist.clear();
    Artist testArtist = new Artist("True Widow");
    assertEquals(0, testArtist.getCDs().size());
  }

  @Test
  public void addCD_addsCDToList_true() {
    Artist.clear();
    Artist testArtist = new Artist("True Widow");
    CD testCD = new CD("True Widow", "Yeaa", "Stone Gaze", 1999);
    testArtist.addCD(testCD);
    assertTrue(testArtist.getCDs().contains(testCD));
  }
}
