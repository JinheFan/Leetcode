package Google;

import java.util.TreeSet;

/**
 * Example 1:
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 *
 * Input: "abcd"
 * Output: ["abcd"]
 * */
public class _1087_BraceExpansion {
    public String[] expand(String S) {
        if(S == null || S.length() <= 1){
            return new String[]{S};
        }
        TreeSet<String> set = new TreeSet<>();
        if(S.charAt(0) == '{'){
            int index = 0;
            while(S.charAt(index) != '}'){
                index++;
            }
            String sub = S.substring(1, index);
            String[] subs = sub.split(",");
            String[] strs = expand(S.substring(index + 1));
            for(int i = 0; i < subs.length; i++){
                for(int j = 0; j < strs.length; j++){
                    set.add(subs[i] + strs[j]);
                }
            }
        }else{
            String[] strs = expand(S.substring(1));
            for(int i = 0; i < strs.length; i++){
                set.add(S.charAt(0) + strs[i]);
            }
        }
        return set.toArray(new String[0]);
    }

}
