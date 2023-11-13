package christmas.controller;

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
        initReservation();
    }

    private String initReservation() {
        try {
            return inputView.readReservation();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return initReservation();
        }
    }
}
