import com.github.jknack.handlebars.Handlebars;
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import static spark.Spark.*;

public class App{
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("heros/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heros/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            request.session().attribute("name", name);
            String power = request.queryParams("power");
            request.session().attribute("power", power);
            String weakness = request.queryParams("weakness");
            request.session().attribute("weakness", weakness);
            Integer age = Integer.parseInt(request.queryParams("age"));
            request.session().attribute("age", age);
            String squadName = request.queryParams("squad");
            request.session().attribute("squadName", squadName);
            Hero newHero = new Hero(name, age, power, weakness, squadName);
            Squad newSquad = new Squad(newHero);
            model.put("squadName", request.session().attribute("squadName"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request,response)->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAllHeros();
            ArrayList<Squad> squads = Squad.getAllInstances();
            model.put("heros", heros);
            model.put("squads", squads);
            System.out.println("-----------------------------------------------------");
            System.out.println(squads);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("heros/:id", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero lookedForHero = Hero.findById(idOfHeroToFind);
            model.put("lookedForHero", lookedForHero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //create a function to display edit form on request
        get("/heros/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "edit-form.hbs");
        }, new HandlebarsTemplateEngine());


        //create a function to update a hero after edit details are submitted
        post("/heros/:id/update", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            String name = request.queryParams("name");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String squad = request.queryParams("squad");
            editHero.update(name, age, power, weakness, squad);
            return new ModelAndView(model, "edit-success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}