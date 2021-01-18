import java.util.*;
import java.util.stream.Stream;

public class Billing {

    public Map<Item, Integer> cartItems = new HashMap<>();
    public Map<Item, ItemWithOffer> offerItems = new HashMap<>();
    int total;

    int discountCalc(int quantity, int actualPrice, int discountOnQuantity, int discountPrice){
        int itemPrice;

        itemPrice = ( quantity / discountOnQuantity ) * discountPrice;
        itemPrice = itemPrice + ( ( quantity % discountOnQuantity ) * actualPrice);

        return itemPrice;
    }

    void addToTotal(int price){
        total += price;
    }

    int getPrice(Map<Item, Integer> cartItems){

        for(Map.Entry<Item,Integer> entry: cartItems.entrySet()){
            if(entry.getKey().getIsOfferExists()){
              int price = discountCalc(entry.getValue(),
                                    entry.getKey().getPrice(),
                                    offerItems.get(entry.getKey()).getQuantity(),
                                    offerItems.get(entry.getKey()).getOfferPrice()
                                );
              addToTotal(price);
            }
            else {
                addToTotal(entry.getKey().getPrice() * entry.getValue());
            }
        }

        return total;
    }

    void addToCart(Item cartItem) {
        if(cartItems.containsKey(cartItem)){
           int newQuantity = cartItems.get(cartItem) + 1;
           cartItems.put(cartItem, newQuantity);
        }
        else {
            cartItems.put(cartItem, 1);
        }
    }


    void removeFromCart(Item cartItem) {
        cartItems.remove(cartItem);
    }

    public static void main(String[] args) {
	// write your code here

    }
}
