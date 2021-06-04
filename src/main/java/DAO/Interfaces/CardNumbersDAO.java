package DAO.Interfaces;

import Entities.CardsNumber;

import java.util.List;

public interface CardNumbersDAO {
    // read all clients cards

    List<CardsNumber> getAllCards(long accountId);

    //create card

    void createCardForAccount(long accountId);

    //get card by number

    /*List<CardsNumber> getCardByNum(String cardNum);*/
}

