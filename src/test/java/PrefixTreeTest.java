import org.junit.Assert;
import org.junit.Test;
import solver.trie.PrefixTree;

public class PrefixTreeTest {
    @Test
    public void TestPrefixTreeInsertion() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("java");

        Assert.assertTrue(prefixTree.isWordExistsInTree("java"));
    }

    @Test
    public void TestPrefixTreeWordExistsWitNotFullWord() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("java");

        Assert.assertTrue(!prefixTree.isWordExistsInTree("jav"));
    }
}
