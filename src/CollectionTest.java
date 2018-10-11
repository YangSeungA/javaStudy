import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionTest {

    public void collectionTest(){
        List<Member> m1 = Arrays.asList(new Member(30,"Female"),new Member(29,"male"));

        Collections.max(m1, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getGender().compareTo(o2.getGender());
            }
        });

        // --> 람다식으로 변경
        // 메소드에 사용할 데이터 혹은 변수와 행위를 같이 전달하게 하여 메소드의 행위 부분도 분리할 수 있을 것이다.
        // 이를 통해 얻을 수 있는 장점은 런타임에 행위를 전달받아 제어 흐름 수행함,메소드 단위의 추상화, 함수형 언어의 고차함수
        Collections.max(m1,(o1,o2) -> o1.getGender().compareTo(o2.getGender()));

    }

}

