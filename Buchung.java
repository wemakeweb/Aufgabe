public class Buchung{
		public Datum start;
		public Datum end;
		public String gast;
		public int uid;
		
		Buchung(Datum start, Datum end, String gastname){
			this.start = start;
			this.end = end;	
			this.gast = gastname;
		}	
		
		public String toString(){
			return "Buchung: {  \n	" +
					"start: " + start + "\n	" +
					"end: " + end + "\n	" +
					"gast: " + gast + "\n" +
					"}";
		}
		
}