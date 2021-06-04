package Entities;

import java.util.Objects;

public class CardsNumber {

    private long cardId;
    private String cardNumber;

    public CardsNumber (){
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardId(long ID_card) {
        this.cardId = ID_card;
    }

    public long getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsNumber that = (CardsNumber) o;
        return cardId == that.cardId && Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNumber);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + cardId +"\"\n"+
                "        \"cardNumber\": \"" + cardNumber + "\"}";
    }
}
