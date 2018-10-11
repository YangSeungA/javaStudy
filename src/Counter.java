/**
 * static
 *
 * 항상 값이 변하지 않는 경우라면 static 를 사용하여 메모리의 이점을 얻을수 있음
 * 만약 staic 변수값에 변경하지 않게하려면 final 키워드를 한번 설정해주면 된다(변경하려고 하면 예외가 발생함)
 * 스태틱메소드 안에서는 인스턴스변수 접근이 불가능하다. Counter.getCount 를 사용하려면 getCount 가 static 함수여야 한다.
 */
public class Counter {
    static int count = 0;

    Counter() {
        this.count++;       // 2
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        System.out.println(Counter.getCount());
    }

}