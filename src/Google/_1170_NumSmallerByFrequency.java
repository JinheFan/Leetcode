package Google;
/**
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 * */
public class _1170_NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int index = 0;
        int[] queriesArray = new int[queries.length];
        for(String query : queries){
            int[] count = new int[26];
            for(Character c : query.toCharArray()){
                count[c - 'a']++;
            }

            for(int i = 0; i < 26; i++){
                if(count[i] != 0){
                    queriesArray[index++] = count[i];
                    break;
                }
            }
        }

        int wordsIndex = 0;
        int[] wordsArray = new int[words.length];
        for(String word : words){
            int[] count = new int[26];
            for(Character c : word.toCharArray()){
                count[c - 'a']++;
            }
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    wordsArray[wordsIndex++] = count[i];
                    break;
                }
            }
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queriesArray.length; i++){
            int count = 0;
            for(int j = 0; j < wordsArray.length; j++){
                if(queriesArray[i] < wordsArray[j]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
