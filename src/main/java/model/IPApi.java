package model;

public class IPApi {

    private String ip;
    public IPApi(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return ip;
    }
}
