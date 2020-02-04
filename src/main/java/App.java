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
    public static void main(String[] args){
        staticFileLocation("/public");

        get("heros/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heros/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String squadName = request.queryParams("squad");
            Hero newHero = new Hero(name, age, power, weakness, squadName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request,response)->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAllHeros();
            model.put("heros", heros);
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