package hotel_california;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodoQuartoIndisponivel {
    public PeriodoQuartoIndisponivel(LocalDate dataCheckIn, LocalDate dataCheckOut) {
		
	}

	public static List<LocalDate> getPeriodoIndisponivel(LocalDate checkIn, LocalDate checkOut) {
        List<LocalDate> result = new ArrayList<>();
        while(checkIn.isBefore(checkOut)) {
            result.add(checkIn);
            checkIn = checkIn.plusDays(1);
        }
        result.add(checkOut);

        return result;
    }
}
