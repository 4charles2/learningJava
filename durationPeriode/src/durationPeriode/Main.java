package durationPeriode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37);
		
		LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS);
		LocalDateTime ldt3 = ldt.minusMinutes(1337);
		
		Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
		Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
		System.out.println("l'Intervale de date(Period) \t entre ldt : " + ldt + " est ldt2 : " + ldt2 + " est égale à : " + p);
		System.out.println("l'Intervale de second (Duration) entre ldt : " + ldt + " est ldt2 : " + ldt2 + " est égale à : " + d.getSeconds());
		System.out.println("Durée : " + d.getSeconds());
		System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt, ldt2));
		
	}

}
