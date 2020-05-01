package MaShiBing;

enum Color{
    Red, Yellow, Blue
};
public class EnumTest {
    public static void main(String[] args) {
        Color color = Color.Red;
        switch (color){
            case Red:
                System.out.println("Red");
                break;
            case Blue:
                System.out.println("Blue");
                break;
            case Yellow:
                System.out.println("Yellow");
                break;
        }
    }
}
