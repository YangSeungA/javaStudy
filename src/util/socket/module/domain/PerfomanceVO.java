package util.socket.module.domain;

import java.io.Serializable;

/**
 * 전문번호 9108
 * 프로그램 조회시 Request 도메인 객체
 */
public class PerfomanceVO implements Serializable {

    private String openYn;  //  " " 스페이스 : 현재 판매 가능 행사, "A" : 현재이후 등록된 모든 행사
    private int addField;   //  000001 : 오픈여부 추가로 받기

    public String getOpenYn() {
        return openYn;
    }

    public void setOpenYn(String openYn) {
        this.openYn = openYn;
    }

    public int getAddField() {
        return addField;
    }

    public void setAddField(int addField) {
        this.addField = addField;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(openYn)
            .append(addField);
        return sb.toString();
    }
}
