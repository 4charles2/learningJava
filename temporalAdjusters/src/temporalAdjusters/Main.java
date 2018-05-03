package temporalAdjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import show.Show;

public class Main {

	public static void main(String[] args) {
		Show.txt(LocalDateTime.now() + "   " + LocalDate.now());
		Show.txt("TemporalAdjusters va permettre d'ajuster la date en fonction d'éléments relatif comme avoir le prochain mardi\n"
				+ "Le premier samedi du mois");
		Show.txt("On va utiliser l'objet LocalDate pour cela");
		LocalDate ldt = LocalDate.now();
		
		LocalDate samediProchain = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		Show.txt("Date de samedi prochain " + samediProchain);
		LocalDate troisiemeMardi = LocalDate.of(ldt.getYear(),ldt.plusMonths(1).getMonth(), 1)
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
				.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		Show.txt("Date du troisieme mardi du mois prochain " + troisiemeMardi);
		
		Show.txt("Cette fois ci avec ma méthode ");
		Show.txt(ldt.plusMonths(1).with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.TUESDAY)));
	}

}
