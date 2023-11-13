package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Reservation;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ReservationTest {
    @DisplayName("기간 확인 테스트 - 크리스마스 기간")
    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    void 크리스마스_기간_확인(int day) {
        LocalDate christmas = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(christmas);
        assertThat(reservation.hasInChristmasPeriods()).isTrue();
    }

    @DisplayName("기간 확인 테스트 - 비크리스마스 기간")
    @ParameterizedTest
    @ValueSource(ints = {26, 31})
    void 비크리스마스_기간_확인(int day) {
        LocalDate nonChristmas = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(nonChristmas);
        assertThat(reservation.hasInChristmasPeriods()).isFalse();
    }
}
