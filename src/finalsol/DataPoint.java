package finalsol;

import java.awt.Point;


public class DataPoint extends Point{

	int G,H,F,index;
	public DataPoint() {
		super();
		x=0;
		y=0;
		G=0;
		H=0;
		F=0;
		index=0;
	}
	public DataPoint(int x, int y) {
		super();
		this.x=x;
		this.y=y;
		G=0;
		H=0;
		F=0;
		index=0;
	}
	
	
	
	public boolean equals(Object obj) {
		if (!(obj instanceof DataPoint))
			return false;
		if (obj == this)
			return true;

		DataPoint s = (DataPoint)obj;
		if(s.x==x && s.y==y) return true;
		else return false;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
}
