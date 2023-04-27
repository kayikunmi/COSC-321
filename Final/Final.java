public class Final extends Ri {
    public static void main(String[] args) {
        new Final().main();
    }
    void main (){
        RiBegin(RI_NULL);
        RiFormat(400,400,1.0);
        RiPixelVariance(0.1);
        RiProjection("perspective",RI_NULL);
        RiDisplay("file.tiff","file","rgba",RI_NULL);
   
        RiWorldBegin(1.0);
        RiTranslate(0.0, 0.0, 1.0);
    
        // Add ocean
        RiAttributeBegin();
        double[] blue = {0.0, 0.5, 1.0};
        RiBxdf("PxrSurface", "surface1",
            "int diffuseDoubleSided", 1,
            "color diffuseColor", blue);
        RiTranslate(0.0, -0.5, 10.0);
        RiScale(100.0, 0.5, 1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();
    
        // Add land
        RiAttributeBegin();
        double[] green = {0.0, 1.0, 0.0};
        RiBxdf("PxrSurface", "surface1",
            "int diffuseDoubleSided", 1,
            "color diffuseColor", green);
        RiTranslate(0.0, -0.25, 10.0);
        RiScale(10.0, 0.5, 1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();
    
        // Add sun
        RiAttributeBegin();
        double[] yellow = {1.0, 1.0, 0.0};
        RiBxdf("PxrSurface", "surface1",
            "int diffuseDoubleSided", 1,
            "color diffuseColor", yellow);
        RiTranslate(0.0, 1.0, 10.0);
        RiSphere(0.25, -0.25, 0.25, 360.0, RI_NULL);
        RiAttributeEnd();
    
        // // Add your existing object
        // RiAttributeBegin();
        // RiTranslate(-0.3, 0.4, 10.0-1.5);
        // RiScale(2, 2.0, 1);
        // double[] darkOrange = {1.0, 0.549, 0};
        // RiBxdf("PxrSurface", "surface1",
        //     "int diffuseDoubleSided", 1,
        //     "color diffuseColor", darkOrange);
        // new KObject().object();
        // RiAttributeEnd();
    
        RiWorldEnd();
 
        RiEnd();
    }
}
