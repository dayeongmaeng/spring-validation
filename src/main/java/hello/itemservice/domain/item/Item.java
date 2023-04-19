package hello.itemservice.domain.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
/*@ScriptAssert( //이 검증까지 가는 건 무리. 제약이 많고 복잡함, 오브젝트 오류는 자바 코드로 처리하는 것을 권장
    lang = "javascript",
    script = "_this.price * _this.quantity >= 10000",
    message = "총합이 10,000원 넘게 입력해주세요.")*/
public class Item {

    @NotNull //수정 요구사항 추가
    private Long id;
    @NotBlank(message = "공백X")
    private String itemName;
    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    @NotNull
//    @Max(9999) //수정 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
