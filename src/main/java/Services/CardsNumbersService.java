package Services;

import DAO.DBConnection;
import DAO.Interfaces.CardNumbersDAO;
import Entities.CardsNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardsNumbersService extends DBConnection implements CardNumbersDAO {

    @Override
    public List<CardsNumber> getAllCards(long accountId) {
        Connection conn = getConnection();
        String sql = "SELECT ID_CARDNUM, CARDNUM FROM CARDNUMBERS WHERE ACCNUM_ID = ?";
        PreparedStatement preparedStatement = null;
        List<CardsNumber> cardsNumbers= new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                CardsNumber cardNumber = new CardsNumber();
                cardNumber.setCardId(resultSet.getLong("ID_CARDNUM"));
                cardNumber.setCardNumber(resultSet.getString("CARDNUM"));

                cardsNumbers.add(cardNumber);
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
        return cardsNumbers;
    }

    @Override
    public void createCardForAccount(long accountId) {
        Connection conn = getConnection();
        String sql = "INSERT INTO CARDNUMBERS (CARDNUM, ACCNUM_ID) VALUES (?,?)";
        PreparedStatement preparedStatement = null;
        int randNum = 1000 + (int)(Math.random()*8000);
        String cardNum = "1243 1234 2342 " + String.valueOf(randNum);
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cardNum);
            preparedStatement.setLong(2, accountId);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
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

   /* @Override
    public List<CardsNumber> getCardByNum(String cardNum) {
        Connection conn = getConnection();
        String sql = "SELECT ID_CARDNUM, CARDNUM FROM CARDNUMBERS WHERE CARDNUM = ?";
        PreparedStatement preparedStatement = null;
        List<CardsNumber> cardsNumbers= new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cardNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                CardsNumber cardNumber = new CardsNumber();
                cardNumber.setCardId(resultSet.getLong("ID_CARDNUM"));
                cardNumber.setCardNumber(resultSet.getString("CARDNUM"));

                cardsNumbers.add(cardNumber);
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
        return cardsNumbers;
    }*/
}
