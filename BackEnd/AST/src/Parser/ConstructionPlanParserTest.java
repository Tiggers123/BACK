package Parser;

import GameState.Player;
import GameState.Territory;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionPlanParserTest {
    private List<String> Command(String command){
        List<String> file =  new ArrayList<>();
        file.add(command);
        return file;
    }
    public Player setUpGame()  {
        String[] p = {"Ton"};
        Territory map = new Territory(10, 6, 10000, 500, 100, 100, 100, p);
        List<Player> p1 = map.getPlayer();
        return p1.getFirst();
    }

    public List<Player> setUpGame2()  {
        String[] p = {"Ton","Tiger"};
        Territory map = new Territory(10, 6, 10000, 500, 100, 100, 100, p);
        List<Player> p1 = map.getPlayer();
        return p1;
    }


    Player Player = setUpGame();
    Territory territory = Player.territory();
    int row = territory.getTerritory_row();
    int lastRow = row-1;
    int col = territory.getTerritory_col();
    int lastCol = col-1;
    int longest = Math.max(row , col);
    double LongestPath = Math.pow(longest,2);;
    @Test
    void TopLeftConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {

        //Move Up
        Player.blink(territory , 0 , 0);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int i = 0; i <= row; i++) {
            assertEquals(territory.getRegion(0,0),Player.getCityCrew());
            Player.evaluatePlan();

        }


        //Move Upright
        Player.blink(territory , 0 , 0);
        p = Command("move upright");
        Player.setPlan(p);
        assertEquals(territory.getRegion(0,0),Player.getCityCrew());
        Player.evaluatePlan();
        for (int i = 0; i < LongestPath ; i++) {
            assertEquals(territory.getRegion(0,1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , 0 , 0);
        p = Command("move downright");
        Player.setPlan(p);
        int i = 0 ;
        for (int j = 0; j < LongestPath ; j++) {
            if (i < row && j < col){
                if (j%2 == 0 ){
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                    i++;
                }
                else {
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                }
            }else {
                assertNotEquals(null,Player.getCityCrew());
            }
            Player.evaluatePlan();
        }

        // Move Down
        Player.blink(territory , 0 , 0);
        i = 0 ;
        p = Command("move down");
        Player.setPlan(p);
        for (int j = 0; j < row ; j++) {
            assertEquals(territory.getRegion(i,0),Player.getCityCrew());
            Player.evaluatePlan();
            i++;
        }
        assertEquals(territory.getRegion(territory.getTerritory_row()-1,0),Player.getCityCrew());
        Player.evaluatePlan();

        // Move downleft
        Player.blink(territory , 0 , 0);
        p = Command("move downleft");
        Player.setPlan(p);
        for (int j = 0; j < LongestPath ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(0,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , 0 , 0);
        p = Command("move upleft");
        Player.setPlan(p);
        for (int j = 0; j < LongestPath ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(0,0),Player.getCityCrew());
            Player.evaluatePlan();
        }
    }

    @Test
    void TopRightConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {



        //Move Up
        Player.blink(territory , 0 , col-1);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int i = 0; i < row; i++) {
            assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            Player.evaluatePlan();

        }

        //Move Upright
        Player.blink(territory , 0 , col-1);
        p = Command("move upright");
        Player.setPlan(p);
        assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
        Player.evaluatePlan();
        for (int i = 0; i < LongestPath ; i++) {
            assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , 0 , col-1);
        p = Command("move downright");
        Player.setPlan(p);
        for (int i = 0; i < LongestPath ; i++) {
            assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }


        // Move Down
        Player.blink(territory , 0, col-1);
        int i = 0 ;
        p = Command("move down");
        Player.setPlan(p);
        for (int j = 0; j < row ; j++) {
            assertEquals(territory.getRegion(j,col-1),Player.getCityCrew());
            Player.evaluatePlan();
            i++;
        }
        Player.evaluatePlan();
        assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());

        // Move downleft
        Player.blink(territory , 0 , col-1);
        p = Command("move downleft");
        Player.setPlan(p);
        i = 0 ;
        for (int j = col-1; j >= 0 ; j--) {
            if (i < row ){
                if (j%2 == 0 ){
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                    i++;
                }
                else {
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                }
            }else {
                assertNotEquals(null,Player.getCityCrew());
            }
            Player.evaluatePlan();
        }
        Player.evaluatePlan();
        if (col-1 % 2 == 0){
            assertEquals(territory.getRegion(lastRow/2,0),Player.getCityCrew());
        }else {
            assertEquals(territory.getRegion((lastCol-1)/2,0),Player.getCityCrew());
        }

        //Move upleft
        Player.blink(territory , 0 , col-1);
        p = Command("move upleft");
        Player.setPlan(p);
        assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
        for (int j =col-1 ; j > 0 ; j--) {
            Player.evaluatePlan();
            assertNotEquals(null,Player.getCityCrew());
            if ((col-1) %2 == 0){
                assertEquals(territory.getRegion(0,col-2),Player.getCityCrew());
            }else {
                assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            }
        }
    }
    @Test
    void BottomRightConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {


        //Move Up
        Player.blink(territory , row-1 , col-1);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int i = 0; i < row; i++) {
            assertEquals(territory.getRegion(row-1-i,col-1),Player.getCityCrew());
            Player.evaluatePlan();

        }
        //Move Upright
        Player.blink(territory , row-1 , col-1);
        p = Command("move upright");
        Player.setPlan(p);
        assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
        Player.evaluatePlan();
        for (int i = 0; i < LongestPath ; i++) {
            assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , row-1 , col-1);
        p = Command("move downright");
        Player.setPlan(p);
        for (int i = 0; i < LongestPath ; i++) {
            assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        // Move Down
        Player.blink(territory , row-1, col-1);
        int i = row-1 ;
        p = Command("move down");
        Player.setPlan(p);
        for (int j = 0; j < row ; j++) {
            assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
            Player.evaluatePlan();
            i++;
        }

        // Move downleft
        Player.blink(territory , row-1 , col-1);
        p = Command("move downleft");
        Player.setPlan(p);
        i = row-1 ;
        for (int j = col-1; j >= 0 ; j--) {
            if (i < row ){
                if (j%2 == 0 ){
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                    i++;
                }
                else {
                    assertEquals(territory.getRegion(i,j),Player.getCityCrew());
                }
            }else {
                assertNotEquals(null,Player.getCityCrew());
            }
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , row-1 , col-1);
        p = Command("move upleft");
        Player.setPlan(p);
        i = row-1 ;
        int temp = 0;
        assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
        for (int j =col-1 ; j > 0  ; j--) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(i,col-1-temp),Player.getCityCrew());
            if (j % 2 != 0) {
                i--;
            }
            Player.evaluatePlan();
            temp++;

        }
    }
    @Test
    void BottomLeftConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException{

        //Move Up
        Player.blink(territory , row-1 , 0);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int i = 0; i < row; i++) {
            assertEquals(territory.getRegion(row-1-i,0),Player.getCityCrew());
            Player.evaluatePlan();

        }
        //Move Upright
        Player.blink(territory , row-1 , 0);
        p = Command("move upright");
        Player.setPlan(p);
        int temp = 0;
        assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
        int i=row-1;
        for (int j =0 ; j < col-1  ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(i, temp),Player.getCityCrew());
            if (j % 2 != 0) {
                i--;
            }
            Player.evaluatePlan();
            temp++;

        }

        //Move downright
        Player.blink(territory , row-1 , 0);
        p = Command("move downright");
        Player.setPlan(p);
        assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
        for (int j =col-1 ; j > 0  ; j--) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        // Move Down
        Player.blink(territory , row-1, 0);
        p = Command("move down");
        Player.setPlan(p);
        for (int j = 0; j < row ; j++){
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        // Move downleft
        Player.blink(territory , row-1 , 0);
        p = Command("move downleft");
        Player.setPlan(p);
        for (int j = col-1; j >= 0 ; j--){
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , row-1 , 0);
        p = Command("move upleft");
        Player.setPlan(p);
        for (int j = 0; j < LongestPath ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1 , 0),Player.getCityCrew());
            Player.evaluatePlan();
        }
    }
    @Test
    void MiddleMapTest() throws SyntaxErrorException, Expr.SyntaxErrorException{

        int i;
        int midRow = (row-1)/2;
        int midCol = (col-1)/2;


        //Move Up
        Player.blink(territory , midRow , midCol);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int j = midRow; j >= 0; j--) {
            assertEquals(territory.getRegion(j, midCol),Player.getCityCrew());
            Player.evaluatePlan();

        }

        //Move Upright
        Player.blink(territory , midRow , midCol);
        p = Command("move upright");
        Player.setPlan(p);
        i  = midRow ;
        for (int j = midCol; j < LongestPath ; j++) {
            if (j < col){
                if (j%2 == 0 ) {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                }else {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                    i--;
                }
            }

            Player.evaluatePlan();

        }


        //Move downright
        Player.blink(territory , midRow , midCol);
        p = Command("move downright");
        Player.setPlan(p);
        i = midRow ;
        for (int j = midCol; j < LongestPath ; j++) {
            if (j < col){
                if (j%2 == 0 ) {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                    i++;
                }else {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                }
            }

            Player.evaluatePlan();

        }


        // Move Down
        Player.blink(territory , midRow , midCol);
        p = Command("move down");
        Player.setPlan(p);
        for (int j = midRow; j <= row; j++) {
            if (j < row){
                assertEquals(territory.getRegion(j, midCol),Player.getCityCrew());
            }else {
                assertEquals(territory.getRegion(row-1, midCol),Player.getCityCrew());
            }

            Player.evaluatePlan();
        }

        // Move downleft
        Player.blink(territory , midRow , midCol);
        p = Command("move downleft");
        Player.setPlan(p);
        i = midRow ;
        for (int j = midCol; j >= 0; j--) {
            if (j < col){
                if (j%2 == 0 ) {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                    i++;

                }else {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                }
            }
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , midRow , midCol);
        p = Command("move upleft");
        Player.setPlan(p);
        i = midRow ;
        for (int j = midCol; j >= 0; j--) {
            if (j < col){
                if (j%2 == 0 ) {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());

                }else {
                    assertEquals(territory.getRegion(i, j), Player.getCityCrew());
                    i--;
                }
            }
            Player.evaluatePlan();
        }


    }
    @Test
    public void RegionTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        Territory territory = Player.territory();
        Player.blink(territory,0,0);
        // invest Test
        List<String> p = Command("move down invest 100 ");
        Player.setPlan(p);
        Player.evaluatePlan();
        assertEquals(territory.getRegion(1,0).getOwner(),Player);
        Player.evaluatePlan();
        assertEquals(territory.getRegion(2,0).getOwner(),Player);

        //Attack test
        p = Command("shoot up 1000");
        Player.setPlan(p);
        Player.evaluatePlan();
        if (Player.getBudget() > 1000){
            assertNull(territory.getRegion(1, 0).getOwner());
        }else {
            assertNotNull(territory.getRegion(1, 0).getOwner());
        }

        //Relocate test
        p = Command("move down invest 100 relocate");
        Player.setPlan(p);
        Player.evaluatePlan();
        assertEquals(territory.getRegion(3,0).getOwner(),Player);
        assertEquals(territory.getRegion(3,0),Player.getCityCenter());

        // collect
        p = Command("collect (deposit / 4)");
        Player.setPlan(p);
        double money = Player.getBudget();
        Player.evaluatePlan();
        assertEquals(money+ 24 ,Player.getBudget());
    }
    @Test
    public void WhileTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        int MapRow = Player.territory().getTerritory_row()-1;
        int MapCol = 0;
        Territory territory = Player.territory();
        Player.blink(territory,0,0);
        List<String> p = Command("while (budget) { move down invest 100 }");
        Player.setPlan(p);
        Player.evaluatePlan();
        assertEquals(Player.getBudget() , 0);
        assertEquals(territory.getRegion(MapRow , MapCol) , Player.getCityCrew());

    }
    @Test
    public void IfTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        Territory territory = Player.territory();
        List<String> p = Command("if (budget) then {move down invest 100}  else  {move up invest 100 }");
        Player.setPlan(p);
        Player.evaluatePlan();
    }

    @Test
    void opponentTest() throws SyntaxErrorException, Expr.SyntaxErrorException{
        List<Player> Player = setUpGame2();
        Player p1 = Player.get(0);
        Player p2 = Player.get(1);
    }

    @Test
    void infoTest() throws SyntaxErrorException, Expr.SyntaxErrorException{
        List<Player> Player = setUpGame2();
        Player p1 = Player.get(0);
        Player p2 = Player.get(1);
        Territory territory1 = p1.territory();
        p1.blink(territory1 ,0,0);
        p2.blink(territory1,row-1,0);

        List<String> p = Command("invest 1000");
        p2.setPlan(p);
        p2.evaluatePlan();
        p = Command("distance = nearby down");
        p1.setPlan(p);
        p1.evaluatePlan();
        double x = p2.getCityCrew().getRow();
        double y = p2.getCityCrew().getDeposit();
        if (p2.getBudget() >= 1000){
            assertEquals(p2,p2.territory().getRegion(row-1,0).getOwner());
            assertEquals(100*x+y,p1.variable.get("distance"));
        }else {
            assertNull(p2.territory().getRegion(row-1,0).getOwner());
            assertEquals(0,p1.variable.get("distance"));
        }




//        p = Command("distance = nearby downright");
//        p1.setPlan(p);
//        p1.evaluatePlan();
//        assertEquals(0,p1.variable.get("distance"));
    }

//    @Test
//    public void WhileWithExpTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
//        Player Player = setUpGame();
//        int MapRow = Player.territory().getTerritory_row() - 1;
//        int MapCol = 0;
//        Territory territory = Player.territory();
//        Player.blink(territory, 0, 0);
//        List<String> p = Command("while (budget) { j = j + 1 budget - 100 }");
//        Player.setPlan(p);
//        Player.evaluatePlan();
//        assertEquals(0,Player.getBudget());
//    }
}

