
public class KTurtle extends Turtle {


	public KTurtle(double width, double shrinkWidth, double length, 
			double shrinkLength, double aX, double aY, double aZ, double[] c) {
		super( width,  shrinkWidth,  length,  shrinkLength,  aX,  aY,  aZ, c);
	}

	public boolean doOneStep(StringBuffer spec, Point where, char firstStep) {
		switch (firstStep) {

		case 'F':
			outputRealLeaf(where,firstStep);
			RiRotate(+angleY, 0.0, 1.0, 1.0);
			break;
		case '+':
			RiRotate(+angleZ,0.75, 1.0, 0.2);
			break;
		case '-':
			RiRotate(+angleZ,0.2, 0.75, 1.0);
			break;
		case '[':
			RiRotate(+angleX, 0.8, 1.0, 0.5);
			break;
		case ']':
			RiRotate(+angleY, 1.0, 0.8, 0.5);
			break;
        case '/':
			RiRotate(+angleX, 0.75, 0.2, 1.0);
			break;

		default:super.doOneStep(spec,where,firstStep);
		}
		return false;
	}
}
