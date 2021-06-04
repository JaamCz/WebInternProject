package Services;

import DAO.DBConnection;
import DAO.Interfaces.ClientsAccountsDAO;
import Entities.ClientAccount;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientsAccountService extends DBConnection implements ClientsAccountsDAO {

    /*@Override
    public void createAccount(ClientAccount account) {
        Connection conn = getConnection();
        String sql = "INSERT INTO ACCNUMBERS (ACCNUM, CLIENT_ID, ACCBALANCE) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setLong(2, account.getClientId());
            preparedStatement.setBigDecimal(3, account.getAccBalance());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("PreparedStatement.close exception.");
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public BigDecimal getBalanceValue (String account) {
        Connection conn = getConnection();
        String sql = "SELECT ACCBALANCE FROM ACCNUMBERS WHERE ACCNUM = ?";
        PreparedStatement preparedStatement = null;
        BigDecimal balance = new BigDecimal("0");

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                balance = resultSet.getBigDecimal("ACCBALANCE");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("PreparedStatement.close exception.");
                    e.printStackTrace();
                }
            }
        }

        return balance;
    }

    @Override
    public void accountBalanceReplenishment(Map<String, String> map) {
        Connection conn = getConnection();
        String sql = "UPDATE ACCNUMBERS SET ACCBALANCE = ? WHERE ACCNUM = ?";
        PreparedStatement preparedStatement = null;

        BigDecimal cash = getBalanceValue(
                map.get("accountNumber")).add(
                        new BigDecimal(map.get("cash")));

        String accountNumber = map.get("accountNumber");
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setBigDecimal(1, cash);
            preparedStatement.setString(2, accountNumber);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("PreparedStatement.close exception.");
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<ClientAccount> getAccountBalance(String accountNum) {
        Connection conn = getConnection();
        String sql = "SELECT ID_ACCNUM, ACCBALANCE FROM ACCNUMBERS WHERE ACCNUM = ?";
        PreparedStatement preparedStatement = null;
        List<ClientAccount> accountList = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, accountNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ClientAccount acc = new ClientAccount();
                acc.setAccountNumber(accountNum);
                acc.setAccountId(resultSet.getLong("ID_ACCNUM"));
                acc.setAccBalance(resultSet.getBigDecimal("ACCBALANCE"));

                accountList.add(acc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("PreparedStatement.close exception.");
                    e.printStackTrace();
                }
            }
        }

        return accountList;
    }
}
