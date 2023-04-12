import java.util.ArrayList;

public abstract class LightSource {
	
	protected MyColor intensity;
	protected Point position;
		
	public abstract MyColor intensityAt(
			Point point, 
			World w);

	public boolean isShadowed(Point p, World w) {
		Ray shadray = new Ray(position, new Vector(1, 0, 0));
		ArrayList<Intersection> shadraylist = w.intersectWorld(shadray);
		if(Traceable.hit(shadraylist)==null){ 
			return false;
		}
		else{
			return true;
		}
	}
		

	


	
}