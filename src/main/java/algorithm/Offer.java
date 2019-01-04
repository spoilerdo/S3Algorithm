package algorithm;

public class Offer {
    private int offerId;
    private int itemId;
    private int senderId;
    private float price;

    public Offer(int offerId, int itemId, int senderId, float price) {
        this.offerId = offerId;
        this.itemId = itemId;
        this.senderId = senderId;
        this.price = price;
    }

    public int getOfferId() {
        return offerId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getSenderId() {
        return senderId;
    }

    public float getPrice() {
        return price;
    }

    public boolean checkInt(String leftInt, String rightInt){
        return Integer.parseInt(leftInt) <= Integer.parseInt(rightInt);
    }

    public boolean checkDouble(String leftDouble, String rightDouble){
        return Float.parseFloat(leftDouble) <= Float.parseFloat(rightDouble);
    }
}
