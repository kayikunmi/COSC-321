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
        double intens = 100000.0;
    
        // Add moonlight using BSpline
        RiAttributeBegin();
        //double[] lightColor = {0.4, 0.4, 0.5};
        RiCoordinateSystem("surfaceDefine");
        RiPattern("kShader","kShader");
		RiBxdf("PxrSurface","surface",
		       "reference color diffuseColor", "kShader:Cout", RI_NULL);
        //RiBxdf("PxrSurface", "moonSurface", "color diffuseColor", lightColor);
        RiLight("PxrDistantLight","light1","float intensity",intens,RI_NULL);
        RiTranslate(18,10,10);
        RiScale(1.5,2, 0.5);
        RiRotate(100,40,10,0);
        new BSplineSurfaceDrawer().PatchDraw("testBB");
        RiAttributeEnd();
    
       // Blue sea
        RiAttributeBegin();
        double[] blue = {0,0,1};
        RiPattern("kBump","kBump");
		RiBxdf("PxrSurface","surface",
            "color diffuseColor",blue,
            "reference normal bumpNormal", "kBump:N1");
        // double[] blue = {0,0,1};
        // RiBxdf("PxrSurface","surface","color diffuseColor",blue,
        //         "int diffuseDoubleSided",1); //maybe use for clouds
        RiTranslate(0,0,5);
        RiScale(8,8,0.5);
        RiSphere(1.5, -1.5, 1.5, 360.0, RI_NULL);
        RiAttributeEnd();

    
        // Rock
        RiAttributeBegin();
        double[] rockColor = {0.5, 0.5, 0.5};
        RiBxdf("PxrSurface", "rockSurface", "color diffuseColor", rockColor);
        RiTranslate(4, -3, 0);
        RiScale(2, 2, 0.5);
        RiRotate(45, 1, 1, 0);
        new KObject().rock();
        RiAttributeEnd();
    
        // Seaplant
        RiAttributeBegin();
        RiTranslate(-2.05, -7,1);
        RiScale(0.01,0.01,0.01);
        LsysExample lsys = new LsysExample();
        lsys.example3();
        RiAttributeEnd();
    
        // Fish
        RiAttributeBegin();
        RiPattern("kStripes","kStripes");
		RiBxdf("PxrSurface","surface",
		       "reference color diffuseColor", "kStripes:Cout", RI_NULL);
        // double[] fishColor = {1, 0.5, 0};
        // RiBxdf("PxrSurface", "fishSurface", "color diffuseColor", fishColor);
        RiRotate(180, 0, 1,0);
        RiTransformBegin();
        RiTranslate(0, 8, 0);
        new KObject().fish();
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(4, 4, 0);
        new KObject().fish();
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(-6, 5, 0);
        RiScale(1.5,1.5,1);
        new KObject().fish();
        RiTransformEnd();

        RiAttributeEnd();
    
        // Stars
        RiAttributeBegin();
        // new KObject().stars();
        // new KObject().stars();
        RiAttributeEnd();

        // Clouds
        RiAttributeBegin();
        double[] cloudColor = {1, 1, 1};
        RiBxdf("PxrVolume", "cloudSurface", "color diffuseColor", cloudColor);
        RiTranslate(0, 12, 10);
        new KObject().clouds();
        // RiTranslate(12, 10, 10);
        // new KObject().clouds();
        // RiTranslate(18, 13, 10);
        // new KObject().clouds();
        // RiTranslate(22, 11, 10);
        // new KObject().clouds();
        RiAttributeEnd();
    
    
        RiWorldEnd();
        RiEnd();
    }

    
}
