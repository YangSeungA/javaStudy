public class TicketVo {

    private int ticketNo;
    private String name;

    public TicketVo(int ticketNo,String name){
        this.ticketNo = ticketNo;
        this.name = name;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
