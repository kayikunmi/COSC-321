

public class Transformations {

	/* In order to cement your understanding of Transformations, 
	 * fill in the methods with missing insides - the ones that currently
	 * return null
	 */
	
	public static Matrices getTranslate(double x, double y, double z) {
		return new Matrices(
				new double[][]{
					
					{0,0,0,0},
					{0,0,0,0},
					{0,0,0,0},
					{x,y,z,1}});
	}
	
	public static Matrices getScale(double sx, double sy, double sz) {
		return new Matrices(
				new double[][]{
					
					{sx,0,0,0},
					{0,sy,0,0},
					{0,0,sz,0},
					{0,0,0,1}});
	}
	
	public static Matrices getRotZ(double x) {
		return new Matrices(
				new double[][]{
					
					{Math.cos(x),-Math.sin(x),0,0},
					{Math.sin(x), Math.cos(x),0,0},
					{0,0,1,0},
					{0,0,0,1}});
	}
	
	public static Matrices getRotY(double x) {
		return new Matrices(
				new double[][]{
					
					{Math.cos(x),0, -Math.sin(x),0},
					{0,1,0,0},
					{Math.sin(x),0, Math.cos(x),0},
					{0,0,0,1}});
	}
	
	public static Matrices getRotX(double x) {
		return new Matrices(
				new double[][]{
					
					{1,0,0,0},
					{0, Math.cos(x), -Math.sin(x),0},
					{0, Math.sin(x), Math.cos(x),0},
					{0,0,0,1}});
	}
	
	public static void main(String[] args) {
	
		Matrices m = Matrices.identity();
		Matrices n = new Matrices(new double [][] 
				{{2,3,4,5},{1,2,3,4},{2,3,4,7},{0,0,0,1}});
		
		Matrices p1 = Matrices.mult(m,n);
		Matrices p2 = Matrices.mult(n,m);

		System.out.println("p1: " + "\n" + p1);
		System.out.println("p2: " + "\n" + p2);

		Point v1 = new Point(Matrices.apply(n, new Point(1,1,1)));
		System.out.println("v1: " + "\n" + v1);

		System.out.println("///// ");
		System.out.println(" ");

		Matrices s1 = getScale(3,1,2);
		Matrices s2 = getScale(1,2,4);
		Matrices s1s2 = Matrices.mult(s1, s2);
		Matrices s2s1 = Matrices.mult(s2, s1);
		
		if(s1s2.equals(s2s1)){
			System.out.println("Scaling works as expected");
		}
		else{
			System.out.println("Fix Scale");
		}

		System.out.println("///// ");
		System.out.println(" ");
		
		Matrices rx = getRotX(45);
		Matrices rxs1s2= Matrices.mult(rx, s1s2);
		Matrices s1s2rx = Matrices.mult(s1s2, rx);
		Point p = new Point(2,3,4);
		Point ps1s2rx = new Point(Matrices.apply(s1s2rx, p));
		Point prxs1s2= new Point(Matrices.apply(rxs1s2, p));
		
		if(rxs1s2.equals(s1s2rx)){
			System.out.println("Rotating on x and Translating works as expected");
		}
		else{
			System.out.println("Fix Rotating on x and Translating");
			System.out.println("Rx * S1S2: " + "\n" + rxs1s2);
			System.out.println("S1S2* Rx: " + "\n" + s1s2rx);
			System.out.println("P * RxS1S2: " + "\n" + prxs1s2);
			System.out.println("P * S1S2Rx: " + "\n" + ps1s2rx);
		}
		System.out.println("///// ");
		System.out.println(" ");

		Matrices ry = getRotY(90);
		Matrices rys1s2 = Matrices.mult(ry, s1s2);
		System.out.println("rys1s2: " + "\n" + rys1s2);
		//this rotates and scales

		Matrices t2 = getTranslate(2,3,5);
		Matrices t2rys1s2 = Matrices.mult(t2, rys1s2);
		System.out.println("t2rys1s2: " + "\n" + t2rys1s2);
		System.out.println("///// ");
		//this tranalstes the scaled and rotated matrix

	}
	//do the final part and add something that shows you understand transformations

}
