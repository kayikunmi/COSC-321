import java.util.*;



public abstract class Traceable {

	protected Matrices transform = Matrices.identity();
	protected Material material = new Material();

	public ArrayList<Intersection> intersections(Ray r) { 
		return this.local_intersect(r);
	}; 

	// public static Intersection hit(ArrayList<Intersection> result) {
	// 	/* You need to write this - this should return 
	// 	null if result is empty
	// 	the Intersection with the smallest POSITIVE t value
	// 	*/
	// 	/*t is the amount youhave to multiply the direction by and add it to the origin
	// 	 * greater than zero, but closest to 0
	// 	 */
	// 	Collections.sort(result);
	// 	for (Intersection x:result){
	// 		if(x.compareTo(x) >=0){
	// 			//find the smallest
	// 		}
	// 	}
	// }

	public static Intersection hit(ArrayList<Intersection> result) {
		if (result.isEmpty()) {
			return null;
		}
		
		Intersection minIntersection = null;
		double minT = -1;  // Set to negative value to ensure any positive t value is smaller
		
		for (Intersection intersection : result) {
			if (intersection.t > 0 && (minIntersection == null || intersection.t < minT)) {
				minIntersection = intersection;
				minT = intersection.t;
			}
		}
		
		return minIntersection;
	}
	


	//merges two Intersection Lists  
	public static ArrayList<Intersection> mergeInters(ArrayList<Intersection> rightxs,
			ArrayList<Intersection> leftxs) {
		ArrayList<Intersection> result;
		result = new ArrayList<Intersection>();
		result.addAll(rightxs);
		result.addAll(leftxs);

		return result;
	}

	public Vector normal_to_world(Vector normal) {
		return normal;
	}

	public Point world_to_object(Point p) {	
		return p;
	}

	public abstract ArrayList<Intersection> local_intersect(Ray r);




	public static void main(String[] args) {

		// This is a little test program
		
		var test = new ArrayList<Intersection>();

		test.add(new Intersection(new Cube(),-2));
		test.add(new Intersection(new Cube(),-1));

		for (Intersection f:test)
			System.out.println(f);

		System.out.println(hit(test));




	}

	public final Vector normalAt(Point p, Intersection i) {

		return null;
	}


	public abstract Vector local_normal_at(Point p, Intersection i);

	public abstract boolean includes(Traceable object);


}
