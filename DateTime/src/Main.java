import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

	public static void main(String[] args) {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Date et heure courante : " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("Date courante : " + date1);
		
		Month mois = currentTime.getMonth();
		int jour = currentTime.getDayOfMonth();
		int heure = currentTime.getHour();
		
		System.out.println("Le mois " + mois + " Le jour du mois : " + jour + "L'heure : " + heure);
		
		//Cr�er une date pour le 25 d�cembre
		LocalDateTime myDate = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
		
		System.out.println("Date cr�er : " + myDate);
		
		//AUtre technique de cr�ation de date
		LocalDate createDate = LocalDate.of(1986, Month.DECEMBER, 22);
		System.out.println("Ma date anniversaire : " + createDate);
		
		//Parser une date depuis une string
		LocalTime parsed = LocalTime.parse("20:15:30");
		System.out.println("Date pars�e : " + parsed);
	}

}
