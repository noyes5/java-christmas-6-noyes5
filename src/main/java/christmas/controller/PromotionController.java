package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.DiscountPolicy;
import christmas.domain.Money;
import christmas.domain.Promotion;
import christmas.domain.Reservation;
import christmas.domain.discount.DiscountCondition;
import christmas.domain.dto.OrderInfo;
import christmas.domain.gift.Gift;
import christmas.domain.menu.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printMain();
        OrderInfo orderInfo = getOrderInfo();
        printOrderInfo(orderInfo);
        printPromotionResults(orderInfo);
    }

    private OrderInfo getOrderInfo() {
        Reservation reservation = Reservation.of(getReservation());
        Orders userOrders = getOrderMenus();
        return new OrderInfo(reservation, userOrders);
    }

    private void printOrderInfo(OrderInfo orderInfo) {
        outputView.printOrderMenu(orderInfo.orders(), orderInfo.reservation());
    }

    private void printPromotionResults(OrderInfo orderInfo) {
        Orders userOrders = orderInfo.orders();
        Reservation reservation = orderInfo.reservation();
        Money totalMoney = userOrders.calculateTotalMoney();
        Gift gift = userOrders.giveGift(totalMoney);
        outputView.printOriginalTotalMoney(totalMoney);
        outputView.printGiftResult(gift);
        applyDiscountsAndDisplay(userOrders, reservation, totalMoney);
    }

    private void applyDiscountsAndDisplay(Orders userOrders, Reservation reservation, Money totalMoney) {
        printDisplayDiscounts(reservation, userOrders, totalMoney);
        calculatePromotionAndBadge(reservation, userOrders, totalMoney);
    }

    private void printDisplayDiscounts(Reservation reservation, Orders userOrders, Money totalMoney) {
        Promotion promotion = createPromotion(reservation, userOrders, totalMoney);
        Map<DiscountCondition, Money> discountConditions = promotion.getCollectDiscounts();
        outputView.printDiscount(discountConditions);
    }

    private void calculatePromotionAndBadge(Reservation reservation, Orders userOrders, Money totalMoney) {
        Promotion promotion = createPromotion(reservation, userOrders, totalMoney);
        Money benefitPromoMoney = promotion.calculateBenefitAmount();
        Money discountAmount = promotion.calculateDiscountAmount();
        outputView.printDiscountResult(totalMoney, benefitPromoMoney, discountAmount);
        outputView.printBadge(Badge.getBadgeByMoney(benefitPromoMoney));
    }

    private Promotion createPromotion(Reservation reservation, Orders userOrders, Money totalMoney) {
        DiscountPolicy discountPolicy = new DiscountPolicy(totalMoney);
        return new Promotion(discountPolicy, reservation, userOrders);
    }

    private int getReservation() {
        while (true) {
            try {
                return inputView.readReservation();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private Orders getOrderMenus() {
        while (true) {
            try {
                return Orders.createOrder(inputView.readOrders());
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}
