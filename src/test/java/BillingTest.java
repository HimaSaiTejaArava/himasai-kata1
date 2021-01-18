import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class BillingTest {

    private Billing billing = new Billing();
    private Billing billing1 = new Billing();

    @Test
    void billingTest(){
        Item item = new Item("A", 50, true);
        Item item1 = new Item("B", 30, false);
        ItemWithOffer itemWithOffer = new ItemWithOffer(item, 130, 3);

        billing.addToCart(item);
        billing.addToCart(item1);
        billing.offerItems.put(item, itemWithOffer);

        billing1.addToCart(item);
        billing1.addToCart(item);
        billing1.addToCart(item);
        billing1.addToCart(item1);
        billing1.offerItems.put(item, itemWithOffer);

        Assertions.assertEquals(80, billing.getPrice(billing.cartItems));
        Assertions.assertEquals(160, billing1.getPrice(billing1.cartItems));
    }

}
