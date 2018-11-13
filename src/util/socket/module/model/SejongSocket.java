package util.socket.module.model;

/**
 *
 * 세종 소켓
 *
 */
public abstract class SejongSocket {

  //소켓 header 객체
  protected  Header header;

  //생성자
  public SejongSocket(String code) {
    header = new Header();
    header.setCommunicationType("SAC!@#");
    header.setTextLength("133");
    header.setTextNo(code);
    header.setReserveNo("v9.9.9.9");
    header.setRoutCd("102103");
    header.setRetailNo("103065");
    header.setGzipYn("N");
    header.setOption("");
    header.setResponseCode("");
    header.setFileYn("");
    header.setRecodeSize("");
  }

  // 메세지를 전송한다.
  public abstract String send(String data) throws Exception;
}
