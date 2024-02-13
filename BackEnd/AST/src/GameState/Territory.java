package GameState;

import java.util.List;

public class Territory {
    private final double fee = 1 ;
    private int territory_row = 0;
    private  int territory_col = 0;
    private  double revision_cost = 0;
    private  int player_turn = 0;


    protected double DEPOSITMax;
    protected int turn = 1;
    protected double baseInterestRate;

    private List<Player> player_num;
    private Region[][] territory;



    public double getDEPOSITMax() {
        return DEPOSITMax;
    }
    Territory(){}

    public Territory(List<Player> player_num, int m, int n, long init_budget, long init_center_dep, long rev_cost, long interest_pct, long DEPOSITMax){
        territory_row = m;
        territory_col = n;
        this.player_num = player_num;
        revision_cost = rev_cost;
        this.DEPOSITMax = DEPOSITMax;
        baseInterestRate = interest_pct;
        territory = new Region[m][n];

    }
    public void calculateInterest(Player user){
        for(Region region : user.regionSet){
        }
    }

    public int getTerritory_col() {
        return territory_col;
    }

    public int getTerritory_row() {
        return territory_row;
    }

    public double getFee() {
        return fee;
    }
}
