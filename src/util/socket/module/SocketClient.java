package util.socket.module;

import util.socket.module.SejongFactory;
import util.socket.module.SejongFactory.TYPE;
import java.util.Date;
import java.util.Random;

/**
 *
 * 소켓 테스트
 *
 */
public class SocketClient {

  private static int loop =1;

  public static void main(String...args) throws Exception {
    //
    for(int i = 0 ; i < loop; i++) {
      Thread thread = new Thread(new ThreadTest());
      thread.start();
    }
  }
}

class ThreadTest implements Runnable {

  @Override
  public void run() {
    try {
      // 일반 검색
      Random random = new Random();
      Thread.sleep(random.nextInt(1000)+1);
      System.out.println(SejongFactory.create(TYPE.WATCH_GRADE).send("2018101020181201"));
      System.out.println(SejongFactory.create(TYPE.PERFOMANCE_SEARCH).send(""));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
