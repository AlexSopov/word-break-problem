import org.junit.Assert;
import org.junit.Test;
import solver.WordBreakProblemSolver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class WordBreakProblemSolverTest {
    @Test
    public void WordBreakProblemTestIsWordBreaked() {
        List<String> data = new ArrayList<>();
        data.add("java");
        data.add("jav");
        data.add("a");

        try {
            WordBreakProblemSolver wordBreakProblemSolver = new WordBreakProblemSolver(data);

            Assert.assertTrue(wordBreakProblemSolver.isWordBreaked("java", true));
            Assert.assertTrue(!wordBreakProblemSolver.isWordBreaked("jav", true));
            Assert.assertTrue(!wordBreakProblemSolver.isWordBreaked("a", true));

        } catch (IOException | URISyntaxException e) {
            Assert.fail();
        }
    }

    @Test
    public void WordBreakProblemTestGetPositions() {
        List<String> data = new ArrayList<>();
        data.add("java");
        data.add("jav");
        data.add("a");
        data.add("javajava");

        try {
            WordBreakProblemSolver wordBreakProblemSolver = new WordBreakProblemSolver(data);

            Assert.assertEquals(wordBreakProblemSolver.getBreakedWordAtPosition(0), "javajava");
            Assert.assertEquals(wordBreakProblemSolver.getBreakedWordAtPosition(1), "java");
            Assert.assertNull(wordBreakProblemSolver.getBreakedWordAtPosition(2));

        } catch (IOException | URISyntaxException e) {
            Assert.fail();
        }
    }
}
