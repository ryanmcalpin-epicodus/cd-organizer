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

  }
}
