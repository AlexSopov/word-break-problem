package usage;

import solver.WordBreakProblemSolver;
import solver.WordsProvider;

import java.io.IOException;
import java.net.URISyntaxException;

public class Program {
    public static void main(String[] args) {
        try {
            WordsProvider wordsProvider = new WordsProvider();
            wordsProvider.getWords();

            MetrcisCollector metrcisCollector = new MetrcisCollector();

            metrcisCollector.Start();
            WordBreakProblemSolver wordBreakProblemSolver = new WordBreakProblemSolver(wordsProvider);
            System.out.println(wordBreakProblemSolver.getBreakedWordAtPosition(0));
            metrcisCollector.End();
            System.out.println(metrcisCollector.getMetricsString());

            metrcisCollector.Start();
            WordBreakProblemSolver wordBreakProblemSolver2 = new WordBreakProblemSolver(wordsProvider);
            System.out.println(wordBreakProblemSolver.getBreakedWordAtPosition(1));
            metrcisCollector.End();
            System.out.println(metrcisCollector.getMetricsString());



        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
