import java.util.Scanner;

public class Time2{
	private int hour;
	private int minute;
	private int second;
	
	public Time2(){
		this(0, 0, 0 );
	}
   
	public Time2(int h ){ 
		this(h, 0, 0);
	}
  
	public Time2(int h, int m){ 
		this( h, m, 0 );
	} 
   
	public Time2( int h, int m, int s ) { 
		setTime( h, m, s ); // invoke setTime to validate time
	} 

	public Time2( Time2 time ){
		this( time.getHour(), time.getMinute(), time.getSecond() );
	}

	public void setTime( int h, int m, int s ){
		setHour( h );
		setMinute( m );
		setSecond( s );
	}

	public void setHour( int h ){ 
		hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
	}

	public void setMinute( int m ){ 
		minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
	}

	public void setSecond( int s ){ 
		second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
	}

	public int getHour(){ 
		return hour; 
	}

   
	public int getMinute(){ 
		return minute; 
	} 

	public int getSecond(){ 
		return second; 
	}
   
	public void tick(){
		if (second ==59){
			if (minute ==59){
				incrementHour();
			}
			else {
				incrementMinute();
			}
		}
		else {
		second = second+1;
		}
	}
	public void incrementMinute(){
		this.second =0;
		this.minute += 1;
	}
	public void incrementHour(){
		this.second = 0;
		this.minute = 0;
		this.hour += 1;
	}
	public String toUniversalString(){
		return String.format( 
		"%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
	} 
   
	public String toString(){
		return String.format( "%d:%02d:%02d %s", 
			( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ),
			getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		Time2 time = new Time2(0,0,59);
		time.tick();
		System.out.println(time.hour + " " + time.minute + " " + time.second);
		Time2 time1 = new Time2(0,59,59);
		time1.tick();
		System.out.println(time1.hour + " " + time1.minute + " " + time1.second);
		Time2 time2 = new Time2(11,59,59);
		time2.tick();
		System.out.println(time2.hour + " " + time2.minute + " " + time.second);
   }
}