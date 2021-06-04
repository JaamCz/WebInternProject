package Services;

import Entities.ClientAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static DAO.DBConnection.DBInit;
import static org.junit.jupiter.api.Assertions.*;

class ClientsAccountServiceTest {
    @BeforeEach
    void startServer() {
        DBInit();
    }

    @Test
    void getBalanceValue() {
        BigDecimal dec = new ClientsAccountService().
                getBalanceValue("1324 1234 42456 0357");
        BigDecimal exp = new BigDecimal("300.00");
        BigDecimal notExp = new BigDecimal("10.00");
        assertEquals(dec, exp);
        assertNotEquals(dec,notExp);
    }

    @Test
    void accountBalanceReplenishment() {
        Map<String, String> map = new HashMap<>();
        map.put("accountNumber", "1324 1234 42456 0357");
        map.put("cash", "300.00");

        new ClientsAccountService().accountBalanceReplenishment(map);

        BigDecimal dec = new ClientsAccountService().
                getBalanceValue("1324 1234 42456 0357");
        BigDecimal exp = new BigDecimal("600.00");
        assertEquals(dec, exp);
    }

    @Test
    void getAccountBalance() {
        List<ClientAccount> list = new ClientsAccountService().
                getAccountBalance("1324 1234 42456 0357");
        list.get(0).getAccBalance();
        list.get(0).getAccountId();
        list.get(0).getAccountNumber();

        BigDecimal bigDecimal = new BigDecimal("300.00");

        assertEquals(list.get(0).getAccBalance(), bigDecimal);
        assertEquals(list.get(0).getAccountId(), 6L);
        assertEquals(list.get(0).getAccountNumber(), "1324 1234 42456 0357");
    }
}