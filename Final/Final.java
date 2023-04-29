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

        // sky
        RiAttributeBegin();
        double[] lightBlue = {0.5, 0.7, 1.0}; // adjust values to change color
        RiBxdf("PxrSurface","shader","color diffuseColor",lightBlue,"int diffuseDoubleSided",1);
        RiTransformBegin();
        RiTranslate(0, 10, 0);
        RiScale(10, 10, 10); // increase scale to make larger polygon
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiTransformEnd();
        RiAttributeEnd();

        // ground
        RiAttributeBegin();
        double[] grassGreen = {0.5, 0.8, 0.5}; // adjust values to change color
        RiBxdf("PxrSurface","shader","color diffuseColor",grassGreen,"int diffuseDoubleSided",1);
        RiTransformBegin();
        RiTranslate(0, -2, 0);
        RiScale(10, 1, 10); // increase scale to make larger polygon
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiTransformEnd();
        RiAttributeEnd();

        //bspline
        RiAttributeBegin();
        double[] silver = {1,1,0.8};
        RiBxdf("PxrSurface","shader","color diffuseColor",silver,"int diffuseDoubleSided",1);
        RiTranslate(7,7,0);
        RiScale(0.3,0.3,0.3);
        new BSplineSurfaceDrawer().PatchDraw("testAA");
        RiAttributeEnd();

        // //lsys
        // RiAttributeBegin();
        // RiTranslate(-200,-150,300);
        // RiScale(0.3,0.3,0.3);
        // LsysExample lsys = new LsysExample();
        // lsys.example2();
        // RiTranslate(1200,0,0);
        // lsys.example2();
        // RiAttributeEnd();

        // //stars
        // RiAttributeBegin();
        // Points p = new Points();
        // p.stars();
        // RiAttributeEnd();

        // //car
        // RiAttributeBegin();
        // RiTranslate(1,-5,1);
        // RiScale(1,1,0.5);
        // KObject car = new KObject();
        // car.table();
        // RiAttributeEnd();

        //snowman
        RiAttributeBegin();
        // RiTranslate(-10, -10, 4);
        // RiScale(1,1,0.5);
        KObject snowman = new KObject();
        snowman.table();
        RiAttributeEnd();

        RiWorldEnd();
        RiEnd();
    }
}
