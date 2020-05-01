package HashMap;

import java.util.LinkedHashMap;

public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        System.out.println(map);
        map.get("1");
        System.out.println(map);
    }
}
//result :
// {1=1, 2=1, 3=1, 4=1}
//{2=1, 3=1, 4=1, 1=1}