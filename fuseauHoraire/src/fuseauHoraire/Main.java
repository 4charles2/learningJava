package fuseauHoraire;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<String, String> maps = ZoneId.SHORT_IDS;
		long startTime = System.currentTimeMillis();
		maps.values().stream().forEach((x) -> {
			System.out.println(x + "--" + ZoneId.of(x).getRules());
		});
		System.out.println("Temps d'execution : " + (System.currentTimeMillis()-startTime));
		startTime = System.currentTimeMillis();
		maps.values().forEach((x) -> {
			System.out.println(x + "-----" + ZoneId.of(x).getRules());
		});
		System.out.println("Temps d'execution : " + (System.currentTimeMillis()-startTime));
		
		LocalDateTime ldt = LocalDateTime.now();
		
		List<ZoneId> lzi = Arrays.asList(
				ZoneId.of("Europe/Paris"),
				ZoneId.of("Asia/Tokyo"),
				ZoneId.of("America/Anchorage")
		);
		System.out.println(ldt);
		System.out.println(ZoneId.systemDefault());
		lzi.stream().forEach((x)-> {System.out.println(x + " :\t" + ldt.atZone(x).toInstant());});
	}
}
