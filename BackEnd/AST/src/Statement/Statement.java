package Statement;

import Expr.Node;
import java.util.*;

public interface Statement extends Node {
    void execute(Map<String, Long> bindings);
}
