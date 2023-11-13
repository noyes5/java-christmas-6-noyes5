package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.StringUtils;
import christmas.util.validator.ReservationValidator;

public class InputView {
    private enum Messsage {
        INPUT_RESERVATION("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        private final String message;

        Messsage(String message) {
            this.message = message;
        }
    }

    public int readReservation() {
        System.out.println(InputView.Messsage.INPUT_RESERVATION.message);
        String input = StringUtils.removeSpace(Console.readLine());
        new ReservationValidator().validate(input);
        return Integer.parseInt(input);
    }

}
