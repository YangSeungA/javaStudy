package util.socket.module.pool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * 세종 소켓 커넥션
 *
 */
public class SejongSocketConnection {

  //static final Logger logger = LoggerFactory.getLogger(SejongSocketConnection.class);

  private Socket socket;

  private DataInputStream in;
  private DataOutputStream out;

  private boolean busy = false;

  public SejongSocketConnection() throws IOException {
    this.socket = new Socket(Constant.DEFAULT_HOST, Constant.DEFAULT_PORT);
    this.socket.setSoTimeout(5000);
    this.in = new DataInputStream(socket.getInputStream());
    this.out = new DataOutputStream(socket.getOutputStream());
  }

  public boolean isBusy() {
    return busy;
  }

  public void setBusy(boolean busy) {
    this.busy = busy;
  }

  public void sendData(byte[] data) throws IOException {
    if (this.socket == null || this.socket.isClosed()) {
      this.socket = new Socket(Constant.DEFAULT_HOST, Constant.DEFAULT_PORT);
      this.socket.setSoTimeout(5000);
      this.in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
    }
    out.write(data);
    out.flush();
  }

  public String receiveData() throws IOException {
    String result = null;

    byte[] bytes = new byte[Constant.DEFAULT_BUFFER];
    int len = in.read(bytes);
    System.out.println(len);
    result = new String(bytes, 0, len, "KSC5601");
    return result;
  }

  public void destroy() {
    if (this.in != null) {
      try {
        this.in.close();
      } catch (IOException e) {
        System.out.println("inputstream 종료 오류 : {}"+ e.getMessage());
      }
    }
    if (this.out != null) {
      try{
        this.out.close();
      } catch (IOException e) {
        System.out.println("outputstream 종료 Error : {}"+ e.getMessage());
      }

    }
    if (this.socket != null) {
      try {
        this.socket.close();
      } catch (IOException e) {
        System.out.println("socket 종료 Error : {}"+ e.getMessage());
      }
    }
    this.busy = false;
    this.out = null;
    this.in = null;
    this.socket = null;
  }
}
