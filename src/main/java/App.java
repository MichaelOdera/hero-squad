import com.github.jknack.handlebars.Handlebars;
import models.Hero;
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
            Hero newHero = new Hero(name, age, power, weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request,response)->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAllHeros();
            model.put("heros", heros);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}