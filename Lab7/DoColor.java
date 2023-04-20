public class DoColor extends Ri {

    public void color(double r, double g, double b) {
	double[]  c = new double[]{r,g,b};
	RiBxdf("PxrSurface","surface1",
	       "int diffuseDoubleSided",1,
	       "color diffuseColor",c);
    }
    
}
