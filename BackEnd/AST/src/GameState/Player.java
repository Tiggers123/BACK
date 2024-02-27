package GameState;

import java.util.*;

import Expr.ConstructionPlan;
import Expr.SyntaxErrorException;
import Parser.ConstructionPlanParser;
import Parser.Tokenizer;
import Statement.Command.ActionCommand;
import Statement.Statement;

public class Player {
    public String name;
    public boolean life;
    private Territory territory;
    private ConstructionPlan plan;
    public final Map<String, Double> variable;
    private final List<Region> regionList;
    private Region cityCenter;
    private Region cityCrew;
    private double budget = 0;

    public Player(String name, Territory territory, Region cityCenter) {
        this.name = name;
        this.territory = territory;
        this.life = true;
        LinkedList<Statement> initial = new LinkedList<>();
        Statement done = new ActionCommand("done");
        initial.add(done);
        this.plan = new ConstructionPlan(initial);
        this.variable = new HashMap<>();
        this.regionList = new ArrayList<>();
        regionList.add(cityCenter);
        this.cityCenter = this.cityCrew = cityCenter ;
        cityCenter.setOwner(this);

    }
    public void setPlan(List<String> text) throws Parser.SyntaxErrorException {
        ConstructionPlanParser plan = new ConstructionPlanParser(text);
        List<Statement> constructionPlan = plan.parse();
        this.plan = new ConstructionPlan(constructionPlan);
        this.subBudget(territory.getRev_cost());
    }
    public Territory territory(){
        return territory;
    }
    public void addRegion(Region region){
        regionList.add(region);
    }
    public void removeRegion(Region region){
        regionList.remove(region);
    }

    public boolean regionContain(Region region){
        return regionList.contains(region);
    }

    public double getVariable(String varName) {
        return variable.getOrDefault(varName, 0.0); // Return 0.0 if variable doesn't exist
    }
    public void setVariable(String varName, double value) {
        variable.put(varName, value);
    }


    // look like this method it not good to use but not sure i will comment it first by Ton
//    public boolean regionListAdjacent(Region regionTocheck){
//        for (Region region : this.regionList) {
//            if (region.adjacentCheck(regionTocheck)){
//                return true ;
//            }
//        }
//        return false ;
//    }

    public Region getCityCenter(){
        return cityCenter;
    }

    public Region getCityCrew() {return cityCrew;}

    public void setCityCrew(Region cityCrew) {this.cityCrew = cityCrew;}

    public void setCityCenter(Region cityCenter) {this.cityCenter = cityCenter;}

    public double getBudget(){
        return budget;
    }

    public void addBudget(double n){
        budget += n;
    }

    public void subBudget(double n){
        budget = Math.max(0,budget-n);
    }
    public void LoseGame() {
        for (Region region : regionList){
            region.setOwner(null);
        }
        regionList.clear();
        life = false ;
    }
    public void evaluatePlan() throws SyntaxErrorException {
        try{
            this.plan.execute(this);
        } catch (SyntaxErrorException e) {
            System.out.println(e.getMessage());
        }
    }
    public void CalculateInterestRate(){
        for (Region region : regionList){
            region.InterestRate();
        }
    }
    // For Testing

    public ConstructionPlan getPlan() {
        return plan;
    }
    public void blink(Territory map , int x , int y) {
        Region blinkTO = map.getRegion(x,y);
        this.cityCrew = blinkTO;
    }

}
