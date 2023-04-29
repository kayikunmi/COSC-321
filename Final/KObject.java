
public class KObject extends Ri{

    void car() {
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
    void snowman() {
        // body
        RiAttributeBegin();
        double[] snowColor = {1.0, 1.0, 1.0};
        RiBxdf("PxrSurface", "snowSurface", "color diffuseColor", snowColor);
        RiTransformBegin();
        RiScale(2.0, 2.0, 2.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiTransformBegin();
        RiScale(1.8, 1.8, 1.8);
        RiTranslate(0.0, 2.2, 0.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiTransformBegin();
        RiScale(1.6, 1.6, 1.6);
        RiTranslate(0.0, 4.2, 0.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        RiAttributeEnd();
        // head
        RiAttributeBegin();
        RiTranslate(0.0, 5.7, 0.0);
        RiSphere(0.5, -1.0, 1.0, 360.0, RI_NULL);
        RiAttributeEnd();
    }

    void table() {
        // table top
        RiAttributeBegin();
        double[] tabletopColor = {0.8, 0.6, 0.4};
        RiBxdf("PxrSurface", "tabletopSurface", "color diffuseColor", tabletopColor);
        RiTransformBegin();
        RiScale(2.0, 0.2, 2.0);
        RiTranslate(0.0, 5.0, 0.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
        // table legs
        double[] legColor = {0.4, 0.3, 0.2};
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                RiAttributeBegin();
                RiTranslate(i * 1.5, 2.5, j * 1.5);
                RiBxdf("PxrSurface", "legSurface", "color diffuseColor", legColor);
                RiTransformBegin();
                RiScale(0.2, 2.5, 0.2);
                RiCylinder(0.5, -1.0, 1.0, 360.0, RI_NULL);
                RiTransformEnd();
                RiAttributeEnd();
            }
        }
        RiAttributeEnd();
    }

    public void teapot() {
        RiTransformBegin();
        RiTranslate(0.0, 1.0, 0.0);
        RiScale(1.0, 0.5, 1.0);
        RiSphere(1.0, -1.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(0.0, 0.0, -1.0);
        RiCone(1.0, 2.0, 360.0, RI_NULL);
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(0.0, 0.0, 1.0);
        RiRotate(-90.0, 1.0, 0.0, 0.0);
        RiCylinder(0.5, 0.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();

        RiTransformBegin();
        RiTranslate(0.0, -0.5, 0.0);
        RiScale(0.5, 0.5, 1.0);
        RiRotate(-90.0, 1.0, 0.0, 0.0);
        RiCylinder(1.0, 0.0, 1.0, 360.0, RI_NULL);
        RiTransformEnd();
    }

}
