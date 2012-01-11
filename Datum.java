import java.util.Calendar;

public class Datum {	
	private int day;
	private int month;
	private int year;
	
	public Datum(){
		this.setDefault();
	}
	
	public Datum(int day, int month, int year){
		this.set(day, month, year);
	}
	
	public void set(int day, int month, int year) {
		if(!(month > 12 || month < 1 ||year < 2011 || day < 1 || day > Datum.getMaxTage(month, year))){
			this.day = day;
			this.month = month;
			this.year = year;
		} 
	}
	
	public void set(int longdate) {
		if(longdate > 0){		
			year =  longdate/10000;
			longdate = longdate%10000;
			
			month = longdate/100;
			day = longdate%100;
		} 
	}
	
	public Datum addDays(int days){
		int restDays = days,
			endDay = this.day,
			endMonth = this.month,
			endYear = this.year,
			maxDays = Datum.getMaxTage(this.month, this.year);
	        
	    if( (this.day + days) > maxDays ){
	        	
	    	while( restDays >= 0){
	        	maxDays = getMaxTage(endMonth, endYear);
	        		
	        	if( (endDay + days) > maxDays  ) {
	        		endMonth++;
	        			
	        	if(endMonth > 12){
	                endYear++;
	                endMonth = 1;
	            }
	        			
	            days = (endDay + days) - maxDays;                	
	            endDay = 0;
	                	
	        	} else {
	        		endDay = days;
	        		break;
	        	}
	        		 
	         }
	    } else {
	    	endDay = this.day + days;	    	
	    }
	    
	    return new Datum(endDay, endMonth, endYear);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getLong() {
		return year*10000 + month * 100 + day;
	}

	public Datum getNextDay() {
		int nextDay = this.day;
		int nextMonth = this.month;
		int nextYear = this.year;
		int maxDay = Datum.getMaxTage(this.month, this.year);
		
		if ((day + 1) > maxDay) {
	            nextDay = 1;

	            if ((month + 1) > 12) {
	                nextMonth = 1;
	                nextYear = year + 1;
	            } else {
	                nextMonth = month + 1;
	            }

	     } else {
	            nextDay = day + 1;
	     }
		
		return new Datum(nextDay, nextMonth, nextYear);
		
	}
	
	/* isInRangeOf
	 * @param d1 Date describes the start of the range
	 * @param d2 Date describes the end of the range
	 * @return boolean whether in or not in range
	 */	
	public boolean isInRangeOf(Datum d1 , Datum d2 ){		
		if(d1.getYear() <= this.year && this.year <= d2.getYear() ){
			if(d1.getMonth() <= this.month && this.month <= d2.getMonth() ){
				if(d1.getDay() <= this.day && this.day <= d2.getDay() ){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isEqual(Datum d1){
		if(d1.getYear() == this.year && d1.getMonth() == this.month && d1.getDay() == this.day){
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		return day + "." + month + "." + year;
	}
	
	
	public void setNull(){
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	
	private static boolean isSchaltjahr(int year) {
		return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
	}

	private static int getMaxTage(int month, int year) {
		 boolean isFeb = Datum.isFeb(month);
	     return (isFeb && Datum.isSchaltjahr(year) ) ? 29 : isFeb ? 28 : Datum.isLongMonth(month) ? 31 : 30;
	}
	
	private static boolean isLongMonth(int month){
		return ((month <= 7) && (month % 2 != 0)) || ((month > 7) && (month % 2 == 0));
	}
	
	private static boolean isFeb(int month){
		return (month == 2);
	}
	
	private void setDefault(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());

		day = cal.get(Calendar.DAY_OF_MONTH);
		month = (cal.get(Calendar.MONTH) + 1);
		year = cal.get(Calendar.YEAR);
	}

}