
public class SingletonTest {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance();     // getintance() 호출할때마다 인스턴스 생성되어 싱글톤이 아님!
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);           //true
        singleton1.setAaa(5);
        System.out.println(singleton2.getAaa());
    }
}