import java.util.ArrayList;

public class Aufgabe9 {
	public static void main(String[] args) {
		ArrayList<Bookable> facilities = new ArrayList<Bookable>(){{
			add( new Tagungsraum("GrŸne Linden", 90, "1 OG", "Schï¿½ner sonniger Raum mit Flipchart und Beamer") );
			add( new Tagungsraum("Bretagne", 150, "2 OG", "Rundum verglaster Raum mit Tafel ideal fŸr Meetings") );
			add( new Ferienwohnung("Haus Schlemmer", 45, 90,  "Am Hausberg 2",3, 3) );
		}};
		
		System.out.println(facilities);	
		
	}
}
