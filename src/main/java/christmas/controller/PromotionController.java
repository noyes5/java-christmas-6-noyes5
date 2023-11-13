package christmas.controller;

import christmas.domain.Reservation;
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
        getOrderMenus();
    }

    private int getReservation() {
        try {
            return inputView.readReservation();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getReservation();
        }
    }

    private String getOrderMenus() {
        try {
            return inputView.readOrderMenus();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return getOrderMenus();
        }
    }
}
