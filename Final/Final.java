public class Final extends Ri {
    public static void main (String args[]) throws java.io.FileNotFoundException { 
        new Final().main();
    }

    void main() throws java.io.FileNotFoundException {

        RiBegin(RI_NULL);
        RiDisplay("file.tiff", "file", "rgba", RI_NULL);
        RiFormat(800,600,1);
        RiProjection("perspective", RI_NULL);
        RiTranslate(0, 0, 10);
        RiWorldBegin(0.5);
    
        // Add moonlight using BSpline
        RiAttributeBegin();
        //double[] lightColor = {0.4, 0.4, 0.5};
        RiCoordinateSystem("ShaderDefine");
        RiPattern("kShader","kShader");
		RiBxdf("PxrSurface","surface1",
		       "reference color diffuseColor", "kShader:Cout", RI_NULL);
        //RiBxdf("PxrSurface", "moonSurface", "color diffuseColor", lightColor);
        RiTranslate(15,12,10);
        RiScale(1,1, 0.5);
        new BSplineSurfaceDrawer().PatchDraw("testAA");
        RiAttributeEnd();
    
        // Blue sea
        RiAttributeBegin();
        double[] blue = {0,0,1};
        RiBxdf("PxrSurface","shader","color diffuseColor",blue,"int diffuseDoubleSided",1);
        RiScale(10,10,10);
        RiSphere (3, 2, 5, 360.0, RI_NULL);
        RiAttributeEnd();
    
        // Rock
        RiAttributeBegin();
        double[] rockColor = {0.5, 0.5, 0.5};
        RiBxdf("PxrSurface", "rockSurface", "color diffuseColor", rockColor);
        RiTranslate(4, -3, 2);
        RiScale(1.5,1.5,1.5);
        RiRotate(45, 1, 1, 0);
        RiCylinder(0.2, 0.5, 1, 360.0, RI_NULL);
        RiAttributeEnd();
    
        // Seaplant
        RiAttributeBegin();
        RiTranslate(-2.05, -5,1);
        RiScale(0.01,0.01,0.01);
        LsysExample lsys = new LsysExample();
        lsys.example3();
        RiAttributeEnd();
    
        // Fish
        RiAttributeBegin();
        double[] fishColor = {1, 0.5, 0};
        RiBxdf("PxrSurface", "fishSurface", "color diffuseColor", fishColor);
        RiTranslate(0, 8, 0);
        new KObject().fish();
        RiTranslate(4, -5, 0);
        new KObject().fish();
        RiAttributeEnd();
    
        // Stars
        RiAttributeBegin();
        Points p = new Points();
        p.stars();
        RiAttributeEnd();
    
    
        RiWorldEnd();
        RiEnd();
    }
    
}
