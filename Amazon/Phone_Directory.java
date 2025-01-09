package Amazon;

import java.util.ArrayList;

class Nodes {
    Nodes[] children;
    boolean isEndOfWord;

    public Nodes() {
        this.children = new Nodes[26];
        this.isEndOfWord = false;
    }
}

public class Phone_Directory {
    public static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // creating Trie DS.
        Nodes root = new Nodes();
        for(String str : contact) {
            insertTrie(str.toCharArray(), root);
        }


        // searching in a Trie DS.
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(int i = 1; i <= s.length(); i++) {
            String tempString = s.substring(0, i);
            ArrayList<String> currMatches = new ArrayList<>();
            searchTrie(tempString.toCharArray(), new StringBuilder(), 0, root, currMatches);
            if(currMatches.size() == 0) currMatches.add("0");
            result.add(currMatches);
        }

        return result;
    }

    public static void searchTrie(char[] target, StringBuilder temp, int idx, Nodes root, ArrayList<String> bucket) {
        if(root == null) return;
        if(idx < target.length) {
            int charIdx = target[idx] - 'a';
            if(root.children[charIdx] == null) return;

            temp.append(target[idx]);
            searchTrie(target, temp, idx + 1, root.children[charIdx], bucket);
            temp.deleteCharAt(temp.length() - 1);
        } else {   
            if(root.isEndOfWord) bucket.add(temp.toString());
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null) {
                    temp.append((char)(i + 'a'));
                    searchTrie(target, temp, idx, root.children[i], bucket);
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }

    public static void insertTrie(char[] word, Nodes root) {
        Nodes currNode = root;

        for(int i = 0; i < word.length; i++) {
            int index = word[i] - 'a';
            if(currNode.children[index] == null) currNode.children[index] = new Nodes();
            currNode = currNode.children[index];
        }
        currNode.isEndOfWord = true;
    }

    public static void main(String[] args) {
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        displayContacts(contact.length, contact, s);
    }
}
