public class MyColor extends Tuple {

	public static final MyColor Black = new MyColor(0,0,0,0);
	public static final MyColor White = new MyColor(1.0,1.0,1.0);;

	public MyColor(double x, double y, double z, double w) {
		super(x, y, z, w);
	}
	
	public MyColor(double x, double y, double z) {
		super(x, y, z, 0);
	}

	public MyColor(MyColor v) {
		super(v);
	}
	
	public MyColor(Tuple mult) {
		super(mult);
	}

	public String toString() {
		return (t[0]+"  "+t[1]+"  "+t[2]);
	}
	
}

