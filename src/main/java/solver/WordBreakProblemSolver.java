package solver;

import solver.trie.PrefixTree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class WordBreakProblemSolver {
    private List<String> wordsForProblem;
    private WordsProvider wordsProvider;
    private PrefixTree trie;

    public WordBreakProblemSolver(WordsProvider wordsProvider) throws IOException, URISyntaxException {
        this.wordsProvider = wordsProvider;
        this.wordsForProblem = wordsProvider.getWords();

        trie = new PrefixTree();
        for (String word : wordsForProblem) {
            trie.insert(word);
        }
    }


    /**
     * @param position
     * Get longest breaked word if position is 0
     * If position is bigger than 0, get next by length (at posotion) breaked word
     * @return First word at required position.
     * @throws IOException
     * @throws URISyntaxException
     */
    public String getBreakedWordAtPosition(int position) throws IOException, URISyntaxException {
        List<String> sorterWords = wordsProvider.getWordsSortedByLengt();

        int currentPosition = 0;
        String lastBreakedWord = null, currentWord;

        for (int i = sorterWords.size() - 1; i >= 0; i--) {
            currentWord = sorterWords.get(i);

            if (lastBreakedWord != null && currentWord.length() < lastBreakedWord.length()) {
                currentPosition++;
            }

            if (currentWord.length() > 0 && isWordBreaked(currentWord, true)) {
                if (currentPosition == position) {
                    return currentWord;
                }

                lastBreakedWord = currentWord;
            }
        }

        return null;
    }


    private boolean isWordBreaked(String word, Boolean isEntireWord)
    {
        int wordLength = word.length();
        if (wordLength == 0) {
            return true;
        }

        for (int i=1; i <= wordLength; i++)
        {
            if (isEntireWord && i == wordLength) {
                return false;
            }

            if (trie.isWordExistsInTree(word.substring(0, i)) && isWordBreaked(word.substring(i, wordLength), false)) {
                return true;
            }
        }

        return false;
    }
}
