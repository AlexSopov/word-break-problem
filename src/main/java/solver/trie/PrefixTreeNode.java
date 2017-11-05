package solver.trie;

public class PrefixTreeNode {

    /**
     * Stores array of PrefixTreeNode
     * In current case, it can store 26 nodes
     * One node - one character
     */
    PrefixTreeNode[] prefixTreeNodeData;
    boolean isFullWord;


    public PrefixTreeNode() {
        this.prefixTreeNodeData = new PrefixTreeNode[26];
    }

}

