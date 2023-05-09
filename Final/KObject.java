import java.util.*;
public class KObject extends Ri{

    void fish() {
        RiAttributeBegin();
        double[] fishColor = {1, 0.5, 0};
        RiBxdf("PxrSurface", "fishSurface", "color diffuseColor", fishColor);
        RiTranslate(0, -3, 0);
        RiRotate(-30, 0, 1, 0);
        RiScale(0.6, 0.6, 0.6);
        RiCone(1, 2, 4, RI_NULL);
        RiTranslate(0, 0, 2);
        RiSphere(1, -1, 1, 360.0, RI_NULL);
        RiTranslate(0, 0, -2.5);
        RiCylinder(0.5, 0.5, 2.5, 360.0, RI_NULL);
        RiAttributeEnd();
    }
    void rock() {
        RiAttributeBegin();
        double[] rockColor = {0.05, 0.08, 0.08};
        //RiBxdf("PxrSurface", "rockSurface", "color diffuseColor", rockColor);
        RiBxdf("PxrSurface","surface1","int diffuseDoubleSided",1,"color diffuseColor",rockColor, "float presence", 0.5);
        RiSphere(0.2,-1,1,360.0,RI_NULL);
        RiCylinder(0.2, -0.15, 0.15, 360.0, RI_NULL);
        RiAttributeEnd();
    }
    void stars() {
        RiTransformBegin();		
        RiTranslate(3,0.0,5.0);
        double [] Blue = {0,0,1};
        double [] White = {1,1,1};
        double [] Red = {1,0,0};
        double [] Orange = {1,0.5,0};
        double [] Black = {0,0,0};
        double[][] coloros = {Blue,White,Red, Orange, Black};
        for (int i = 0; i<100; i++){
            drawFiveRandomPoints(400,800,300,coloros);
        }    
        RiTransformEnd();
    }
    void drawFiveRandomPoints(int xrange, int yrange, int zrange, double[][] colorOptions){
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
    // void clouds() {
    //     RiAttributeBegin();
    //     double[] cloudColor = {1, 1, 1};
    //     RiBxdf("PxrSurface", "cloudSurface", "color diffuseColor", cloudColor);
    //     Random rand = new Random();
    //     for (int i = 0; i < 20; i++) {
    //         double x = rand.nextDouble() * 10 - 5;
    //         double y = rand.nextDouble() * 10 - 5;
    //         double z = rand.nextDouble() * 10 - 5;
    //         double scale = rand.nextDouble() * 0.5 + 1.0;
    //         RiTransformBegin();
    //         RiTranslate(x, y, z);
    //         RiScale(scale, scale, scale);
    //         RiSphere(1, -1, 1, 360.0, RI_NULL);
    //         RiTransformEnd();
    //     }
    //     RiAttributeEnd();
    // }
    
}
