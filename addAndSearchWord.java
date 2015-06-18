class TrieNode {
    public int num;
    public boolean isEnd;
    public char val;
    public TrieNode[] son;
    
    public TrieNode() {
        num = 1;
        son = new TrieNode[26];
        isEnd = false;
    }
}

public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null|| word.length()==0)
            return;
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for(int i = 0, len = word.length(); i < len; i++) {
            int pos = letters[i]-'a';
            if(node.son[pos]==null){
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } else{
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word==null||word.length()==0)
            return false;
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        
        if(k == chs.length)
            return node.isEnd;
        if(chs[k]!='.') {
            return node.son[chs[k] - 'a'] !=null && match(chs, k+1, node.son[chs[k] - 'a']);
        } else {
            for(int i = 0; i < node.son.length; i++) {
                if(node.son[i]!=null) {
                    if(match(chs, k+1, node.son[i]))
                        return true;
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");