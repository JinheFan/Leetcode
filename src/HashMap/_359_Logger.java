package HashMap;

        import java.util.HashMap;

/**Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "bar" at timestamp 2
 logger.shouldPrintMessage(2,"bar"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "bar" at timestamp 8
 logger.shouldPrintMessage(8,"bar"); returns false;

 // logging string "foo" at timestamp 10
 logger.shouldPrintMessage(10,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class _359_Logger {

    HashMap<String, Integer> map;

    public _359_Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        if(!map.containsKey(message) || (timestamp - map.get(message) >= 10)){
            map.put(message, timestamp);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _359_Logger logger = new _359_Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(5, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
