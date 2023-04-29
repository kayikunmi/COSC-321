public class Final extends Ri {
    public static void main (String args[]) throws java.io.FileNotFoundException { 
        new Final().main();
    }

    void main() throws java.io.FileNotFoundException {

        RiBegin(RI_NULL);
        RiDisplay("file.tiff", "file", "rgba", RI_NULL);
        RiProjection("perspective", RI_NULL);
        RiTranslate(0, 0, 10);
        RiWorldBegin(1.0);

        //blue sea
        RiAttributeBegin();
		double[] blue = {0,0,1};
		RiBxdf("PxrSurface","shader","color diffuseColor",blue,"int diffuseDoubleSided",1);
        RiScale(10,10,10);
		RiSphere (3, 2, 5, 360.0, RI_NULL);
        RiAttributeEnd();

        // // rock
        // RiAttributeBegin();
        // double[] rockColor = {0.5, 0.5, 0.5};
        // RiBxdf("PxrSurface", "rockSurface", "color diffuseColor", rockColor);
        // RiTranslate(-3, -4, -4);
        // RiRotate(45, 1, 1, 0);
        // RiCylinder(0.2, 1.5, 2, 360.0, RI_NULL);
        // RiAttributeEnd();

        //seaplant
        RiAttributeBegin();
        RiTranslate(-2.05, -5,1);
        RiScale(0.01,0.01,0.01);
		LsysExample lsys = new LsysExample();
		lsys.example3();
        // RiTranslate(15, -5,1);
        // RiScale(0.01,0.01,0.01);
        // lsys.example3();
	    RiAttributeEnd();

        //fish
        RiAttributeBegin();
        double[] fishColor = {1, 0.5, 0};
        RiBxdf("PxrSurface", "fishSurface", "color diffuseColor", fishColor);
        RiTranslate(0, 8, 0);
        new KObject().fish();
        RiTranslate(4, -5, 0);
        new KObject().fish();
        RiAttributeEnd();

        //stars
        RiAttributeBegin();
		Points p = new Points();
		p.stars();
		RiAttributeEnd();


        RiWorldEnd();
        RiEnd();
    }
}
