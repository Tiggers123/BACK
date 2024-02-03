import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tokenizer {
    private static final Pattern pattern = Pattern.compile(
            "#[^\\n]*" + // Match comments
                    "|\\b(?:if|then|else|while|end|collect|invest|move|shoot|random|budget|deposit|opponent|nearby)\\b" + // Keywords
                    "|[-+]?\\d*\\.\\d+|\\d+" + // Numbers
                    "|[\\(\\)\\{\\}\\[\\];,]" + // Punctuation
                    "|=" + // Assignment operator
                    "|\\b(?:upleft|downleft|downright|upright|up|down|left|right|done)\\b" + // Directions
                    "|\\b(?:t|m|deposit|budget|opponentLoc|cost|dir)\\b" + // Variables
                    "|\\b(?:nearby)\\b" + // Nearby keyword
                    "|\\/\\/.*\\n" + // C++-style comments
                    "|\\/\\/.*$" // C++-style comments
    );

    // Tokenize method
    public static ArrayList<String> tokenize(String inputString) {
        ArrayList<String> tokens = new ArrayList<>();
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            tokens.add(matcher.group().trim());
        }
        return tokens;
    }
}
