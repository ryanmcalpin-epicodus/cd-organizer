import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cd", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CD> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<CD>();
        request.session().attribute("cds", cds);
      }

      String artist = request.queryParams("artist");
      String album = request.queryParams("album");
      String genre = request.queryParams("genre");
      int release = Integer.parseInt(request.queryParams("release"));
      CD newCD = new CD(artist, album, genre, release);
      cds.add(newCD);

      model.put("cds", cds);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artist/:id/cDs/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);
      model.put("template", "templates/artist-cD-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.queryParams("artistId")));

      String albumName = request.queryParams("albumName");
      String genre = request.queryParams("genre");
      int year = Integer.parseInt(request.queryParams("year"));
      CD newCD = new CD(artist.getName(), albumName, genre, year);

      artist.addCD(newCD);

      model.put("artist", artist);
      model.put("template", "templates/artist-cD-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Artist newArtist = new Artist(name);
      model.put("template", "templates/artist-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("artists", Artist.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
