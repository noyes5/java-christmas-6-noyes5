package christmas.view;

import static christmas.util.DateFormatter.formatResult;

import christmas.domain.Reservation;
import christmas.domain.dto.OrderItem;
import christmas.domain.menu.Orders;
import java.util.List;

public class OutputView {
    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printMain() {
        System.out.println(Messsage.WELCOME_MESSAGE.message);
    }

    public void printOrderMenu(Orders userOrders, Reservation reservation) {
        String formattedDate = formatResult(reservation.getDate());
        String eventMessage = String.format(Messsage.EVENT_PREVIEW_MESSAGE.message, formattedDate);
        System.out.println(eventMessage);
        System.out.println(Messsage.ORDER_MENU.message);

        List<OrderItem> orders = userOrders.getOrderItems();
        for (OrderItem item : orders) {
            System.out.printf("%s %s개\n", item.menu().getName(), item.quantity());
        }
    }

    private enum Messsage {
        WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
        EVENT_PREVIEW_MESSAGE("%s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
        ORDER_MENU("<주문 메뉴>"),
        ORIGINAL_TOTAL_PRICE("<할인 전 총주문 금액>"),
        DISCOUNT_TOTAL_PRICE("<할인 후 예상 결제 금액>"),
        DISCOUNTED_MENU("<증정 메뉴>"),
        DISCOUNT_DETAILS("<혜택 내역>"),
        TOTAL_DISCOUNT_AMOUNT("<총혜택 금액>"),
        NEXT_MONTH_EVENT_BADGE("<12월 이벤트 배지>");

        private final String message;

        Messsage(String message) {
            this.message = message;
        }
    }
}
