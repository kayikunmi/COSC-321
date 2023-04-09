import java.util.ArrayList;

//import org.junit.Test;
//might need this line. compiled code without it

public class Sphere extends Traceable {
	
	protected double radius = 1;
	
	public Sphere() {
		radius = 1;
	}
	
	public ArrayList<Intersection> local_intersect(Ray r1) {
		//complete this
		/* transform the ray by inverse of the Traceable transform before 
		 * intersecting See the beginning of the method in Cube for help
		 * */
		var r = r1.transform(transform.invert());
		
		/* Calculate a, b and c as in class.  Be careful about using the ray origin, 
		 * which is a point - don't accidentally get an extra 1 from the w coordinate
		 * 
		 */
		
		 Point p = new Point(0, 0, 0);
		 Tuple sphereToRay = Tuple.sub(p, r.origin);
		 double a = Tuple.dot(r.direction, r.direction);
		 double b = 2 * Tuple.dot(r.direction, sphereToRay);
		 double c = Tuple.dot(sphereToRay,sphereToRay) - 1;
		 
		 ArrayList<Intersection> ans = new ArrayList<Intersection>();
		 double discriminant = b * b - 4 * a * c;
		 if (discriminant < 0) {
		     return ans;
		 }
		 
		 // Fill in the intersections
		 double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
		 double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);
		
		 ans.add(new Intersection(this, t1));
		 ans.add(new Intersection(this, t2));
		 
		 return ans;
		 }
		 
	
	@Override
	public Vector local_normal_at(Point p, Intersection dontUse) {
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		Ray r = new Ray(new Point(0,0,-5),new Vector(0,0,1));
		Traceable s = new Sphere();
		
		show(r,s);
				
		s.transform = Transformations.getScale(2, 2, 2);

		show(r,s);
		
		s.transform = Transformations.getTranslate(5, 0, 0);

		show(r,s);
		
	}

	private static void show(Ray r, Traceable s) {
		// Assumes zero or two intersections - debugging code
		ArrayList<Intersection> ans = s.intersections(r);
		if (ans.size() == 0)
			System.out.println("No Intersexctions");
		else 
			System.out.println(ans.get(0)+"   "+ans.get(1));
	}

	@Override
	public boolean includes(Traceable object) {
		return false;
	}
	
	
	
	
	
	
	
}
