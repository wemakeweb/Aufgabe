public class Ferienwohnung implements Bookable {
	private int bettenzahl;
	private int sterne;
	private double mengengrundrabatt;
	private double steuern = 1.07;
	private String name;
	private double price;
	private String location;
	private Buchungsmap bookings = new Buchungsmap();

	
	Ferienwohnung (String name, double basispreis, int bettenzahl,String adresse, int sterne, double mengengrundrabatt ){

		this.setName(name);
		this.setPrice(price);
		this.setLocation(location);
		this.setBettenzahl(bettenzahl);
		this.setSterne(sterne);
		this.setMengengrundrabatt(mengengrundrabatt);

	}
	
	Ferienwohnung(){
		this.setName("leer");
		this.setPrice(0);
		this.setLocation("leer");
		this.setBettenzahl(1);
		this.setSterne(0);
		this.setMengengrundrabatt(0);

	}

	
	public void setName(String name){ 
		if( !name.isEmpty()){
			this.name = name;
		}
	}
	public String getName(){
		return name; 
	}
	
	public void setPrice(double price){ 
		if(price > -1){
			this.price = price;
		}
	}
	public double getPrice(){
		return this.price; 
	}
	

	public void setLocation(String location){
		if(!location.isEmpty()){
			this.location =location;
		}
	}
	
	public String getLocation(){
		return location; 
	}
	
	private double calcPrice(int tage){
		return 0.0;
		//has to be implemented
	}
	
	
	public double buchen(Datum Heute, Datum BuchungsDatum, int tage, String name){		
		if(tage < 1 ||
				Heute.getYear() < BuchungsDatum.getYear() || 
				Heute.getYear() == BuchungsDatum.getYear() && Heute.getMonth() == BuchungsDatum.getMonth() && Heute.getDay() == BuchungsDatum.getDay()){
			return 0;
		} else {
			if(this.isVerfŸgbar(BuchungsDatum, tage, name)){
				return this.calcPrice(tage);
			} else {
				return 0;
			}
			
		}		
	}
	
	public void stornieren(int nr){
		try{
			this.bookings.storniere(nr);
		} catch(Exception e){
			System.out.println("Buchung nicht stornierbar");
		}
		
	}

	
	private boolean isVerfŸgbar(Datum BuchungsDatum, int naechte, String name){	
		try{
			return this.bookings.buche(BuchungsDatum, BuchungsDatum.addDays(naechte), name);
		} catch (Exception e){
			return false;
		}
	}
	
	public void setBettenzahl(int bettenzahl){ 
		if(bettenzahl > 0){
			this.bettenzahl = bettenzahl;
		}
	}
	public int getBettenzahl(){
		return bettenzahl; 
	}
	
	
	public void setSterne(int sterne){
		if( sterne >= -1){
			this.sterne = sterne;
		}
	}
	
	public int getSterne(){
		return sterne; 
	}
	
	public void setMengengrundrabatt(double mengengrundrabatt){
		if( mengengrundrabatt > 0){
			this.mengengrundrabatt = mengengrundrabatt;
		}
	}	
	
	public double getMengengrundrabatt(){
		return mengengrundrabatt; 
	}
	
	public void setSteuern(double steuern){
		if( steuern > 0 && steuern < 101){
			this.steuern = steuern;
		} 
	}
	
	public double getSteuern(){
		return steuern; 
	}
	
	private static double netto(double preis, int naechte) {
		double netto = naechte * preis;
		return netto;
	}

	private static double brutto(double netto, double steuern) {
		double brutto = netto * steuern;
		return brutto;
	}

	private static int runden(double zahl) {
		return (int) zahl;
	}
	
	public double calcPreis(int naechte){
		if(naechte == 1){
			return price;
		} else {
			return _rabatt(price, price, naechte, 1 );
		}
	}	
	
	private double _rabatt (double preis, double endpreis, int naechte, int teiler){
			endpreis += preis;
			endpreis *= (100 - (double) (mengengrundrabatt/teiler))/100;			
			naechte--;
			teiler++;
					
		if(naechte > 1){
			return _rabatt(preis, endpreis, naechte, teiler);
		} else {
			return endpreis;
		}
				
	}
	
	public String toString(){
		return "Ferienwohnung: {  \n	" +
				"name: " + name  + "\n	" +
				"basispreis: " + price + "\n	" +
				"bettenanzahl: " + bettenzahl + "\n	" +
				"adresse: " + location + "\n	" +
				"sterne: " + sterne + "\n	" +
				"mengengrundrabatt: " + mengengrundrabatt + "\n	" +
				"steuern: " + steuern + "\n	" +
			"}";
	}




}