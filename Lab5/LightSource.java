import java.util.ArrayList;

public abstract class LightSource {
	
	protected MyColor intensity;
	protected Point position;
		
	public abstract MyColor intensityAt(
			Point point, 
			World w);

	public boolean isShadowed(Point p,  World w) {
		
		return false;
		
	}


	
}