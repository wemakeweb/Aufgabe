import java.util.ArrayList;
import java.util.Vector;


public class Aufgabe8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Zentrale
		
		ArrayList<bookableFacility> facilities = new ArrayList<bookableFacility>(){{
			add( new Tagungsraum("Grüne Linden", 90, "1 OG", "Schöner sonniger Raum mit Flipchart und Beamer") );
			add( new Tagungsraum("Bretagne", 150, "2 OG", "Rundum verglaster Raum mit Tafel ideal für Meetings") );
			add( new Ferienwohnung("Haus Schlemmer", 45, 90,  "Am Hausberg 2",3, 3) );
		}};
		
		System.out.println(facilities);	

	}

}
