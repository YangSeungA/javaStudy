package util.socket.module.model;

import java.io.Serializable;

/**
 *
 * 세종 소켓 Header 객체 도메인 클래스
 *
 */
public class Header implements Serializable {
    private String communicationType ;	// 통신식별자
    private String textLength;			// 전문길이
    private String textNo;				// 전문번호
    private String reserveNo;			// 거래고유번호
    private String routCd;				// 라우팅
    private String retailNo;			// 판매처코드
    private String gzipYn;				// 압축여부
    private String option;				// 옵션필드
    private String responseCode;		// 응답코드
    private String fileYn;				// 파일송수신구분
    private String recodeSize;			// 레코드건수
    private String body ="";			// 다이나믹전문Request데이터

    public void setCommunicationType(String communicationType) {
        this.communicationType = isN(6, communicationType);
    }

    public void setTextLength(String textLength) {this.textLength = isX(6, textLength);}

    public void setTextNo(String textNo) {
        this.textNo = isN(4,textNo);
    }

    public void setReserveNo(String reserveNo) {
        this.reserveNo = isX(12,reserveNo);
    }

    public void setRoutCd(String routCd) {
        this.routCd = isX(30,routCd);
    }

    public void setRetailNo(String retailNo) {
        this.retailNo = isX(30,retailNo);
    }

    public void setGzipYn(String gzipYn) {
        this.gzipYn = isX(1,gzipYn);
    }

    public void setOption(String option) {
        this.option = isX(29,option);
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = isX(4,responseCode);
    }

    public void setFileYn(String fileYn) {
        this.fileYn = isX(1,fileYn);
    }

    public void setRecodeSize(String recodeSize) {
        this.recodeSize = isX(6,recodeSize);
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String isN(int length, String n) {
        String nn = "0000000"+n;
        return nn.substring(nn.length()-length,nn.length());
    }

    private String isX(int length, String n) {
        String nn ="";
        nn = n+"                                                                                        ";
        return nn.substring(0,length);
    }

    public byte[] getBytes() throws Exception {
        return toString().getBytes("KSC5601");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(communicationType)
                .append(this.textLength)
                .append(this.textNo)
                .append(this.reserveNo)
                .append(this.routCd)
                .append(this.retailNo)
                .append(this.gzipYn)
                .append(this.option)
                .append(this.responseCode)
                .append(this.fileYn)
                .append(this.recodeSize)
                .append(this.body);
        return sb.toString();
    }
}
