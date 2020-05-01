package Amazon;

public class _165_CompareVersionNumbers {
    /**
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     * Example 1:
     *
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     *
     * Example 2:
     *
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * */
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
