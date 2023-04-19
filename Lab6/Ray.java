public class Ray {

	protected Point origin;
	protected Vector direction;
	
	public String toString() {
		return "Ray from "+origin+" in direction "+direction;
	}
	
	private Ray() {
	
	}
	
	public Ray(Point origin, Vector direction) {
		super();
		this.origin = origin;
		this.direction = direction;
	}
	
	public Ray(double i, double j, double k, double l, double m, double n) {
		this(new Point(i,j,k), new Vector(l,m,n));
	}

	public Point position(double t) {
		Point answer = new Point(Tuple.add(origin, direction.scale(t)));
		return answer;
	}
	
	
	public static void main(String args[]) {
		
		
	}
	
	public Ray transform(Matrices a) {
		Ray answer = new Ray();
		answer.direction = new Vector(Matrices.apply(a, direction));
		answer.origin = new Point(Matrices.apply(a, origin));
	
		return answer;
	}
	
}
