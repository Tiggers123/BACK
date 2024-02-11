package Parser;

import java.util.*;
import java.util.regex.Pattern;
import Expr.*;
import Statement.*;

import javax.swing.plaf.nimbus.State;

public class ConstructionPlanParser {
    private final Tokenizer line ;
    public ConstructionPlanParser(Tokenizer Lineinput){
        this.line = Lineinput ;
    }
    public List<Statement> parse() throws SyntaxErrorException {
        List<Statement> plan = new ArrayList<>();
        while (this.line.line.size() != line.pos){
            plan.add(Statement());
        }
        return  plan ;
    }
    public Statement Statement() throws SyntaxErrorException {
        if (line.peek("if")) {
            line.consume("if");
            return  IfStatement();
        } else if (line.peek("while")) {
            line.consume("while");
             return  WhileStatement();
        } else if (line.peek("{")) {
            return BlockStatement();
        } else {
            return Command();
        }
    }
    public Statement Command() throws SyntaxErrorException {
        if (line.peek().matches("\\b(?:done|relocate|move|invest|collect|shoot)\\b")){
            return ActionCommand();
        }else if (matchIdentifier()) {
            line.consume();
            return AssignmentStatement();
        }
        return null ;
    }
    public Statement AssignmentStatement() throws SyntaxErrorException {
        line.consume("=");
        Expression();
        return null ;
    }
    public Statement ActionCommand() throws SyntaxErrorException {
        if(line.peek("done")) {
            line.consume("done");
            System.out.println("Turn is end");
        }
        if(line.peek("relocate")){
            line.consume("relocate");
            System.out.println("Turn is end");
        }
        if (line.peek("move")){
            line.consume("move");
            MoveCommand();
        }
        if(line.peek("invest")){
            RegionCommand();}
        if(line.peek("collect")){
            RegionCommand();}
        if(line.peek("shoot")){
            AttackCommand();
        }
        return null ;

    }
    public Statement MoveCommand() throws SyntaxErrorException {
        Direction();
        return null ;
    }
    public Statement RegionCommand() throws SyntaxErrorException {
        if(line.peek("invest")){
            line.consume("invest");
            Expression();
        }
        if(line.peek("collect")){
            line.consume("collect");
            line.consume("(");
            Expression();
            line.consume(")");
        }
        return null ;
    }
    public Statement AttackCommand() throws SyntaxErrorException {
        if(line.peek("shoot")){
            line.consume("shoot");
            Direction();
            Expression();
        }else {
            throw new SyntaxErrorException("Invalid command");
        }
        return null ;
    }
    public String Direction() throws SyntaxErrorException {
        String[] validDirections = {"up", "down", "upleft", "upright", "downleft", "downright" };
        String token = line.peek();
        if (Arrays.asList(validDirections).contains(token)) {
            // need to fix
            line.consume();
            return token;
        } else {
            throw new RuntimeException("Invalid direction: " + token);
        }
    }
    public BlockStatement BlockStatement() throws SyntaxErrorException {
        line.consume("{");
        while (!line.peek().equals("}")) {
            Statement();
        }
        if (line.peek("}")){
            line.consume("}");
        }
        return null ;
    }
    public IfStatement IfStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        line.consume("then");
        Statement();
        line.consume("else");
        Statement();
        return null ;
    }
    public WhileStatement WhileStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        Statement();
        return null ;
    }
    public Expression Expression() throws SyntaxErrorException {
        Expression x = Term();
        if(line.peek("+")) {
            line.consume("+");
            return new BinaryArithExpr(x,"+",Expression());
        }
        if(line.peek("-")){
            line.consume("-");
            return new BinaryArithExpr(x,"-",Expression());
        }
        return  x ;
    }
    public Expression Term () throws SyntaxErrorException {
        Expression x = Factor();
        if(line.peek("*")){
            line.consume("*");
            x = new BinaryArithExpr(x, "*" , Term());
        }
        if(line.peek("/")){
            line.consume("/");
            x = new BinaryArithExpr(x, "/" , Term());
        }
        if(line.peek("%")){
            line.consume("%");
            x = new BinaryArithExpr(x, "%" , Term());
        }
        return  x  ;
    }
    public Expression Factor () throws SyntaxErrorException {
        Expression x = Power();
        if (line.peek("^")) {
            line.consume("^");
            return new BinaryArithExpr(x,"^",Factor());
        }
        return x ;
    }
    public Expression Power() throws SyntaxErrorException {
        Expression expr = null;
        if (isSpecialVariables(line.peek())){
            expr = new SpecialVaribles(line.peek());
            line.consume();
            return expr ;
        }else if (line.peek("nearby") || line.peek("opponent")){
            return InfoExpression();
        }else if (line.peek("(")) {
            line.consume("(");
            expr = Expression();
            line.consume(")");
        }else if (matchIdentifier()){
            expr = new Identifier(line.peek());
            line.consume();
            return expr;
        }else if (matchNumber()) {
            expr = new DoubleLit(Double.parseDouble(line.peek()));
            line.consume();
            return expr;
        }
        return expr ;

    }
    public Expression InfoExpression() throws SyntaxErrorException {
        if (line.peek("nearby")) {
            line.consume("nearby");
            return new Infonearby(line.peek());
        } else if(line.peek("opponent")){
            line.consume("opponent");
            return  new InfoOpponent();
        }else {
            throw new RuntimeException("Invalid InfoExpression");
        }
    }


    private boolean matchIdentifier() throws SyntaxErrorException {
        if (!isReservedWord(line.peek())){
            return Pattern.matches("[a-zA-Z][a-zA-Z0-9]*", line.peek());
        }else {
            return false ;
        }

    }

    private boolean matchNumber() {
        try {
            long number = Long.parseLong(line.peek());
            return number >= 0;
        } catch (NumberFormatException | SyntaxErrorException e) {
            return false;
        }

    }
    private boolean isReservedWord(String word) {
        List<String> reservedWords = Arrays.asList(
                "collect", "done", "down", "downleft", "downright", "else", "if", "invest",
                "move", "nearby", "opponent", "relocate", "shoot", "then", "up", "upleft",
                "upright", "while"
        );
        return  reservedWords.contains(word);
    }
    private boolean isSpecialVariables(String word){
        List<String> reservedWords = Arrays.asList(
                "rows", "cols","currow", "curcol",
                "budget", "deposit", "int" , "maxdeposit" ,"random"
        );
        return reservedWords.contains(word);
    }
    private boolean isInformationWord(String word){
        List<String> reservedWords = Arrays.asList(
                "opponent","nearby"
        );
        return reservedWords.contains(word);
    }




}
