package util.socket.module.pool;

import java.io.IOException;

public class SejongSocketConnectionFactory {

 // static final Logger logger = LoggerFactory.getLogger(SejongSocketConnectionFactory.class);

  public SejongSocketConnection createConnection() {
    SejongSocketConnection connection = null;
    try {
      connection = new SejongSocketConnection();
    } catch (IOException e) {
      System.out.println("신규 커넥션 생성 오류 : {}"+ e.getMessage());
    }
    return connection;
  }
}
