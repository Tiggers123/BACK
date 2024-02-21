package Parser;

import Expr.ConstructionPlan;
import GameState.Player;
import GameState.Territory;

import java.util.ArrayList;
import java.util.List;
import Statement.Statement;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionPlanParserTest {
    private List<String> Command(String command){
        FileManager reader = new FileManager();
        List<String> file =  new ArrayList<>();
        file.add(command);
        return file;
    }
    public Player setUpGame() throws SyntaxErrorException {
        String[] p = {"Ton"};
        Territory map = new Territory(5, 5, 1100, 1000, 100, 100, 100, p);
        List<Player> p1 = map.getPlayer();
        Player p2= p1.get(0);
        return p2;
    }
    @Test
    void TopLeftConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        Territory territory = Player.territory();
        int row = territory.getTerritory_row();
        int col = territory.getTerritory_col();
        int longest = Math.max(row , col);
        int shortest = Math.min(row , col);
        double longestpow = Math.pow(longest,2);
        double c = Math.sqrt(longestpow+longestpow);
        c = Math.ceil(c);

        //Move Up
        Player.blink(territory , 0 , 0);
        List<String> p = Command("move up");
        Player.setPlan(p);
        for (int i = 0; i < row; i++) {
            assertEquals(territory.getRegion(0,0),Player.getCityCrew());
            Player.evaluatePlan();

        }
        //Move Upright
        Player.blink(territory , 0 , 0);
        p = Command("move upright");
        Player.setPlan(p);
        assertEquals(territory.getRegion(0,0),Player.getCityCrew());
        Player.evaluatePlan();
        for (int i = 0; i < c ; i++) {
            assertEquals(territory.getRegion(0,1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , 0 , 0);
        p = Command("move downright");
        Player.setPlan(p);
        int i = 0 ;
        for (int j = 0; j < c ; j++) {
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

        // Move downleft
        Player.blink(territory , 0 , 0);
        p = Command("move downleft");
        Player.setPlan(p);
        i = 0 ;
        for (int j = 0; j < c ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , 0 , 0);
        p = Command("move upleft");
        Player.setPlan(p);
        i = 0 ;
        for (int j = 0; j < c ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(0,0),Player.getCityCrew());
            Player.evaluatePlan();
        }
    }

    @Test
    void TopRightConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        Territory territory = Player.territory();
        int row = territory.getTerritory_row();
        int col = territory.getTerritory_col();
        int longest = Math.max(row , col);
        int shortest = Math.min(row , col);
        double longestpow = Math.pow(longest,2);
        double c = Math.sqrt(longestpow+longestpow);
        c = Math.ceil(c);

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
        for (int i = 0; i < c ; i++) {
            assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , 0 , col-1);
        p = Command("move downright");
        Player.setPlan(p);
        for (int i = 0; i < c ; i++) {
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

        //Move upleft
        Player.blink(territory , 0 , col-1);
        p = Command("move upleft");
        Player.setPlan(p);
        assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
        i = 0 ;
        for (int j =col-1 ; j > 0 ; j--) {
            if ((col-1) %2 == 0){
                    Player.evaluatePlan();
                    assertNotEquals(null,Player.getCityCrew());
                    assertEquals(territory.getRegion(0,col-2),Player.getCityCrew());
            }else {
                Player.evaluatePlan();
                assertNotEquals(null,Player.getCityCrew());
                assertEquals(territory.getRegion(0,col-1),Player.getCityCrew());
            }
        }
    }
    @Test
    void BottomRightConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException {
        Player Player = setUpGame();
        Territory territory = Player.territory();
        int row = territory.getTerritory_row();
        int col = territory.getTerritory_col();
        int longest = Math.max(row , col);
        int shortest = Math.min(row , col);
        double longestpow = Math.pow(longest,2);
        double c = Math.sqrt(longestpow+longestpow);
        c = Math.ceil(c);

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
        for (int i = 0; i < c ; i++) {
            assertEquals(territory.getRegion(row-1,col-1),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move downright
        Player.blink(territory , row-1 , col-1);
        p = Command("move downright");
        Player.setPlan(p);
        for (int i = 0; i < c ; i++) {
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
            if (j%2 == 0){
                assertNotEquals(null,Player.getCityCrew());
                assertEquals(territory.getRegion(i,col-1-temp),Player.getCityCrew());
            }else {
                assertNotEquals(null,Player.getCityCrew());
                assertEquals(territory.getRegion(i,col-1-temp),Player.getCityCrew());
                i--;
            }
            Player.evaluatePlan();
            temp++;

        }
    }
    @Test
    void BottomLeftConnerTest() throws SyntaxErrorException, Expr.SyntaxErrorException{
        Player Player = setUpGame();
        Territory territory = Player.territory();
        int row = territory.getTerritory_row();
        int col = territory.getTerritory_col();
        int longest = Math.max(row , col);
        int shortest = Math.min(row , col);
        double longestpow = Math.pow(longest,2);
        double c = Math.sqrt(longestpow+longestpow);
        c = Math.ceil(c);

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
            if (j%2 == 0){
                assertNotEquals(null,Player.getCityCrew());
                assertEquals(territory.getRegion(i, temp),Player.getCityCrew());
            }else {
                assertNotEquals(null,Player.getCityCrew());
                assertEquals(territory.getRegion(i, temp),Player.getCityCrew());
                i--;
            }
            Player.evaluatePlan();
            temp++;

        }

        //Move downright
        Player.blink(territory , row-1 , 0);
        p = Command("move downright");
        Player.setPlan(p);
        i = row-1 ;
        temp = 0;
        assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
        for (int j =col-1 ; j > 0  ; j--) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        // Move Down
        Player.blink(territory , row-1, 0);
        i = row-1 ;
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
        i = row-1 ;
        for (int j = col-1; j >= 0 ; j--){
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1,0),Player.getCityCrew());
            Player.evaluatePlan();
        }

        //Move upleft
        Player.blink(territory , row-1 , 0);
        p = Command("move upleft");
        Player.setPlan(p);
        i = 0 ;
        for (int j = 0; j < c ; j++) {
            assertNotEquals(null,Player.getCityCrew());
            assertEquals(territory.getRegion(row-1 , 0),Player.getCityCrew());
            Player.evaluatePlan();
        }
    }
    @Test
    void MiddleMapTest() throws SyntaxErrorException, Expr.SyntaxErrorException{
        Player Player = setUpGame();
        Territory territory = Player.territory();
        int row = territory.getTerritory_row();
        int col = territory.getTerritory_col();
        int longest = Math.max(row , col);
        int shortest = Math.min(row , col);
        double longestpow = Math.pow(longest,2);
        double c = Math.sqrt(longestpow+longestpow);
        c = Math.ceil(c);
        int i = 0 ;
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
        for (int j = midCol; j < c ; j++) {
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
        for (int j = midCol; j < c ; j++) {
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
        i = row-1 ;
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
}