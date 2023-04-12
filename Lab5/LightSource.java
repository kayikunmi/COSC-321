import java.util.ArrayList;

public abstract class LightSource {
	
	protected MyColor intensity;
	protected Point position;
		
	public abstract MyColor intensityAt(
			Point point, 
			World w);

	public boolean isShadowed(Point p, World w) {
		// Create a ray from the light source position to the point p
		Ray shadray = new Ray(position, Tuple.sub(p, position).normalize());
	
		// Find the intersections of the ray with objects in the world
		ArrayList<Intersection> shadraylist = w.intersectWorld(shadray);
	
		// Check if any intersection is between the light source and the point p
		for (Intersection intersection : shadraylist) {
			// If an intersection exists between the light source and point p, return true
			if (intersection.t > 0 && intersection.t < Tuple.sub(p, position).magnitude()) {
				return true;
			}
		}
	
		// If no intersection exists between the light source and point p, return false
		return false;
	}

	


	
}