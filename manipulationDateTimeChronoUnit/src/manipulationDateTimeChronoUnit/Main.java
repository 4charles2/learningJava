package manipulationDateTimeChronoUnit;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;

import show.Show;

public class Main {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 22, 13, 37, 0);
		Show.txt("LocalDateTime.now() : \t" + LocalDateTime.now());
		
		Show.txt("Instant.now() : \t" + Instant.now());
		System.out.println("Date de référence : " + ldt);
		
		System.out.println("1 semaine de plus " + ldt.plusWeeks(1));
		//Même modification 
		System.out.println("1 semaine de plus : " + ldt.plus(1, ChronoUnit.WEEKS));
		
		Show.txt("Me façon 2 mois de plus " + ldt.plusMonths(2));
		Show.txt("learning façon 2 mois de plus " + ldt.plus(2, ChronoUnit.MONTHS));
		String text[] = {"Me façon ", "learning façon ", " de plus "};
		Show.txt(ldt.minusMinutes(43));
		
		Consumer<String> learning = (str) -> System.out.println(str);
		
		learning.accept(text[0] + 2 + Month.class + text[2] + ldt.plusMonths(2));
		
	}
}
