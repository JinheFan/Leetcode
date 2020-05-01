package Google;
/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * */
public class _844_BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private String getString(String str){
        int count = 0;
        String res = "";
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '#'){
                count++;
            }else if(count > 0){
                count--;
            }else{
                res += str.charAt(i);
            }
        }
        return res;
    }
}
