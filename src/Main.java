import socketExam.SejeongSocketCilent;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 *
 */
public class Main {

    public static void main(String[] args) {
       System.out.println("Hello World!");

        StreamTest streamTest = new StreamTest();
        streamTest.iteratorTest();
        streamTest.stream();

        //객체 stream
        List<TicketVo> list = Arrays.asList(new TicketVo(1,"나얼 콘서트"),new TicketVo(2,"박효신 콘서트"));
        Stream<TicketVo> stream = list.stream();

        stream.forEach(s -> {

            int no = s.getTicketNo();
            String name = s.getName();

            System.out.println(name + "-" + no);
        });


    }
}
