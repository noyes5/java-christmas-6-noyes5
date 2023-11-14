package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Money;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    private Map<String, Integer> menuAndQuantities;

    @BeforeEach
    void setUp() {
        menuAndQuantities = new HashMap<>();
    }

    @DisplayName("주문 생성 테스트 - 정상 주문")
    @Test
    void 주문_생성_유효한_주문() {
        menuAndQuantities.put("양송이수프", 2);
        menuAndQuantities.put("타파스", 1);

        Orders orders = Orders.createOrder(menuAndQuantities);

        assertThat(orders.getOrderItems().size()).isEqualTo(2);
    }

    @DisplayName("주문 생성 테스트 - 음료만 주문")
    @Test
    void 주문_생성_음료만_주문() {
        menuAndQuantities.put("제로콜라", 1);
        menuAndQuantities.put("레드와인", 1);
        menuAndQuantities.put("샴페인", 1);

        assertThatThrownBy(() -> Orders.createOrder(menuAndQuantities))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 생성 테스트 - 주문 수량 초과")
    @Test
    void 주문_생성_주문_수량_초과() {
        menuAndQuantities.put("양송이수프", 15);
        menuAndQuantities.put("바비큐립", 3);
        menuAndQuantities.put("초코케이크", 3);

        assertThatThrownBy(() -> Orders.createOrder(menuAndQuantities))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문 금액 계산 테스트")
    @Test
    void 총_주문_금액_계산() {
        menuAndQuantities.put("양송이수프", 2);
        menuAndQuantities.put("타파스", 1);
        Orders orders = Orders.createOrder(menuAndQuantities);
        
        assertThat(orders.calculateTotalMoney()).isEqualTo(Money.of(17500));
    }
}