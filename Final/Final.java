public class Final extends Ri {
    public static void main(String[] args) {
        new Final().main();
    }

    void main() {
        RiBegin(RI_NULL);
        RiFormat(400, 400, 1.0);
        RiPixelVariance(0.1);
        RiProjection("perspective", RI_NULL);
        RiDisplay("file.tiff", "file", "rgba", RI_NULL);
        RiWorldBegin();

        // Add sky
        RiAttributeBegin();
        double[] skyColor = {0.3, 0.5, 1.0}; // blue color for sky
        RiBxdf("PxrSurface", "surface1",
                "int diffuseDoubleSided", 1,
                "color diffuseColor", skyColor);
        RiTranslate(0.0, 2.0, 10.0); // move the sky above the camera
        RiScale(20.0, 20.0, 1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();

        // Add road
        RiAttributeBegin();
        double[] roadColor = {0.5, 0.5, 0.5}; // gray color for road
        RiBxdf("PxrSurface", "surface1",
                "int diffuseDoubleSided", 1,
                "color diffuseColor", roadColor);
        RiTranslate(0.0, -1.0, 10.0); // move the road below the camera
        RiScale(20.0, 2.0, 1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();

        // Add moon
        RiAttributeBegin();
        double[] moonColor = {1.0, 1.0, 1.0}; // white color for moon
        RiBxdf("PxrSurface", "surface1",
                "int diffuseDoubleSided", 1,
                "color diffuseColor", moonColor);
        RiTranslate(4.0, 4.0, 10.0); // move the moon to the top right of the sky
        RiScale(1.0, 1.0, 1.0);
        RiSphere(0.5, -0.5, 0.5, 360.0, RI_NULL);
        RiAttributeEnd();

        // Add car
        RiAttributeBegin();
        double[] carColor = {1.0, 0.0, 0.0}; // red color for car
        RiBxdf("PxrSurface", "surface1",
                "int diffuseDoubleSided", 1,
                "color diffuseColor", carColor);
        RiTranslate(0.0, -1.0, 15.0); // move the car in front of the camera
        RiScale(2.0, 1.0, 1.0);
        new KObject().object(); // use the KObject class to draw a red cube for the car
        RiAttributeEnd();

        RiWorldEnd();
        RiEnd();
    }
}
