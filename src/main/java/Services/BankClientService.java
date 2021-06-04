package Services;

import DAO.DBConnection;
import DAO.Interfaces.BankClientDAO;
import Entities.BankClient;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class BankClientService extends DBConnection implements BankClientDAO {
/*
    @Override
    public void addBankClient(BankClient client) {
        Connection conn = getConnection();

        try(PreparedStatement preparedStatement  = conn.prepareStatement("INSERT INTO CLIENTS (CLIENTNAME) VALUES (?)")) {

            preparedStatement.setString(1, client.getClientName());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<BankClient> getAllClients() {
        Connection conn = getConnection();
        List<BankClient> allClients = new ArrayList<>();
        String sql = "SELECT ID_CLIENT, CLIENTNAME FROM CLIENTS";
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                BankClient bankClient = new BankClient();
                bankClient.setClientID(resultSet.getLong("ID_CLIENT"));
                bankClient.setClientName(resultSet.getString("CLIENTNAME"));

                allClients.add(bankClient);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Statement close exception.");
                    e.printStackTrace();
                }
            }
        }

        return allClients;
    }

    @Override
    public BankClient getClientName(long clientId) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM CLIENTS WHERE ID_CLIENT=?";
        PreparedStatement preparedStatement = null;
        BankClient client = new BankClient();

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            client.setClientID(resultSet.getLong("ID_CLIENT"));
            client.setClientName(resultSet.getString("CLIENTNAME"));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return client;
    }

    @Override
    public void updateBankClient(BankClient client) {

    }*/
}
