import org.junit.Assert;
import org.junit.Test;
import solver.WordsProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class WordsProviderTest {
    @Test
    public void WordProviderGetsWords() {
        try {
            List<String> result = new WordsProvider().getWords();
            Assert.assertNotNull(result);
            Assert.assertNotEquals(result.size(), 0);


        } catch (IOException | URISyntaxException e) {
            Assert.fail();
        }
    }
}
