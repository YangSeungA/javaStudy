package util.socket.module.pool;



public class SejongSocketConnectionPoolFactory {

  //static final Logger logger = LoggerFactory.getLogger(SejongSocketConnectionPoolFactory.class);

  public SejongSocketConnectionPool createConnectionPool() {

    SejongSocketConnectionPool socketConnectionPool = new SejongSocketConnectionPool(new SejongSocketConnectionFactory());

    socketConnectionPool.init();

    return socketConnectionPool;
  }
}




