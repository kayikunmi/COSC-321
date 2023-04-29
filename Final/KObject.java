
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
}
