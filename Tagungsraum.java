
public class Tagungsraum extends bookableFacility{
	String description = "";
	
	Tagungsraum(String name, double price, String location, String desc){
		super(name, price, location);
		this.setDescription(desc);
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
}
