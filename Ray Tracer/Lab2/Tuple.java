

public class Tuple implements Cloneable{
	
	public double [] t = new double[4];
	
	public Tuple(double x, double y, double z, double w) {
		
		t = new double[] {x,y,z,w};
		
	}
	
	public String toString() {
		return "[ "+t[0]+" "+t[1]+" "+t[2]+" "+t[3]+" ]";
	}
	
	public Tuple(double[] a) {
		for (int i=0; i<4; i++)
			t[i] = a[i];
	}
	
	public Tuple(Tuple v) {
		t[0] = v.t[0];
		t[1] = v.t[1];
		t[2] = v.t[2];
		t[3] = v.t[3];
		
	}
	
	public double[] getT() {return t;}
	
	public static Tuple add(Tuple one, Tuple two) {
		return new Tuple(one.t[0]+two.t[0], one.t[1]+two.t[1], one.t[2]+two.t[2], one.t[3]+two.t[3]);
		
		}
	
	public static Tuple sub(Tuple one, Tuple two) {
		return new Tuple(one.t[0]-two.t[0], one.t[1]-two.t[1], one.t[2]-two.t[2], one.t[3]-two.t[3]);
		
		}
	
	public <E extends Tuple> E negate() {
		E a = this.dup();
		a.t[0] = -this.t[0];
		a.t[1] = -this.t[1];
		a.t[2] = -this.t[2];
		a.t[3] = -this.t[3];
		
		return a;
		
		}
	
	public <E extends Tuple> E scale(double s) {
		E a = dup();
		a.t[0] = t[0]*s;
		a.t[1] = t[1]*s;
		a.t[2] = t[2]*s;
		a.t[3] = t[3]*s;
		
		return a;
	}
	
	public double magnitude() {
		return 
				Math.sqrt(t[0]*t[0]+t[1]*t[1]+t[2]*t[2]+t[3]*t[3]);
	}
	
	public <X extends Tuple> X normalize() {
		X copy = this.dup();
		copy.t[0] = this.t[0];
		copy.t[1] = this.t[1];
		copy.t[2] = this.t[2];
		copy.t[3] = this.t[3];
		copy = copy.scale(1.0/copy.magnitude());
		return copy;
	}
	
	public static double dot(Tuple one, Tuple two) {
		return one.t[0]*two.t[0]+one.t[1]*two.t[1]+one.t[2]*two.t[2]+one.t[3]*two.t[3];
	}
	
	public static Tuple cross(Tuple one, Tuple two) {
		Tuple ret = new Tuple(
				one.t[1]*two.t[2]-one.t[2]*two.t[1],
				one.t[2]*two.t[0]-one.t[0]*two.t[2],
				one.t[0]*two.t[1]-one.t[1]*two.t[0],
				0
				);
		return ret;
	}
	
	public boolean equals(Object o) {
		Tuple o1 = (Tuple) o;
		return o1.t[0] == t[0] &&
				o1.t[1] == t[1] &&
						o1.t[2] == t[2] &&
								o1.t[3] == t[3];
	}
	
	public static Tuple mult(Tuple one, Tuple two) {
		return new Tuple(one.t[0]*two.t[0], one.t[1]*two.t[1], one.t[2]*two.t[2], one.t[3]*two.t[3]);
		
		}

	protected <E extends Tuple> E dup () {
			E x = null;
			try {
				x = (E) this.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			x.t = new double[4];
			return (E) x;
			
		}

	public static void main(String args[]) {
		
		
	}
	
}