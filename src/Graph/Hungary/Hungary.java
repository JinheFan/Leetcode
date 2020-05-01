package Graph.Hungary;

        import java.util.Arrays;

public class Hungary {
    static int[] person;
    static int[] place;
    public static void hungary(int[][] matrix){
        person = new int[4];
        place = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(place, -1);
        boolean[] visited;
        int res = 0;
        for(int i = 0; i < person.length; i++){
            visited = new boolean[place.length];
            if(helper(matrix, i, visited)){
                res++;
            }
        }
        System.out.println(Arrays.toString(person));
        System.out.println(Arrays.toString(place));
        System.out.println(res);
    }

    public static boolean helper(int[][] matrix, int start, boolean[] visited){
        for(int end = 0; end < place.length; end++){
            if(matrix[start][end + 4] == 0 || visited[end]){
                continue;
            }
            visited[end] = true;
            if(place[end] == -1 || helper(matrix, place[end], visited)){
                person[start] = end;
                place[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };
        hungary(matrix);
    }

}
