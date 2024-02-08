package Statement;

import Node.java;
import java.util.*;

public interface Statement extends Node {
    void execute(Map<String, Long> bindings);
}
