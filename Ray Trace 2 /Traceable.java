import java.util.*;



public abstract class Traceable {

	protected Matrices transform = Matrices.identity();
	protected Material material = new Material();

	public ArrayList<Intersection> intersections(Ray r) { 
		return this.local_intersect(r);
	}; 

	//Finds the intersection with the smallest positive t value in the given ArrayList
	//If the input ArrayList is empty, the method returns null.
	public static Intersection hit(ArrayList<Intersection> result){
		if (result.isEmpty()){
			return null;
		}
		
		Intersection smallT = null; //The smallest positive t value found so far
		double minT = -1;  //The minimum positive t value found so far, initialized to a negative value to ensure any positive t value is smaller
		
		//Loop through each Intersection object in the input ArrayList
		//Check if has a positive t value and is smaller than minT or if smallT is null
		for (Intersection x : result){
			
			if (x.t > 0 && (smallT == null || x.t < minT)){
				smallT = x; //Update smallT to the new Intersection object with the smallest positive t value found
				minT = x.t; //Update minT to the new minimum positive t value found
			}
		}
		
		return smallT; 
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
