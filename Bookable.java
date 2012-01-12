public interface Bookable {
	void stornieren(int nr);
	double buchen(Datum Heute, Datum BuchungsDatum, int tage, String name);
}
