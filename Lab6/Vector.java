

public class Vector extends Tuple {

	public Vector(double x, double y, double z) {
		super(x,y,z,0);
	}

	public Vector(Tuple apply) {
		super(apply.t);
		t[3] = 0;
	}
}
