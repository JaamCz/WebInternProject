package Entities;

import java.math.BigDecimal;


public class ClientAccount {

    private long accountId;
    private String accountNumber;
    private BigDecimal accBalance;
    private long clientId;



    public ClientAccount(){
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(BigDecimal accBalance) {
        this.accBalance = accBalance;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + accountId +"\"\n"+
                "        \"accountNumber\": \"" + accountNumber + "\"\n" +
                "        \"accountBalance\": \"" + accBalance +
                "\"}";
    }
}
