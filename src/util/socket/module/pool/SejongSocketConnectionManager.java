package util.socket.module.pool;


/**
 *
 *
 * 소켓 케넥션 메니저
 *
 *
 */
public class SejongSocketConnectionManager {

  //static final Logger logger = LoggerFactory.getLogger(SejongSocketConnectionManager.class);

  private SejongSocketConnectionPool socketConnectionPool;

  private SejongSocketConnectionManager() {
    if (socketConnectionPool == null) {
      SejongSocketConnectionPoolFactory socketConnectionPoolFactory = new SejongSocketConnectionPoolFactory();
      socketConnectionPool = socketConnectionPoolFactory.createConnectionPool();
      System.out.println("커넥션 생성됨");
    }
  }

  public static SejongSocketConnectionManager getInstance() {
    return SocketConnectionManagerSingletonHolder.instance;
  }

  public synchronized SejongSocketConnectionPool getSocketConnectionPool() {
    return socketConnectionPool;
  }

  private static class SocketConnectionManagerSingletonHolder {
    private static SejongSocketConnectionManager instance = new SejongSocketConnectionManager();
  }
}
