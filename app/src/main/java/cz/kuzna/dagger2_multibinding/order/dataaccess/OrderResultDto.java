package cz.kuzna.dagger2_multibinding.order.dataaccess;

/**
 * @author Radek Kuznik
 */

public class OrderResultDto {

    private boolean status;
    private String msg;

    public boolean isStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}