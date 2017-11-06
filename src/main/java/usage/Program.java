package usage;

import solver.WordBreakProblemSolver;
import solver.WordsProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        try {
            WordsProvider wordsProvider = new WordsProvider();
            wordsProvider.getWords();

            MetrcisCollector metrcisCollector = new MetrcisCollector();
            List<String> words = wordsProvider.getWords();

            metrcisCollector.start();
            WordBreakProblemSolver wordBreakProblemSolver = new WordBreakProblemSolver(words);
            System.out.println(wordBreakProblemSolver.getBreakedWordAtPosition(0));
            metrcisCollector.end();
            System.out.println(metrcisCollector.getMetricsString());

            words = wordsProvider.getWords();
            metrcisCollector.start();
            WordBreakProblemSolver wordBreakProblemSolver2 = new WordBreakProblemSolver(words);
            System.out.println(wordBreakProblemSolver2.getBreakedWordAtPosition(1));
            metrcisCollector.end();
            System.out.println(metrcisCollector.getMetricsString());



        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
