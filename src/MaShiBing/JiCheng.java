package MaShiBing;

class Animal {
    int num = 10;
    static int age = 20;
    public void eat() {
        System.out.println("动物吃饭");
    }

    public static void sleep() {
        System.out.println("动物在睡觉");
    }

    public void run(){
        System.out.println("动物在奔跑");
    }

}
class Cat extends Animal {
    int num = 80;
    static int age = 90;
    String name = "tomCat";
    public void eat() {
        System.out.println("猫吃饭");
    }
    public static void sleep() {
        System.out.println("猫在睡觉");
    }
    public void catchMouse() {
        System.out.println("猫在抓老鼠");
    }

}

public class JiCheng{
    public static void main(String[] args) {
        Animal am = new Cat();
        am.eat();
        am.sleep();
        am.run();
        Cat cat = new Cat();
        cat.catchMouse();
        System.out.println(cat.name);//这里先注释，待会说明
        System.out.println(am.num);
        System.out.println(am.age);

    }
}

