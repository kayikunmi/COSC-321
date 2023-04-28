import java.util.Random;
public class Points extends Ri
{
    public static double[] Blue = {0,0,1};
    public static double[] White= {1,1,1};
    public static double[] Red= {1,0,0};
    public static double[] Orange = {1,0.68,0};

    
    public static void main(final String[] array) {
        new Points().go();
    }
    
    public void go() {
        this.RiBegin(Points.RI_NULL);
        this.RiDisplay("points.tiff", "file", "rgba", new Object[] { Points.RI_NULL });
        this.RiFormat(Integer.valueOf(800), Integer.valueOf(600), 1.0);
        this.RiPixelVariance(0.1);
        this.RiProjection("perspective", new Object[] { Points.RI_NULL });
        this.RiWorldBegin(10.0);
        this.stars();
        this.RiWorldEnd();
        this.RiEnd();
    }

    void stars() {

      	
	RiTransformBegin();		
	RiTranslate(3,0.0,5.0);
        
	double[][] coloros = {Blue,White,Red, Orange};
	for (int i = 0; i<100; i++){
	    drawFiveRandomPoints(400,800,300,coloros);
	}
        
	RiTransformEnd();



    }

    void drawFiveRandomPoints(int xrange, int yrange, int zrange,
			      double[][] colorOptions){
	Random rand = new Random();
	int[] locations = new int[15]; 
	double[] color = colorOptions[rand.nextInt(colorOptions.length)];
	for (int i = 0; i<15; i=i+3){
	    //x
	    locations[i] = rand.nextInt(xrange);
	    if (rand.nextInt(2) == 0) {
		locations[i] = -locations[i];
	    }
	    //y
	    locations[i+1] = rand.nextInt(yrange);
	    if (rand.nextInt(2) == 0) {
		locations[i+1] = -locations[i+1];
	    }

	    //z
	    locations[i+2] = 50 + rand.nextInt(zrange);
	}
		
	RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",color);

	RiPoints(5, "P",locations);
    }
}
