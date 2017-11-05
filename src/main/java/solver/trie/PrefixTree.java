package solver.trie;

public class PrefixTree {
    private PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }


    public void insert(String word) {
        PrefixTreeNode currentNode = root;

        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            int indexOfCharacter = c - 'a';

            if(currentNode.prefixTreeNodeData[indexOfCharacter] == null) {
                PrefixTreeNode newNode = new PrefixTreeNode();
                currentNode.prefixTreeNodeData[indexOfCharacter] = newNode;
                currentNode = newNode;
            }
            else {
                currentNode=currentNode.prefixTreeNodeData[indexOfCharacter];
            }
        }

        currentNode.isFullWord =true;
    }

    public boolean isWordExistsInTree(String word) {
        PrefixTreeNode currentNode = getNodeByWord(word);

        if(currentNode == null){
            return false;
        }
        else if (currentNode.isFullWord){
            return true;
        }

        return false;
    }


    private PrefixTreeNode getNodeByWord(String word) {
        PrefixTreeNode currentNode = root;

        for(int i=0; i < word.length(); i++){
            char characterAtIndex = word.charAt(i);
            int index = characterAtIndex - 'a';

            if(currentNode.prefixTreeNodeData[index] != null) {
                currentNode = currentNode.prefixTreeNodeData[index];
            }
            else{
                return null;
            }
        }

        if(currentNode==root) {
            return null;
        }

        return currentNode;
    }
}
