package GameState;

public class Region {
    private int row;
    private int col;
    private double deposit;
    public Region up = null, upright = null, upleft = null, down = null, downright = null, downleft = null;
    public Player owner = null;
    public Region(int x , int y){
        this.row = x ;
        this.col = y ;
    }
    public double getDeposit(){
        return deposit;
    }
    public void addDeposit(double n){
        deposit = Math.min(Territory.DEPOSIT_Max,deposit+n);
    }
    public void subDeposit(double n){
        deposit = Math.max(0,deposit-n);
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    public double getInterestRate(){
        return Territory.baseInterestRate * Math.log10(deposit)*Math.log(Territory.turn);
    }
}
