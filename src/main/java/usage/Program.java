package usage;

import solver.WordBreakProblemSolver;
import solver.WordsProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        getPerfomance(0);
        getPerfomance(1);
    }

    private static void getPerfomance(int indexToSearch) {
        try {
            WordsProvider wordsProvider = new WordsProvider();
            wordsProvider.getWords();

            MetrcisCollector metrcisCollector = new MetrcisCollector();
            List<String> words = wordsProvider.getWords();

            metrcisCollector.start();
            WordBreakProblemSolver wordBreakProblemSolver = new WordBreakProblemSolver(words);
            System.out.println(wordBreakProblemSolver.getBreakedWordAtPosition(indexToSearch));
            metrcisCollector.end();
            System.out.println(metrcisCollector.getMetricsString());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
