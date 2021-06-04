package DAO.Interfaces;

import Entities.ClientAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ClientsAccountsDAO {
    //create account
    /*void createAccount (ClientAccount account);
*/
    //update client account
    BigDecimal getBalanceValue (String account);

    //deposit money on account Balance
    void accountBalanceReplenishment(Map<String, String> map);

    // get account balance
    List<ClientAccount> getAccountBalance(String accountNum);

}
