

public class Point extends Tuple {

	public Point(double x, double y, double z) {
		super(x,y,z,1);
	}

	public Point(Tuple add) {
		super(add.t[0],add.t[1],add.t[2],1);
	}
	
	
}
