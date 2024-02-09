package GameState;

import java.util.List;

public class Territory {
    static  private  double fee = 1 ;
    private int territory_row = 0;
    private int territory_col = 0;
    private double revision_cost = 0;
    private int player_turn = 0;


    static protected double DEPOSIT_Max;
    static protected int turn = 1;
    static protected double baseInterestRate;

    private List<Player> player_num;
    private Region[][] territory;



    public double getDEPOSIT_Max() {
        return DEPOSIT_Max;
    }
    Territory(){}

    public Territory(List<Player> player_num, int m, int n, long init_budget, long init_center_dep, long rev_cost, long interest_pct, long DEPOSIT_Max){
        territory_row = m;
        territory_col = n;
        this.player_num = player_num;
        revision_cost = rev_cost;
        this.DEPOSIT_Max = DEPOSIT_Max;
        baseInterestRate = interest_pct;
        territory = new Region[m][n];

    }
    public void calculateInterest(Player user){
        for(Region region : user.regionSet){
        }
    }
}
