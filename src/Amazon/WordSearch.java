package Amazon;

import TrieTree.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void search(char[][] matrix, String[] strs) {
        TrieNode root = buildTrie(strs);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper(res, root, matrix, i, j);
            }
        }

        for(String string : res) {
            System.out.print(string + " ");
        }
    }

    private static TrieNode buildTrie(String[] strs) {
        TrieNode root = new TrieNode();
        for(String str : strs) {
            TrieNode cur = root;
            for(char c : str.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = str;
        }
        return root;
    }

    private static void helper(List<String> res, TrieNode cur, char[][] matrix, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        char c = matrix[i][j];
        if(c == '#' || cur.children[c - 'a'] == null) {
            return;
        }
        cur = cur.children[c - 'a'];
        if(cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        matrix[i][j] = '#';
        helper(res, cur, matrix, i + 1, j);
        helper(res, cur, matrix, i - 1, j);
        helper(res, cur, matrix, i, j + 1);
        helper(res, cur, matrix, i, j - 1);
        matrix[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] strings = new String[] {"oath", "pea", "eat", "rain"};
        search(matrix, strings);
    }
}
