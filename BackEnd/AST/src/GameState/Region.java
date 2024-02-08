package GameState;

public class Region extends Territory{
    private int row;
    private int col;
    private long deposit;
    public Region up = null, upright = null, upleft = null, down = null, downright = null, downleft = null;
    public Player owner = null;
}
