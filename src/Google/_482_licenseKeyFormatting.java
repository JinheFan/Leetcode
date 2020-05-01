package Google;
/**
 * Input: S = "5F3Z-2e-9-w", K = 4
 *
 * Output: "5F3Z-2E9W"
 *
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 *  each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character.
 * */
public class _482_licenseKeyFormatting{
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
