package solver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordsProvider {
    private List<String> words;

    public List<String> getWords() throws IOException, URISyntaxException {
        URI uri = getClass().getResource("../words.txt").toURI();
        words = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        return words;
    }

    public List<String> getWordsSortedByLengt() throws IOException, URISyntaxException {
        if (words == null) {
            words = getWords();
        }

        words.sort((o1, o2) -> o1.length() - o2.length());
        return words;
    }
}
