package christmas.domain.menu;

import christmas.domain.Money;
import christmas.dto.MenuItem;
import christmas.domain.exception.OrderException;
import christmas.domain.gift.Gift;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Orders {
    private static final int MAX_TOTAL_ORDER_COUNT = 20;

    private final List<MenuItem> orderItems;

    private Orders(List<MenuItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static Orders createOrder(Map<String, Integer> menuAndQuantities) {
        List<MenuItem> orderItems = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : menuAndQuantities.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            Menu menu = MenuRepository.from(menuName);
            orderItems.add(new MenuItem(menu, quantity));
        }
        validateOrder(orderItems);
        return new Orders(orderItems);
    }


    private static void validateOrder(List<MenuItem> orderItems) {
        if (isOnlyHasBeverage(orderItems)) {
            throw new IllegalArgumentException(OrderException.BEVERAGE_ONLY_ORDER_ERROR.getMessage());
        }
        if (isInvalidQuantity(orderItems)) {
            throw new IllegalArgumentException(OrderException.INVALID_TOTAL_QUANTITY.getMessage());
        }
    }

    private static boolean isOnlyHasBeverage(List<MenuItem> orderItems) {
        return orderItems.stream()
                .allMatch(orderItem -> orderItem.menu()
                        .getCategory() == Category.BEVERAGE);
    }

    private static boolean isInvalidQuantity(List<MenuItem> orderItems) {
        int totalQuantity = orderItems.stream()
                .map(MenuItem::quantity)
                .reduce(0, Integer::sum);
        return totalQuantity > MAX_TOTAL_ORDER_COUNT;
    }

    public List<MenuItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public Money calculateTotalMoney() {
        Money totalMoney = Money.ZERO;
        for (MenuItem item : orderItems) {
            Money itemPrice = Money.of(item.menu().getPrice() * item.quantity());
            totalMoney = totalMoney.add(itemPrice);
        }
        return totalMoney;
    }

    public Gift giveGift(Money totalMoney) {
        return new Gift(totalMoney);
    }

    public int getDessertItemCount() {
        int dessertItemCount = 0;
        for (MenuItem item : orderItems) {
            if (item.menu().getCategory() == Category.DESSERT) {
                dessertItemCount += item.quantity();
            }
        }
        return dessertItemCount;
    }

    public int getMainItemCount() {
        int mainItemCount = 0;
        for (MenuItem item : orderItems) {
            if (item.menu().getCategory() == Category.MAIN) {
                mainItemCount += item.quantity();
            }
        }
        return mainItemCount;
    }
}