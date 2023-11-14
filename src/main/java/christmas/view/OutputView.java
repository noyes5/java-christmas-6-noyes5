package christmas.view;

import static christmas.domain.Constants.DECEMBER;
import static christmas.util.ResultFormatter.dateFormat;
import static christmas.util.ResultFormatter.discountFormat;
import static christmas.util.ResultFormatter.discountMoneyFormat;
import static christmas.util.ResultFormatter.menuFormat;
import static christmas.util.ResultFormatter.moneyFormat;

import christmas.domain.Badge;
import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.discount.DiscountCondition;
import christmas.domain.dto.MenuItem;
import christmas.domain.dto.OrderInfo;
import christmas.domain.gift.Gift;
import christmas.domain.menu.Orders;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String NO_BENEFIT = "없음";

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printMain() {
        System.out.println(String.format(Message.WELCOME_MESSAGE.message, DECEMBER));
    }

    public void printOrderMenu(Orders userOrders, Reservation reservation) {
        String formattedDate = dateFormat(reservation.getDate());
        String eventMessage = String.format(Message.EVENT_PREVIEW_MESSAGE.message, formattedDate);
        System.out.println(eventMessage);
        System.out.println(Message.ORDER_MENU.message);

        List<MenuItem> orders = userOrders.getOrderItems();
        for (MenuItem item : orders) {
            System.out.printf(menuFormat(item.menu().getName(), item.quantity()) + LINE_SEPARATOR);
        }
    }

    public void printOrderInfo(OrderInfo orderInfo) {
        Reservation reservation = orderInfo.reservation();
        Orders userOrders = orderInfo.orders();

        displayEventPreviewHeader(reservation);
        printOrderMenu(userOrders);
    }

    private static void printOrderMenu(Orders userOrders) {
        System.out.println(Message.ORDER_MENU.message);
        List<MenuItem> orders = userOrders.getOrderItems();
        for (MenuItem item : orders) {
            System.out.printf(menuFormat(item.menu().getName(), item.quantity()) + LINE_SEPARATOR);
        }
    }

    private static void displayEventPreviewHeader(Reservation reservation) {
        String formattedDate = dateFormat(reservation.getDate());
        String eventMessage = String.format(Message.EVENT_PREVIEW_MESSAGE.message, formattedDate);
        System.out.println(eventMessage);
    }

    public void printOriginalTotalMoney(Money totalMoney) {
        System.out.println(Message.ORIGINAL_TOTAL_PRICE.message);
        String money = moneyFormat(totalMoney.getAmount());
        System.out.println(money);
    }

    public void printGiftResult(Gift gift) {
        System.out.println(Message.GIFT_MENU.message);
        StringBuilder result = new StringBuilder();
        List<MenuItem> gifts = gift.getGifts();
        appendGifts(result, gifts);
        System.out.println(result);
    }

    private void appendGifts(StringBuilder result, List<MenuItem> gifts) {
        if (gifts.isEmpty()) {
            result.append(NO_BENEFIT);
        }

        gifts.forEach(giftMenu -> {
            String giftMenuName = giftMenu.menu().getName();
            int quantity = giftMenu.quantity();
            result.append(menuFormat(giftMenuName, quantity));
        });
    }

    public void printDiscount(Map<DiscountCondition, Money> discountConditions) {
        System.out.println(Message.DISCOUNT_DETAILS.message);
        if (discountConditions.isEmpty()) {
            System.out.println(NO_BENEFIT);
        }
        for (DiscountCondition condition : discountConditions.keySet()) {
            discountConditions.get(condition);
            System.out.println(discountFormat(condition.getPromotionType().getMessage(),
                    discountConditions.get(condition).getAmount()));
        }
    }

    public void printDiscountResult(Money totalMoney, Money BenefitPromoMoney, Money discountAmount) {
        BigDecimal result = BenefitPromoMoney.getAmount();
        System.out.println(Message.TOTAL_DISCOUNT_AMOUNT.message);
        System.out.println(discountMoneyFormat(result));

        System.out.println(Message.DISCOUNT_TOTAL_PRICE.message);
        System.out.println(moneyFormat(totalMoney.subtract(discountAmount).getAmount()));
    }

    public void printBadge(Badge badgeByMoney) {
        System.out.println(String.format(Message.NEXT_MONTH_EVENT_BADGE.message, DECEMBER));
        System.out.println(badgeByMoney.toString());
    }


    private enum Message {
        WELCOME_MESSAGE("안녕하세요! 우테코 식당 %s월 이벤트 플래너입니다."),
        EVENT_PREVIEW_MESSAGE("%s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
        ORDER_MENU(LINE_SEPARATOR + "<주문 메뉴>"),
        ORIGINAL_TOTAL_PRICE(LINE_SEPARATOR + "<할인 전 총주문 금액>"),
        GIFT_MENU(LINE_SEPARATOR + "<증정 메뉴>"),
        DISCOUNT_DETAILS(LINE_SEPARATOR + "<혜택 내역>"),
        DISCOUNT_TOTAL_PRICE(LINE_SEPARATOR + "<할인 후 예상 결제 금액>"),
        TOTAL_DISCOUNT_AMOUNT(LINE_SEPARATOR + "<총혜택 금액>"),
        NEXT_MONTH_EVENT_BADGE(LINE_SEPARATOR + "<%s월 이벤트 배지>");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
