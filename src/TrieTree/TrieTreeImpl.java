package TrieTree;

public class TrieTreeImpl {

    TrieNode root;
    public TrieTreeImpl(){
        this.root = new TrieNode();
    }

    public void buildTree(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean contains(String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startWith(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public boolean search(String word){
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode cur, int index){
        if(index >= word.length()){
            return cur.isWord;
        }
        if(word.charAt(index) == '.'){
            for(TrieNode temp : cur.children){
                if(temp != null && search(word, temp, index + 1)){
                    return true;
                }
            }
            return false;
        }else{
            TrieNode temp = cur.children[word.charAt(index) - 'a'];
            return temp != null && search(word, temp, index + 1);
        }
    }

    public static void main(String[] args) {
        TrieTreeImpl TrieTree = new TrieTreeImpl();
        TrieTree.buildTree("abcd");
        System.out.println(TrieTree.contains("abcd"));
        System.out.println(TrieTree.startWith("ab"));
        System.out.println(TrieTree.search("ab.d"));
    }
}
