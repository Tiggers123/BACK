package Parser;

import java.util.*;
import java.util.regex.Pattern;
import Expr.*;
import Statement.*;

public class ConstructionPlanParser {
    private final Tokenizer line ;
    public ConstructionPlanParser(Tokenizer Lineinput){
        this.line = Lineinput ;
    }
    public Node parse() throws SyntaxErrorException {
        List<Statement> plan = new ArrayList<>();
        while (this.line.line.size() != line.pos){
            plan.add(Statement());
        }
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
            ActionCommand();
        }else if (matchIdentifier()) {
            line.consume();
            AssignmentStatement();
        }

    }
    public Statement AssignmentStatement() throws SyntaxErrorException {
        line.consume("=");
        Expression();
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

    }
    public Statement MoveCommand() throws SyntaxErrorException {
        Direction();
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
    }
    public Statement AttackCommand() throws SyntaxErrorException {
        if(line.peek("shoot")){
            line.consume("shoot");
            Direction();
            Expression();
        }else {
            throw new SyntaxErrorException("Invalid command");
        }
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
    }
    public IfStatement IfStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        line.consume("then");
        Statement();
        line.consume("else");
        Statement();
    }
    public WhileStatement WhileStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        Statement();
    }
    public Expression Expression() throws SyntaxErrorException {
        Term();
        if(line.peek("+")) {
            line.consume("+");
            Expression();
        }
        if(line.peek("-")){
            line.consume("-");
            Expression();
        }
    }
    public Expression Term () throws SyntaxErrorException {
        Factor();
        if(line.peek("*")){
            line.consume("*");
            Term ();
        }
        if(line.peek("/")){
            line.consume("/");
            Term ();
        }
        if(line.peek("%")){
            line.consume("%");
            Term ();
        }

    }
    public Expression Factor () throws SyntaxErrorException {
        Power();
        while (line.peek("^")) {
            line.consume("^");
            Factor();
        }
    }
    public Expression Power() throws SyntaxErrorException {

        if (isSpecialVariables(line.peek())){
            line.consume();
            System.out.println("It SpecialVariables it will do something here");
            return ;
        }else if (line.peek("nearby") || line.peek("opponent")){
            InfoExpression();
        }else if (line.peek("(")) {
            line.consume("(");
            Expression();
            line.consume(")");
        }else if (matchIdentifier()){
            Expression e = new Identifier(line.peek());
            line.consume();
            return e;
        }else if (matchNumber()) {
            Expression e = new DoubleLit(Double.parseDouble(line.peek()));
            line.consume();
            return e;
        }
        throw  new SyntaxErrorException("SyntexError");

    }
    public Expression InfoExpression() throws SyntaxErrorException {
        if (line.peek("nearby")) {
            line.consume("nearby");
            Direction();
        } else if(line.peek("opponent")){
            line.consume("opponent");
            System.out.println("Call opponent funtion");
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
