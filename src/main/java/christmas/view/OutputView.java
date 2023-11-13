package christmas.view;

public class OutputView {
    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    private enum Messsage {
        OUTPUT_MAIN("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        private final String message;

        Messsage(String message) {
            this.message = message;
        }
    }

    public void printMain() {
        System.out.println(Messsage.OUTPUT_MAIN.message);
    }
}
