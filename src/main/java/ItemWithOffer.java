import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemWithOffer {

    private Item item;
    private Integer offerPrice;
    private Integer quantity;
}
