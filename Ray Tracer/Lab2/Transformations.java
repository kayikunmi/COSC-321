

public class Transformations {

	/* In order to cement your understanding of Transformations, 
	 * fill in the methods with missing insides - the ones that currently
	 * return null
	 */
	
	public static Matrices getTranslate(double x, double y, double z) {
		return null;
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
					{0, Math.sin(x),0},
					{0, -Math.sin(x), Math.cos(x),0},
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

		System.out.println(" ");
		//System.out.println("n: " +"\n" + n);

		Matrices s1 = getScale(3,1,2);
		Matrices s2 = getScale(1,2,4);
		Matrices s1s2 = Matrices.mult(s1, s2);
		Matrices s2s1 = Matrices.mult(s2, s1);
		
		if(s1s2.equals(s2s1)){
			System.out.println("Scaling works as expected");
		}
		else{
			System.out.println("fix scale");
		}
		

	}

}
