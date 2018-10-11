import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림은 데이터 필터링,매핑,정령,그룹핑등의 '중간 처리'와 합계,평균,카운팅,최대값,최소값등의 '최종처리'를 파이프라인으로 해결함
 * 파이프라인은 여러개의 스트림이 연결되어 있는 구조를 말함, 파이프라인에서 최종처리를 제외하고는 모두 중간처리 스트림이다.
 *
 */
public class StreamTest {

    List<String> list = Arrays.asList("devseunga","lilly","anna");

    public void iteratorTest(){
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }

    public void stream(){
        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name) );
    }

    public void streamPipeline(){
        List<Member> list = Arrays.asList(new Member(29,"Female"),new Member(28,"Female"),new Member(30,"male"));
        Stream<Member> maleFemalStream = list.stream();
        Stream<Member> maleStream = maleFemalStream.filter(m -> m.getGender()=="male");
        IntStream intStream = maleStream.mapToInt(Member::getAge);
        OptionalDouble optionalDouble = intStream.average();
        Double ageAvg = optionalDouble.getAsDouble();

    }
}

