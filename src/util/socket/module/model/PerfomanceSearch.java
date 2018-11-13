package util.socket.module.model;

import util.socket.module.domain.PerfomanceVO;
import util.socket.module.pool.SocketHelper;

public class PerfomanceSearch extends SejongSocket{

    public PerfomanceSearch(String code){
        super(code);
    }

    @Override
    public String send(String data) throws Exception {
        PerfomanceVO search = new PerfomanceVO();
        search.setOpenYn("A");
        search.setAddField(000001);

        header.setBody("   A  eddddddddddddddd  ");
        return SocketHelper.sendDataStream(header.getBytes());
    }
}
