import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String itemName;
    private Integer price;
    private Boolean isOfferExists;
}
