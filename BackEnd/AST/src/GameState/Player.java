package GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Expr.ConstructionPlan;
import Expr.SyntaxErrorException;
import Parser.ConstructionPlanParser;
import Parser.Tokenizer;

public class Player {
    public String name;
    public boolean life;
    private Territory territory;
    private ConstructionPlan plan;
    public final Map<String, Double> variable;
    public final List<Region> regionList;
    public Region cityCenter;
    public Region cityCrew;
    
    private double budget = 0;

    public Player(String name, Territory territory, ConstructionPlan plan, Map<String, Double> variable, List<Region> regionList, Region cityCenter) {
        this.name = name;
        this.territory = territory;
        this.plan = plan;
        this.variable = variable;
        this.regionList = new ArrayList<>();
        regionList.add(cityCenter);
        this.cityCenter = this.cityCrew = cityCenter ;
        this.cityCenter.owner = this ;

    }
    public void setPlan(List<String> text) throws Parser.SyntaxErrorException {
        Tokenizer tkz = new Tokenizer(text);
        ConstructionPlanParser plan = new ConstructionPlanParser(tkz);
        this.plan = new ConstructionPlan(plan.parse());


    }
    public Territory territory(){
        return territory;
    }
    public boolean regionListAdjacent(Region regionTocheck){
        for (Region region : this.regionList) {
            if (region.adjacentCheck(regionTocheck)){
                return true ;
            }
        }
        return false ;
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
    public void LoseGame(){
        for(Region region : regionList)
            region.owner = null;
        regionList.clear();
        life = false ;
    }
    public void evaluatePlan() throws SyntaxErrorException {
        this.plan.execute(this);
        this.cityCrew = this.cityCenter;
    }

}
