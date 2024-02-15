package GameState;

public class Region extends Territory {
    private int row;
    private int col;
    private double deposit;
    public Region up = null, upright = null, upleft = null, down = null, downright = null, downleft = null;
    public Player owner = null;
    public Region(int x , int y){
        this.row = x ;
        this.col = y ;
    }
//    public boolean adjacentCheck(Region region){
//        if (region == up || region == upright || region == upleft || region == down || region == downright || region == downleft){
//            return true ;
//        }
//        return false;
//    }

    public double getDeposit(){
        return deposit;
    }
    public void addDeposit(double n){
        deposit = Math.min(super.DEPOSITMax,deposit+n);
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
        return super.baseInterestRate * Math.log10(deposit)*Math.log(super.turn);
    }
    public Region moveDirection(String direction){
        if (direction.equals("up"))return this.up;
        if (direction.equals("down")) return this.down;
        if (direction.equals("upleft"))return this.upleft;
        if (direction.equals(" upright"))return this.upright;
        if (direction.equals("downleft"))return this.downleft;
        return this.downright;


    }
    public void DeleteRegion(Player player){
        if(player.getCityCenter().equals(this)){
            player.LoseGame();
        } else {
            if(!player.regionList.contains(this)) return;
            player.regionList.remove(this);
            this.owner = null;
        }
    }
    public void InterestRate(){
        double b = super.baseInterestRate;
        double d = this.deposit ;
        double t = super.turn ;
        double r = b * Math.log10(d) * Math.log(t);
        this.deposit = d*r/100 ;

    }

}
