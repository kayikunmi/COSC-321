
public class KObject extends Ri{

    void object() {
        // body
        RiAttributeBegin();
        double[] bodyColor = {1, 0.47, 0.2};
        RiBxdf("PxrSurface", "bodySurface", "color diffuseColor", bodyColor);
        RiTransformBegin();
        RiScale(2.0, 1.0, 1.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiTransformBegin();
        RiScale(2.0, 1.0, 1.0);
        RiTranslate(0.0, 0.0, 2.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiTransformBegin();
        RiTranslate(0.0, 0.5, 0.0);
        RiScale(2.0, 0.5, 1.0);
        RiCylinder(0.5, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiAttributeEnd();

        // wheels
        double[] wheelColor = {0, 0, 0};
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                RiAttributeBegin();
                RiTranslate(i, 0.0, j * 1.25);
                RiBxdf("PxrSurface", "wheelSurface", "color diffuseColor", wheelColor);
                RiTransformBegin();
                RiScale(1.0, 1.0, 0.2);
                RiCylinder(0.5, -1.0, 1.0, 360.0, RI_NULL);
                RiTransformEnd();
                RiAttributeEnd();
            }
        }
    }
}
