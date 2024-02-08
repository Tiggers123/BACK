package GameState;

import java.util.List;

public class Territory {
    private int territory_row;
    private int territory_col;
    private int revision_cost;
    private int player_turn = 0;
    private int turn = 1;
    public List<Player> player_num;
    public Region[][] territory;
}
