import javax.xml.crypto.dsig.Transform;

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
            "reference normal bumpNormal", "kBump:N1", 
            "float clearcoatRoughness", 1.2);
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
        RiBxdf("PxrSurface", "rockSurface", "color diffuseColor", 
        rockColor, "float clearcoatRoughness", 1.2);
        RiTranslate(-5, -3, 0);
        RiScale(2, 2, 0.5);
        RiRotate(45, 1, 1, 0);
        new KObject().rock();
        RiTranslate(4, 4,0);
        RiRotate(135, 0, 1, 0);
        new KObject().rock();
        RiTranslate(0, -9,0);
        RiRotate(45, 0, 1, 0);
        new KObject().rock();
        RiTranslate(2, 7,0);
        RiRotate(90, 1, 0, 0);
        new KObject().rock();
        RiAttributeEnd();
    
        // Seaplant
        RiAttributeBegin();
        RiTransformBegin();
        RiTranslate(-2.05, -6,1);
        RiScale(0.01,0.01,0.01);
        new LsysExample().plant();
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(3.05, -6,1);
        RiScale(0.01,0.01,0.01);
        new LsysExample().plant();
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(0, -6,1);
        RiScale(0.01,0.01,0.01);
        new LsysExample().plant();
        RiTransformEnd();

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

        RiTransformBegin();
        RiTranslate(5, 6, 0);
        RiRotate(180,0,1,0);
        new KObject().fish();
        RiTransformEnd();

        RiAttributeEnd();
    
        // Stars
        RiAttributeBegin();
        new KObject().stars();
        new KObject().stars();
        RiAttributeEnd();

        // Clouds
        RiAttributeBegin();
        double[] cloudColor = {1, 1, 1};
        RiBxdf("PxrVolume", "cloudSurface", "color diffuseColor", cloudColor);
        // RiTransformBegin();
        // RiTranslate(0, 12, 10);
        // new KObject().clouds();
        // RiTransformEnd();
      
        RiTransformBegin();
        RiTranslate(-10, 12, 10);
        new KObject().clouds();
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(10, 12, 10);
        new KObject().clouds();
        RiTransformEnd();

        RiAttributeEnd();

    
        RiWorldEnd();
        RiEnd();
    }

    
}
