package Google;

class Couple {
    boolean isEnd;
    Couple[] children;

    public Couple() {
        children = new Couple[26];
        isEnd = false;
    }
}

class WordDictionary {
    public Couple root;
    public WordDictionary() {
        root = new Couple();
    }

    public void addWord(String str) {
        Couple curr = root;
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Couple();
            } 
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    // code needs to be recursive. because we have "..d"
    public boolean searchWord(String word) {
        return getWord(word, root);
    }

    private boolean getWord(String str, Couple node) {
        Couple curr = node;

        if(str.isEmpty()) return curr.isEnd;

        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(temp == '.') {
                for(Couple child: curr.children) {
                    if(child != null && getWord(str.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(curr.children[temp - 'a'] == null) return false;
                curr = curr.children[temp - 'a'];
            }
        }
        return curr.isEnd;
    }
}

public class Design_Add_And_Search_Words_Data_Structure {
    public static void main(String[] args) {
       WordDictionary wordDictionary = new WordDictionary();
       wordDictionary.addWord("baddy");
       wordDictionary.addWord("pad");
       wordDictionary.addWord("mad");
       System.out.println(wordDictionary.searchWord("pad"));
       System.out.println(wordDictionary.searchWord("..d"));
       System.out.println(wordDictionary.searchWord(".ad"));
       System.out.println(wordDictionary.searchWord("b.."));
    }
}
