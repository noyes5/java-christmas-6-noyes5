package christmas.domain.menu;

import christmas.domain.dto.OrderItem;
import christmas.domain.exception.OrderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Orders {
    private static final int MAX_QUANTITY = 20;

    private final List<OrderItem> orderItems;

    public Orders() {
        this.orderItems = new ArrayList<>();
    }

    public List<OrderItem> createOrder(Map<String, Integer> menuAndQuantities) {
        for (Map.Entry<String, Integer> entry : menuAndQuantities.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            Menu menu = MenuRepository.from(menuName);
            orderItems.add(new OrderItem(menu, quantity));
        }
        validateOrder();
        return orderItems;
    }


    private void validateOrder() {
        if (isOnlyHasBeverage()) {
            throw new IllegalArgumentException(OrderException.BEVERAGE_ONLY_ORDER_ERROR.getMessage());
        }
        if (isInvalidQuantity()) {
            throw new IllegalArgumentException(OrderException.INVALID_TOTAL_QUANTITY.getMessage());
        }
    }

    private boolean isOnlyHasBeverage() {
        return orderItems.stream()
                .allMatch(orderItem -> orderItem.menu()
                        .getCategory() == Category.BEVERAGE);
    }

    private boolean isInvalidQuantity() {
        int totalQuantity = orderItems.stream()
                .map(OrderItem::quantity)
                .reduce(0, Integer::sum);
        return totalQuantity > MAX_QUANTITY;
    }

}