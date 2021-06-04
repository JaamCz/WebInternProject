package Entities;

import DAO.DBConnection;

import java.util.Objects;

public class BankClient {

    private long clientId;
    private String clientName;

    private DBConnection con = new DBConnection();

    public BankClient() {;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientID(long clientId){
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "{" +
                "ID: " + clientId +
                ", name:" + clientName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankClient that = (BankClient) o;
        return clientId == that.clientId && Objects.equals(clientName, that.clientName) && Objects.equals(con, that.con);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, con);
    }

}
