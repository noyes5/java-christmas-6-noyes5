package christmas.controller;

import christmas.domain.Reservation;
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
        // 주문 메뉴 출력
        // 총 금액 계산
        // 총 혜택 계산
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
            Orders orders = new Orders();
            orders.createOrder(inputView.readOrders());
            return orders;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getOrderMenus();
        }
    }
}
