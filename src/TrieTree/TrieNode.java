package TrieTree;

public class TrieNode {

    public TrieNode[] children;
    public boolean isWord;
    public String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        this.word = "";
    }
}
