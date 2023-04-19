public class Aux {

	
	public static final double EPSILON = 0.0001;




	public static Vector reflect(Vector in, Vector normal) {
		
		double dot = 2*Tuple.dot(in,  normal);
		
		Tuple a = normal.scale(dot);
		Tuple b = Tuple.sub(in, a);
		
		return new Vector(b);
		
		
	}
	
	
	
	
	public static void main(String[] args) {

}




	public static Matrices viewTransform(Point from, Point to, Vector up) {
		
		
		
		
		
		return null;
	}
	
}
