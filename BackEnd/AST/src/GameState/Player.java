package GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Expr.ConstructionPlan;
import Parser.ConstructionPlanParser;
import Parser.Tokenizer;

public class Player {
    public String name;
    public boolean life;
    private Territory territory;
    private ConstructionPlan plan;
    public final Map<String, Double> variable;
    public final List<Region> regionSet;
    public Region cityCenter;
    public Region cityCrew;

    private double budget = 0;

    public Player(String name, Territory territory, ConstructionPlan plan, Map<String, Double> variable, List<Region> regionSet, Region cityCenter) {
        this.name = name;
        this.territory = territory;
        this.plan = plan;
        this.variable = variable;
        this.regionSet = new ArrayList<>();
        regionSet.add(cityCenter);
        this.cityCenter = this.cityCrew = cityCenter ;
        this.cityCenter.owner = this ;

    }
    public void setPlan(List<String> text){
        Tokenizer tkz = new Tokenizer(text);
        ConstructionPlanParser plan = new ConstructionPlanParser(tkz);

    }
    public Territory territory(){
        return territory;
    }

    public Region getCityCenter(){
        return cityCenter;
    }

    public double getBudget(){
        return budget;
    }

    public void addBudget(double n){
        budget += n;
    }

    public void subBudget(double n){
        budget = Math.max(0,budget-n);
    }
}
