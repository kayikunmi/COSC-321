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

        RiWorldBegin(1.0);
        RiTranslate(0.0, 0.0, 1.0);

       // Add road
        RiAttributeBegin();
        double[] grey = {0.5, 0.5, 0.5};
        RiBxdf("PxrSurface", "surface1",
            "int diffuseDoubleSided", 1,
            "color diffuseColor", grey);
        RiTranslate(0.0, 0.5, 10.0);
        RiScale(20.0, 20.0, 1.0);
        RiPolygon(4, RI_P, JerCube.Unit, RI_NULL);
        RiAttributeEnd();

        // Add car
        RiAttributeBegin();
        double[] red = {1.0, 0.0, 0.0};
        RiBxdf("PxrSurface", "surface1",
            "int diffuseDoubleSided", 1,
            "color diffuseColor", red);
        RiTranslate(0.0, -3, 10.0);
        // RiRotate(30.0, 0.0, 1.0, 0.0);
        RiScale(2,2, 1);
        new KObject().object();
        RiAttributeEnd();

        RiWorldEnd();

        RiEnd();
    }
}
