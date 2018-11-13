package util.socket.module.pool;

import util.socket.module.exception.BusyException;

import java.util.Vector;


/**
 *
 * 커넥션 Pool
 *
 */
public class SejongSocketConnectionPool {

  //static final Logger logger = LoggerFactory.getLogger(SejongSocketConnectionPool.class);

  private SejongSocketConnectionFactory connectionFactory;

  private Vector<SejongSocketConnection> connections = null;

  /**
   * 생성자
   * @param connectionFactory
   */
  public SejongSocketConnectionPool(SejongSocketConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  /**
   *
   * vactor 클래스로 SejongSocketConnection 생성
   */
  public void init() {
    connections = new Vector<SejongSocketConnection>();   //defualt 10개 생성

    for (int i = 0; i < Constant.MIN_SIZE; i++) {
      connections.addElement(connectionFactory.createConnection());  // 소켓 생성
    }
    System.out.println("초기화, 신규 커넥션 카운트 : " + connections.size());
  }

  /**
   *
   * 유효한 connection 객체 전달
   *
   * @return SejongSocketConnection result
   */
  public synchronized SejongSocketConnection getConnection() {

    SejongSocketConnection result = null;

    //traversal the pool to get free connections
    for (SejongSocketConnection connection : connections) {
      if (connection != null) {
        if (!connection.isBusy()) {
          result = connection;
          System.out.println("Conncted HashCode : {}"+ result.hashCode());
          break;
        }
      } else {
        connection = connectionFactory.createConnection();
        System.out.println("신규 커넥션을 추가");
        result = connection;
      }
    }
    if (result == null) {
      // max size보다 pool 이 작은경우 생성, 아닌경우 wait 또는 재시도

      if (connections.size() < Constant.MAX_SIZE) {
        // 커넥션 재시도
        SejongSocketConnection newConnection = connectionFactory.createConnection();
        connections.addElement(newConnection);
        System.out.println("빈 커넥션이 없으 신규 커넥션 생성");
        result = newConnection;
      } else {
        throw new BusyException("비어있는 커넥션이 존재하지 않습니다.");
      }
    }
    System.out.println("현재 커넥션 카운트 " + connections.size());
    result.setBusy(true);
    return result;
  }

  /*
  public void restart() {
    destroy();
    init();
  }
*/
  /*
  public void destroy() {
    for (SejongSocketConnection connection : connections) {
      if (connection != null) {
        connection.destroy();
        connection = null;
      }
    }
  }
*/
}
