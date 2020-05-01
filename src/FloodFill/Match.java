package FloodFill;

public class Match {
    private static int m;
    private static int n;
    public static boolean match(char[][] matrix, String word){
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(helper(matrix, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] matrix, int i, int j, String word, int index){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }
        if(index >= word.length()){
            return true;
        }
        if(matrix[i][j] == word.charAt(index)){
            char c = matrix[i][j];
            matrix[i][j] = '#';
            boolean res = helper(matrix, i + 1, j, word, index + 1) ||
                    helper(matrix, i - 1, j, word, index + 1) ||
                    helper(matrix, i, j + 1, word, index + 1) ||
                    helper(matrix, i, j - 1, word, index + 1);
            matrix[i][j] = c;
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        String word = "bef";
        System.out.println(match(matrix, word));
    }
}
