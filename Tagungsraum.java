
public class Tagungsraum implements Bookable{
	private String description = "";
	private String name;
	private double price;
	private String location;
	private Buchungsmap bookings = new Buchungsmap();
	
	Tagungsraum(String name, double price, String location, String desc){
		this.setName(name);
		this.setPrice(price);
		this.setLocation(location);
		this.setDescription(desc);
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
	
	
	public void setDescription(String desc){ 
		if( !desc.isEmpty()){
			this.description = desc;
		}
	}
	public String getDescription(){
		return this.description; 
	}
	
	private double calcPrice(int tage){
		return price * tage;
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
	
	public  void stornieren(int nr){
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
			
}
