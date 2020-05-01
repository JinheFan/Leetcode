package MaShiBing;

public class StringToDouble {

    private static String string = "1, 2;3, 4, 5;6, 7, 8";
    public static void main(String[] args) {
        double[][] res;
        String[] strs = string.split(";");
        res = new double[strs.length][];
        for(int i = 0; i < strs.length; i++){
            String[] s = strs[i].split(",");
            res[i] = new double[s.length];
            for(int j = 0; j < s.length; j++){
                res[i][j] = Double.parseDouble(s[j]);
            }
        }

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[i].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
