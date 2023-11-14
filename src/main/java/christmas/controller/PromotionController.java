package christmas.controller;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.gift.Gift;
import christmas.domain.menu.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printMain();
        Reservation reservation = Reservation.of(getReservation());
        Orders userOrders = getOrderMenus();
        outputView.printOrderMenu(userOrders, reservation);
        Money totalMoney = userOrders.calculateTotalMoney();
        outputView.printOriginalTotalMoney(totalMoney);
        Gift gift = userOrders.giveGift(totalMoney);
        printResult(gift);
    }

    private void printResult(Gift gift) {
        outputView.printGiftResult(gift);
    }

    private int getReservation() {
        try {
            return inputView.readReservation();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getReservation();
        }
    }

    private Orders getOrderMenus() {
        try {
            return Orders.createOrder(inputView.readOrders());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getOrderMenus();
        }
    }
}
