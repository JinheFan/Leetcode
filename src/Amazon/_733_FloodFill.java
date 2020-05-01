package Amazon;
/**
 *
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * */
public class _733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        int row = image.length;
        int col = image[0].length;
        dfs(image, sr, sc, newColor, image[sr][sc], row, col);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor,  int color, int row, int col){         //要改和初始值一样的元素
        if(sr < 0 || sr >= row || sc < 0 || sc >= col ||  image[sr][sc] != color){
            return;
        }

        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, color, row, col);
        dfs(image, sr - 1, sc, newColor, color, row, col);
        dfs(image, sr, sc + 1, newColor, color, row, col);
        dfs(image, sr, sc - 1, newColor, color, row, col);
    }
}
