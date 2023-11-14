package christmas.domain.menu;

import christmas.domain.Money;
import christmas.domain.dto.OrderItem;
import christmas.domain.exception.OrderException;
import christmas.domain.gift.Gift;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Orders {
    private static final int MAX_TOTAL_ORDER_COUNT = 20;

    private final List<OrderItem> orderItems;

    private Orders(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static Orders createOrder(Map<String, Integer> menuAndQuantities) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : menuAndQuantities.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            Menu menu = MenuRepository.from(menuName);
            orderItems.add(new OrderItem(menu, quantity));
        }
        validateOrder(orderItems);
        return new Orders(orderItems);
    }


    private static void validateOrder(List<OrderItem> orderItems) {
        if (isOnlyHasBeverage(orderItems)) {
            throw new IllegalArgumentException(OrderException.BEVERAGE_ONLY_ORDER_ERROR.getMessage());
        }
        if (isInvalidQuantity(orderItems)) {
            throw new IllegalArgumentException(OrderException.INVALID_TOTAL_QUANTITY.getMessage());
        }
    }

    private static boolean isOnlyHasBeverage(List<OrderItem> orderItems) {
        return orderItems.stream()
                .allMatch(orderItem -> orderItem.menu()
                        .getCategory() == Category.BEVERAGE);
    }

    private static boolean isInvalidQuantity(List<OrderItem> orderItems) {
        int totalQuantity = orderItems.stream()
                .map(OrderItem::quantity)
                .reduce(0, Integer::sum);
        return totalQuantity > MAX_TOTAL_ORDER_COUNT;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public Money calculateTotalMoney() {
        Money totalMoney = new Money(BigDecimal.ZERO);
        for (OrderItem item : orderItems) {
            Money itemPrice = new Money(new BigDecimal(item.menu().getPrice() * item.quantity()));
            totalMoney = totalMoney.add(itemPrice);
        }
        return totalMoney;
    }

    public Gift giveGift(Money totalMoney) {
        return new Gift(totalMoney);
    }

    public int getDessertItemCount() {
        int dessertItemCount = 0;
        for (OrderItem item : orderItems) {
            if (item.menu().getCategory() == Category.DESSERT) {
                dessertItemCount += item.quantity();
            }
        }
        return dessertItemCount;
    }

    public int getMainItemCount() {
        int mainItemCount = 0;
        for (OrderItem item : orderItems) {
            if (item.menu().getCategory() == Category.MAIN) {
                mainItemCount += item.quantity();
            }
        }
        return mainItemCount;
    }
}