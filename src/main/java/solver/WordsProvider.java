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

    public List<String> getWords() throws IOException, URISyntaxException {
        URI uri = getClass().getResource("../words.txt").toURI();
        return Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
    }
}
