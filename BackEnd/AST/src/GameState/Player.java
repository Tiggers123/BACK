package GameState;
import Parser.ConstructionPlanParser;
import Parser.SyntaxErrorException;
import Parser.Tokenizer;
import java.util.Map;
import Expr.ConstructionPlan;

public class Player {
    public String name;
    public boolean life;
    private Territory territory;
    private ConstructionPlan plan;
    public final Map<String, Double> variableSet;
    public Region cityCenter;
    public Region cityCrew;

    private long budget = 0;

    public Player(String name,Territory territory,ConstructionPlan plan, Map<String, Double> variableSet) {
        this.name = name;
        this.territory = territory;
        this.plan = plan;
        this.variableSet = variableSet;
    }
    public void setPlan(String plan){
        FileManager reader = new FileManager();
        ArrayList<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        List<String> u = new ArrayList<>();
        for (String inputString : file) {
            Tokenizer tokens1 = new Tokenizer(inputString);
            u.addAll(tokens1.line);
        }
        Tokenizer y = new Tokenizer();
        y.line= u;
//        System.out.println(u);
        ConstructionPlanParser x= new ConstructionPlanParser(y);
        x.parse();
    }
