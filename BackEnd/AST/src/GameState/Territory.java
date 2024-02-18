package GameState;

import Expr.SyntaxErrorException;

import java.util.List;

public class Territory {
    private int territory_row ;
    private  int territory_col;
//    private int init_plan_min = 0 ;
//    private int init_plan_sec = 0 ;
//    private double init_budget = 0 ;
//    private double init_center_dep = 0 ;
//    private double plan_rev_min = 0 ;
//    private  double plan_rev_sec = 0 ;
    private  double rev_cost = 0;

    private final double fee = 1 ;

    protected double max_dep;
    protected double interest_pct;
    protected int turn = 1;
    private  int round = 0;

    private List<Player> player_num;
    private Region[][] territory;


    Territory(){}

    public Territory(List<Player> player_num, int m, int n, long init_budget, long init_center_dep, long rev_cost, long interest_pct, long max_dep){
        this.territory_col = n;
        this.player_num = player_num;
        this.rev_cost = rev_cost;
        this.max_dep = max_dep;
        this.interest_pct = interest_pct;
        this.territory = new Region[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                territory[i][j] = new Region(i, j);
            }
        }
        setAdjacentRegion();


    }
    private void setAdjacentRegion(){
        for (int i = 0; i < territory_row; i++){
            for (int j = 0; j < territory_col; j++){
                Region pointer = territory[i][j];
                if (i > 0) pointer.up = territory[i - 1][j];
                if (i < territory_row - 1) pointer.down = territory[i + 1][j];
                if (j%2== 0) {
                    if(j > 0) {pointer.upleft = territory[i][j-1];}
                    if(j > 0 && i <= territory_row-1){pointer.downleft = territory[i+1][j-1];}
                    if(j <= territory_col-1 ) {pointer.upright = territory[i][j+1];}
                    if(j <= territory_col-1 && i <= territory_row-1 ) {pointer.downright = territory[i+1][j+1];}
                }else{
                    if(i > 0) {pointer.upleft = territory[i-1][j-1];}
                    if(j <= territory_col-1){pointer.downleft = territory[i][j-1];}
                    if(i > 0 && j<=territory_col-1) {pointer.upright = territory[i-1][j+1];}
                    if(j<=territory_col-1) {pointer.downright = territory[i][j+1];}
                }
            }

        }
    }
    public void calculateInterest(Player user){
        user.CalculateInterestRate();
    }
    public void updateTurn() throws SyntaxErrorException {
        player_num.get(round).evaluatePlan();
        calculateInterest(player_num.get(round));
        round = (round + 1) % player_num.size();
        if (round == 0) turn++;
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
    public double getMax_dep() {
        return max_dep;
    }
}
