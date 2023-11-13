package christmas;

import christmas.controller.PromotionController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView= new OutputView();

        PromotionController promotionController = new PromotionController(inputView, outputView);
        promotionController.play();
    }
}
