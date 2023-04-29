
public class KObject extends Ri{

    void fish() {
        // body
        RiAttributeBegin();
        double[] fishColor = {0.5, 0.8, 1.0};
        RiBxdf("PxrSurface", "fishSurface", "color diffuseColor", fishColor);
        RiTransformBegin();
        RiRotate(-90.0, 1.0, 0.0, 0.0);
        RiScale(0.8, 0.8, 2.0);
        RiCylinder(0.2, 0.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiAttributeEnd();
        // tail
        RiAttributeBegin();
        RiTranslate(0.0, 0.0, 2.0);
        RiRotate(90.0, 1.0, 0.0, 0.0);
        RiCone(0.2, 0.0, 1.0, RI_NULL);
        RiAttributeEnd();
        // fins
        RiAttributeBegin();
        RiTranslate(0.0, 0.3, 1.0);
        RiRotate(-30.0, 1.0, 0.0, 0.0);
        RiCone(0.1, 0.0, 0.5, RI_NULL);
        RiAttributeEnd();
        RiAttributeBegin();
        RiTranslate(0.0, -0.3, 1.0);
        RiRotate(30.0, 1.0, 0.0, 0.0);
        RiCone(0.1, 0.0, 0.5, RI_NULL);
        RiAttributeEnd();
        RiAttributeBegin();
        RiTranslate(0.3, 0.0, 1.0);
        RiRotate(30.0, 0.0, 1.0, 0.0);
        RiCone(0.1, 0.0, 0.5, RI_NULL);
        RiAttributeEnd();
        RiAttributeBegin();
        RiTranslate(-0.3, 0.0, 1.0);
        RiRotate(-30.0, 0.0, 1.0, 0.0);
        RiCone(0.1, 0.0, 0.5, RI_NULL);
        RiAttributeEnd();
    }
}
