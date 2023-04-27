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
        RiTranslate(0.0,0.0,1.0);
    
        RiAttributeBegin();
        RiTranslate(-0.3,0.4,10.0-1.5);
        RiScale(2,2.0,1);
        double[] darkOrange = {1.0,0.549,0};
        RiBxdf("PxrSurface","surface1", "int diffuseDoubleSided", 1, "color diffuseColor", darkOrange);
        new KObject().object();
        RiAttributeEnd();

        RiAttributeBegin();
        double[] Grey = {0.65,1,0.45};
        RiBxdf("PxrSurface","surface1",
        "int diffuseDoubleSided",1,
        "color diffuseColor", Grey);
        RiTranslate(0.0,0.0,10.0);
        RiScale(100.0,100.0,1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();

        
        RiWorldEnd();
 
        RiEnd();
    }
}
