package GameState;

import java.util.List;

public class Territory {
    private int territory_row = 0;
    private  int territory_col = 0;
    private int init_plan_min = 0 ;
    private int init_plan_sec = 0 ;
    private double init_budget = 0 ;
    private double init_center_dep = 0 ;
    private double plan_rev_min = 0 ;
    private  double plan_rev_sec = 0 ;
    private  double rev_cost = 0;
    private  int player_turn = 0;

    private final double fee = 1 ;

    protected double max_dep;
    protected double interest_pct;
    protected int turn = 1;

    private List<Player> player_num;
    private Region[][] territory;



    public double getMax_dep() {
        return max_dep;
    }
    Territory(){}

    public Territory(List<Player> player_num, int m, int n, long init_budget, long init_center_dep, long rev_cost, long interest_pct, long max_dep){
        this.territory_row = m;
        this.territory_col = n;
        this.player_num = player_num;
        this.rev_cost = rev_cost;
        this.max_dep = max_dep;
        this.interest_pct = interest_pct;
        this.territory = new Region[m][n];

    }
    public void calculateInterest(Player user){
        user.CalculateInterestRate();
    }
    public void updateTurn(){}

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
