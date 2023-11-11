package christmas.domain;

import java.time.LocalDate;

public class Reservation {
    private LocalDate reservationDate;

    public Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getDate() {
        return reservationDate;
    }

    public boolean hasInChristmasPeriods() {
        int month = reservationDate.getMonthValue();
        int day = reservationDate.getDayOfMonth();
        return month == 12 && day >= 1 && day <= 25;
    }
}
