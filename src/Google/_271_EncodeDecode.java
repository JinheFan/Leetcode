package Google;

import java.util.ArrayList;
import java.util.List;

public class _271_EncodeDecode {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s : strs) {
                sb.append(s.length()).append('/').append(s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ret = new ArrayList<String>();
            int i = 0;
            while(i < s.length()) {
                int slash = s.indexOf('/', i);   //after i, the index of '/'
                int size = Integer.valueOf(s.substring(i, slash));
                i = slash + size + 1;
                ret.add(s.substring(slash + 1, i));
            }
            return ret;
        }
}
