/**
 *  Singleton 패턴
 *  디자인 패던중 하나인 싱글톤은 단하나의 객체만 생성하게 강제하는 패턴이다. 즉 클래스를 통해 생성할 수 있는 객체는 '하나뿐',즉 한개만 되도록 만드는 것이 싱글톤이다
 *
 */
/*
class Singleton {
    private Singleton(){

    }
    Singleton singleton = new Singleton(); // 생성자 키워드가 private 되어있어 내부 클래스에서만 접근가능
}

public class SingletonTest {
    public static void main(String[] args){
        Singleton singleton = new Singleton(); // 생성자 키워드가 private 되어있어 외부접근 불가능(컴파일에러남)
    }
}
*/
class Singleton {
    private static Singleton one;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(one == null){
            one = new Singleton();
        }
        return one;
    }

    private int aaa ;
    private int bbb ;


    public int getAaa() {
        return aaa;
    }

    public void setAaa(int aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }
}
