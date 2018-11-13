package util.socket.module.model;

import util.socket.module.pool.SocketHelper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class GenreSearch extends SejongSocket {

  public GenreSearch(String code) {
    super(code);
  }

  @Override
  public String send(String data) throws Exception {
    header.setBody(data);

  /*  StringBuilder sb = new StringBuilder();
    String sample = sb.append(header)
        .append(data)
        .toString();*/
    return SocketHelper.sendDataStream(header.getBytes());
  }
}
