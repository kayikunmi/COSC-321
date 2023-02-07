
import java.io.*;

public class Ri {

	public static final Object RI_NULL = null;
	public static final String RI_P = "P";
    public static final String RI_CS = "Cs";
	public static final int RI_TRUE = 1;
	public static final int RI_FALSE = 0;
	public static final String RiBSplineBasis = "b-spline";
	public static final String RI_UNION = "union";
	public static final String RI_PRIMITIVE = "primitive";
	public static final String RI_INTERSECTION = "intersection";
	public static final String RI_DIFFERENCE = "difference";
	public static final String RI_BICUBIC = "bicubic";
	
	
	public static final String RiBezierBasis =       "BezierBasis";
	//public static final String RiBSplineBasis =      "BSplineBasis";
	public static final String RiCatmullRomBasis =   "CatmullRomBasis";
	public static final String RiHermiteBasis =      "HermiteBasis";
	public static final String RiPowerBasis =        "PowerBasis";
	public static final String RiBesselFilter =      "BesselFilter";
	public static final String RiBlackmanHarrisFilter ="BlackmanHarrisFilter";
	public static final String RiBoxFilter =         "BoxFilter";
	public static final String RiCatmullRomFilter =  "CatmullRomFilter";
	public static final String RiDiskFilter =        "DiskFilter";
	public static final String RiGaussianFilter =    "GaussianFilter";
	public static final String RiMitchellFilter =    "MitchellFilter";
	public static final String RiLanczosFilter =     "LanczosFilter";
	public static final String RiSeparableCatmullRomFilter ="SeparableCatmullRomFilter";
	public static final String RiSincFilter =        "SincFilter";
	public static final String RiTriangleFilter =    "TriangleFilter";
	public static final String RiErrorIgnore =       "ErrorIgnore";
	public static final String RiErrorPrint =        "ErrorPrint";
	public static final String RiErrorPrintOnce =    "ErrorPrintOnce";
	public static final String RiErrorCondAbort =    "ErrorCondAbort";
	public static final String RiErrorAbort =        "ErrorAbort";
	public static final String RiErrorCleanup =      "ErrorCleanup";
	public static final String RiProcDelayedReadArchive ="ProcDelayedReadArchive";
	public static final String RiProcRunProgram =    "ProcRunProgram";
	public static final String RiProcDynamicLoad =   "ProcDynamicLoad";

	public static final int RI_BEZIERSTEP = 3;
	public static final int RI_BSPLINESTEP	= 1;	
	public static final int RI_CATMULLROMSTEP	= 1;
	public static final int RI_HERMITESTEP = 2;
	public static final int RI_POWERSTEP	 = 4;	

	private static PrintStream out;

	public  void RiBegin(Object o) {
		File fi;
		if (o instanceof String) {
			String name = (String) o;
			fi = new File(name);
		}
		else fi = new File("java.rib");
		try {	
			out = new PrintStream(fi);
			//System.out.println("opening stream");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(2);
		}

		RiHider("raytrace","int incremental",0,"int minsamples",16,
			"int maxsamples", 86);


		RiIntegrator("PxrPathTracer","handle","int maxIndirectBounces", new int []{2},
			     "int numLightSamples", new int[]{1}, "int numBxdfSamples",
			     new int[] {1}, "int numIndirectSamples", new int[]{1},
			     "int numDiffuseSamples", new int[] {4},
			     "int numSpecularSamples", new int[] {4});
		
		

		
	}

	public void RiEnd() {
		out.close();
	}

	public void RiDisplay(String name, String type, String mode, Object... objects) {

		out.print("Display ");
		toOut(name);
		toOut(type);
		toOut(mode);
		toOut(objects);
		lineEnd();
	}
	
	public void RiDisplay(Object... objects) {

		out.print("Display ");
		toOut(this.getClass()+".tiff");
		toOut("framebuffer");
		toOut("rgba");
		toOut(objects);
		lineEnd();
	}


	public void RiFormat(Integer xres, Integer yres, double aspect) {
		out.print("Format ");
		toOut(xres);
		toOut(yres);
		toOut(aspect);
		lineEnd();
	}

	public void RiProjection(String name, Object... os) {
		out.print("Projection ");
		toOut(name);
		toOut(os);
		lineEnd();
	}

	private int lights = 0;

	public int RiLightSource(String name, Object... os ) {
		System.err.println("RiLightSource is deprecated. DO NOT IGNORE THIS");
		//System.out.println("The Amherst College CS321 binding will replace this with a");
		//		System.out.println("PxrEnvDayLight");
		//RiRotate(-90,1,0,0); //???
		//RiRotate(90,0,0,0);
		//out.print("Light ");
		//toOut("PxrDistantLight");
		//toOut("PxrEnvDayLight");
		//lights++;
		//toOut("light"+lights);
		//toOut("intensity");
		//toOut(100000);
		/*
		out.print("LightSource ");
		toOut(name);
		toOut(lights);
		toOut(os);
		*/
		//		lineEnd();
		return -1;
	}

	public void RiPixelSamples(double x, double y) {
		out.print("PixelSamples ");
		toOut(x);
		toOut(y);
		lineEnd();
	}

	public void RiPixelSamples(Integer x, Integer y) {
		out.print("PixelSamples ");
		toOut(x);
		toOut(y);
		lineEnd();
	}

	public void RiSurface(String name, Object... objects) {
		System.out.println("RiSurface is deprecated.  The Amherst College binding will replace");
		System.out.println("This with a simple Bxdf if the shader is matte.  It the shader is");
		System.out.println("Something else, we will throw an excpetion");
		if (!name.equals("matte")) {
			AC_CS321_Exception e = new AC_CS321_Exception(name);
			//throw e;
		}
		RiColor(currentColor);
		/*
		out.print("Surface ");
		toOut(name);
		toOut(objects);
		lineEnd();
	*/
	}	

	public void RiWorldBegin() {
		out.print("WorldBegin");
		lineEnd();
		RiTransformBegin();
		//RiTranslate(10.0,0.0,0.0);
		RiLight("PxrDomeLight","light3","float intensity",0.1,RI_NULL);
		//RiLight("PxrSphereLight","light3","float intensity",1000,RI_NULL);
		RiTransformEnd();
	}

    	public void RiWorldBegin(double intensity) {
		out.print("WorldBegin");
		lineEnd();
		RiTransformBegin();
		//RiTranslate(10.0,0.0,0.0);
		if (intensity == 0) {
		    System.out.println("default light is turned off");
		}
		else RiLight("PxrDomeLight","light3","float intensity",intensity,RI_NULL);
		//RiLight("PxrSphereLight","light3","float intensity",1000,RI_NULL);
		RiTransformEnd();
	}

	public void RiWorldEnd() {
		out.print("WorldEnd");
		lineEnd();
	
	}

	public void RiTranslate(double dx, double dy, double dz) {
		out.print("Translate ");
		toOut(dx);
		toOut(dy);
		toOut(dz);
		lineEnd();
	}

	public void RiScale(double dx, double dy, double dz) {
		out.print("Scale ");
		toOut(dx);
		toOut(dy);
		toOut(dz);
		lineEnd();
	}

	public void RiRotate(double... ds) {
		out.print("Rotate ");
		for (double d : ds) 
			toOut(d);
		lineEnd();
	}

    public void RiPattern(String name, Object... os) {
		simple("Pattern",name,os);
    }
    
	public void RiAttributeBegin() {
		simple("AttributeBegin");
	}

	public void RiAttributeEnd() {
		simple("AttributeEnd");
	}

	public void RiTransformBegin() {
		simple("TransformBegin");
	}

	public void RiTransformEnd() {
		simple("TransformEnd");
	}

	public void RiPolygon(Integer n, Object... os ) {
		out.print("Polygon ");
		toOut(os);
		lineEnd();
	}

	public void RiAtmosphere(String name, Object... os) {
		simple("Atmosphere",name,os);
	}

	public void RiAreaLightSource(String name, Object... os) {
		simple("AreaLightSource",name,os);
	}

	public void RiAttribute(String name, Object... os) {
		simple("Attribute",name,os);
	}

	public void RiBasis(String u, int us, String v, int vs) {
		out.print("Basis ");
		toOut(u);
		toOut(us);
		toOut(v);
		toOut(vs);
		lineEnd();
	}
	
	public void RiBlobby(
			int nleaf,
			int ncode, int code[],
			int nflt, double flt[],
			int nstr, String str[],
			Object... os) {
		out.print("Blobby ");
		toOut(nleaf);
		//toOut(ncode);
		toOut(ncode,code);
		//toOut(nflt);
		toOut(flt);
		//toOut(nstr);
		toOutString(str);
		toOut(os);
		lineEnd();
		
	}


	private void toOutString(String[] str) {
			out.print("[ ");
			for (String d : str) {
				out.print("\""+d+"\"");
			}
			out.print(" ] ");
		
	}

	public void RiBound(double[] ds) {
		out.print("Bound ");
		for (double d1 : ds) {
			double d = d1;
			toOut(d);
		}
		lineEnd();
	}

	public void RiClipping(double a, double b) {
		out.print("Clipping ");
		toOut(a);
		toOut(b);
		lineEnd();
	}

	public void RiColor(double[] ds) {
		/*out.print("Color ");
		for (double d : ds) {
			toOut(d);
		}*/
		
		System.out.println("RiColor is deprecated");
		System.out.println("The AC CS321 binding will replace this with a Bxdf with the color");
		System.out.println("Assigned to the diffuse color");
		currentColor = ds;
		out.print("Bxdf ");
		toOut("PxrSurface");
		toOut("CS321_"+randTag());
		toOut("color diffuseColor");
		out.print("[ ");
		for (double d : ds) {
			toOut(d);
		}
		out.print(" ]");
		
		toOut("color specularFaceColor");
		out.print("[ ");
		for (double d : ds) {
			toOut(d);
		}
		out.print(" ]");
		toOut("int diffuseDoubleSided");
		toOut( new int[] {1});

		lineEnd();
	}

	private int randTag() {
		return (int) (Math.random()*1000);
	}
	
	public void RiColorSample(int n, double[] a, double[] b) {
		out.print("ColorSamples");
		toOut(a);
		toOut(b);
		lineEnd();
	}

	public void RiConcatTransform(double[][] t) {
		simple("ConcatTransform",t);
	}

	public void RiConcatTransform(double[] t) {
		simple("ConcatTransform",t);
	}

	public void RiCone(double height, double radius, double max, Object... os ) {
		out.print("Cone ");
		toOut(height);
		toOut(radius);
		toOut(max);
		toOut(os);
		lineEnd();
	}

	public void RiCoordinateSystem(String name) {
		simple("CoordinateSystem",name);
	}

	public void RiCoordSysTransform(String name) {
		simple("CoordinateSysTransform",name);
	}

	public void RiCropWindow(double... ds) {
		out.print("CropWindow ");
		for (double d : ds)
			toOut(d);
		lineEnd();
	}

	public void RiCurves(String type, int ncurves, int[] nverts, String wrap, Object... os) {
		out.print("Curves ");
		toOut(type);
		toOut(nverts);
		toOut(wrap);
		toOut(os);
		lineEnd();
	}
	
	public void RiCylinder(double radius, double min, double max, double th, Object... objects) {
		out.print("Cylinder ");
		toOut(radius);
		toOut(min);
		toOut(max);
		toOut(th);
		toOut(objects);
		lineEnd();
	}

	public void RiDeclare(String name, String type) {
		out.print("Declare ");
		toOut(name);
		toOut(type);
		lineEnd();
	}

	public void RiDeformation(String name, Object... os) {
		simple("Deformation",name,os);
	}

	public void RiDepthOfField(double fs, double fl, double fd) {
		out.print("DepthOfField ");
		toOut(fs);
		toOut(fl);
		toOut(fd);
		lineEnd();
	}

	public void RiDetail(double[] ds) {
		out.print("Detail ");
		for (double d1 : ds) {
			double d = d1;
			toOut(d);
		}
		lineEnd();
	}


	public void RiDetailRange(double... ds) {
		out.print("DetailRange ");
		for (double d : ds) {
			toOut(d);
		}
		lineEnd();
	}

	public void RiDisk(double h, double r, double t, Object... os) {
		out.print("Disk ");
		toOut(h);
		toOut(r);
		toOut(t);
		toOut(os);
		lineEnd();
	}

	public void RiDisplacement(String name, Object... os) {
		simple("Displacement",name,os);
	}

	public void RiErrorHandler(String n) {
		simple("ErrorHandler",n);
	}

	public void RiExposure(double g, double gamma) {
		out.print("Exposure ");
		toOut(g);
		toOut(gamma);
		lineEnd();
	}

	public void RiExterior(String name, Object... os) {
		simple("Exterior",name,os);
	}

	public void RiFrameAspectRatio(double d) {
		out.print("FrameAspectRatio ");
		toOut(d);
		lineEnd();
	}

	public void RiFrameBegin(int n) {
		out.println("FrameBegin "+n);
	}

	public void RiFrameEnd() {
		simple("FrameEnd");
	}

	public void RiGeneralPolygon(int loops, int[] verts, Object... os) {
		out.print("GeneralPolygon ");
		toOut(verts);
		toOut(os);
		lineEnd();
	}

	public void RiGeometricApproximation(String s, double d) {
		out.print("GeometricApproximation ");
		toOut(d);
		lineEnd();
	}

	public void RiGeometry(String name, Object... os) {
		simple("Geometry",name,os);
	}

	public void RiHider(String name, Object... os) {
		simple("Hider ", name, os);
	}

	public void RiHyperboloid(double[] a, double[] b, double angle, Object... os) {

		out.print("Hyperboloid ");
		for (double d : a)
			toOut(d);
		for (double d : b)
			toOut(d);
		toOut(angle);
		toOut(os);
		lineEnd();
	}

	public void RiIdentity() {
		simple("Identity");	
	}

	public void RiIlluminate(int handle, int onoff) {
		out.print("Illuminate ");
		toOut(handle);
		toOut(onoff);
		lineEnd();
	}

	public void RiImager(String name, Object... os) {
		simple("Imager",name,os);
	}

	public void RiInterior(String name, Object... os) {
		simple("Interior",name,os);
	}

	//makeBump

	//MakeCubeEnvironment

	//MakeLatLongEnv

	public void RiMakeShadow(String picturename, String textureName, Object... os) {
		out.print("MakeShadow ");
		toOut(picturename);
		toOut(textureName);
		toOut(os);
		lineEnd();
	}

	//Maketexture

	public void RiMatte(int onoff) {
		simple("Matte",onoff);
	}
/*
 * MotionBegin [ t0 t1... tn-1 ]
	MotionEnd -
 */
	public void RiMotionBegin( int n, double... ds ) {
		out.print("MotionBegin ");
		out.print("[ ");
		if (n != ds.length)
		System.out.println("Warning - number of timesteps in RiMotionBegin is not the same" +
				" as parameter n (cs.amherst.edu warning");
		for (double d : ds) {
			out.print(d+" ");
		}
		out.print(" ]");
		lineEnd();
	}
	
	public void RiMotionEnd () {
		out.println("MotionEnd ");
		lineEnd();
	}

	


	public void RiNuPatch(int nu, int uorder, double[] uknot, double umin, double umax,
			int nv, int vorder, double[] vknot, double vmin, double vmax, Object... os) {
		out.print("NuPatch ");
		toOut(nu);
		toOut(uorder);
		toOut(uknot);
		toOut(umin);
		toOut(umax);
		toOut(nv);
		toOut(vorder);
		toOut(vknot);
		toOut(vmin);
		toOut(vmax);
		toOut(os);
		lineEnd();
	}

	private int objects = 0;

	public int RiObjectBegin() {
		objects++;
		out.println("ObjectBegin "+objects);
		return objects;
	}

	public void RiObjectEnd() {
		simple("ObjectEnd");
	}
	
	public void RiObjectInstance(int obj) {
		simple("ObjectInstance",obj);
	}
	
	public void RiOpacity(double[] c) {
		out.print("Opacity ");
		for (double d : c) 
			toOut(d);
		lineEnd();
	}
	
	public void RiOption(String name, Object... os) {
		simple("Option",name,os);
	}
	
	public void RiOrientation(String orient) {
		simple("Orientation",orient);
	}
	
	public void RiParaboloid(double rax, double zmin, double zmax, double th, Object... os) {
		out.print("Paraboloid ");
		toOut(rax);
		toOut(zmin);
		toOut(zmax);
		toOut(th);
		toOut(os);
		lineEnd();
	}
	
	public void RiPatch(String name, Object... os) {
		simple("Patch",name,os);
	}
	
	public void RiPatchMesh(String type, int nu, String uwrap, int nv,
			String vwrap, Object... os) {
		out.print("PatchMesh ");
		toOut(type);
		toOut(nu);
		toOut(uwrap);
		toOut(nv);
		toOut(vwrap);
		toOut(os);
		lineEnd();
	}
	
	public void RiPerspective(double fov) {
		simple("Perspective",fov);
	}
	
	public void RiPixelFilter(String name, double xw, double yw) {
		out.print("PixelFilter ");
		toOut(name);
		toOut(xw);
		toOut(yw);
		lineEnd();
	}
	
	
	public void RiPixelSampleImager(String name, Object... os) {
		simple("PixelSampleImager",name,os);
	}
	
	public void RiPixelVariance(double variation) {
		simple("PixelVariance",variation);
	}
	
	public void RiPointsGeneralPolygons(int npolys, int[] nloops, int[] nverts,
			int[] verts, Object... os) {
		
		out.print("PointsGeneralPolygons ");
		toOut(nloops);
		toOut(nverts);
		toOut(verts);
		toOut(os);
		lineEnd();
	}
	
	public void RiPointsPolygons(int npolys, int[] nverts,
			int[] verts, Object... os) {
		
		out.print("PointsPolygons ");
		toOut(nverts);
		toOut(verts);
		toOut(os);
		lineEnd();
	}

    public void RiSubdivisionMeshSimp ( String scheme, int nfaces, int nvertices[],
                      int vertices[], /*int ntags, String tags[],
					int nargs[], int intargs[], double floatargs[],*/
				    Object... os) {
	out.print("SubdivisionMesh ");
	toOut(scheme);
	//toOut(nfaces);
	toOut(nvertices);
	toOut(vertices);
	//toOut(ntags);
	//toOut(tags);
	//toOut(nargs);
	//toOut(intargs);
	//toOut(floatargs);
	toOut(os);
	lineEnd();
    }


    public void RiSubdivisionMesh ( String scheme, int nfaces, int nvertices[],
                      int vertices[], int ntags, String tags[],
                      int nargs[], int intargs[], double floatargs[],
				    Object... os) {
	out.print("SubdivisionMesh ");
	toOut(scheme);
	//toOut(nfaces);
	toOut(nvertices);
	toOut(vertices);
	//toOut(ntags);
	toOut(tags);
	toOut(nargs);
	toOut(intargs);
	toOut(floatargs);
	toOut(os);
	lineEnd();
    }

	
	//RiProcedural
	
	public void RiQuantize(String type, double... ds) {
		out.print("Quantize ");
		for (double d :ds) 
			toOut(d);
		lineEnd();
	}
	
	public void RiRelativeDetail(double rd) {
		simple("RelativeDetail",rd);
	}
	
	public void RiReverseOrientation() {
		simple("ReverseOrientation");
	}
	
	public void RiScreenWindow(double... ds) {
		out.print("ScreenWindow ");
		for (double d : ds) {
			toOut(d);
		}
		lineEnd();
	}
	
	public void RiShadingInterpolation(String t) {
		simple("ShadingInterpolation", t);
	}
	
	public void RiShadingRate(double r) {
		simple("ShadingRate",r);
	}
	
	public void RiShutter(double o, double c) {
		out.print("Shutter ");
		toOut(o);
		toOut(c);
		lineEnd();
	}
	
	public void RiSides(int r) {
		simple("Sides",r);
	}
	
	public void RiSkew(double... ds) {
		out.print("Skew ");
		for (double d : ds) 
			toOut(d);
		lineEnd();
	}
	
	public void RiSolidBegin(String name) {
		simple("SolidBegin",name);
	}
	
	public void RiSolidEnd() {
		simple("SolidEnd");
	}
	
	public void RiSphere(double radius, double zmin, double zmax, double theta,
			Object... os) {
		out.print("Sphere ");
		toOut(radius);
		toOut(zmin);
		toOut(zmax);
		toOut(theta);
		toOut(os);
		lineEnd();
	}
	
	public void RiTextureCoordinates(double...ds) {
		out.print("TextureCoordinates");
		for (double d : ds) 
			toOut(d);
		lineEnd();
	}
	
	
	public void RiTorus ( double majorradius, double minorradius,
			double phimin, double phimax, double thetamax,
	           Object... os) {
		out.print("Torus ");
		toOut(majorradius);
		toOut(minorradius);
		toOut(phimin);
		toOut(phimax);
		toOut(thetamax);
		toOut(os);
		lineEnd();
	}

	public void RiTransform(double[][] t) {
		out.print("Transform ");
		toOut(t);
		lineEnd();
	}
	
	//Trimcurves
	
	
	private void simple(String meth, double x, double y) {
		out.print(meth+" ");
		toOut(x);
		toOut(y);
		lineEnd();
		
	}

	private void simple(String meth, double fov) {
		out.print(meth+" ");
		toOut(fov);
		lineEnd();
		
	}

	private void simple(String meth, int onoff) {
		out.print(meth+" ");
		toOut(onoff);
		lineEnd();
	}

	private void simple(String meth, String name) {
		out.print(meth+" ");
		toOut(name);
		lineEnd();
	}

	private void simple(String meth, double[][] t) {
		out.print(meth+" ");
		toOut(t);
		lineEnd();
	}

	private void simple(String meth, double[] t) {
		out.print(meth+" ");
		toOut(t);
		lineEnd();
	}


	private void simple(String method, String name, Object[] os) {
		out.print(method+" ");
		toOut(name);
		toOut(os);
		lineEnd();
	}

	private void simple(String s) {
		out.print(s);
		lineEnd();
	}

	private void lineEnd() {
		out.println();
	}

    private void toOut(int n, int[] a) {
	out.print("[ ");
	for (int i=0; i<n; i++)
	    out.print(a[i]+" ");
	out.print("] ");
    }

	private void toOut(Object[] objects) {
		for (Object o : objects) {
			if (o == null) break;
			toOut(o);
		}
	}

    private void toOut(String[] ds) {
		    out.print("[ ");
		    for (String d : ds) {
			toOut(d);
		    }
		    out.print(" ] ");
    }


	private void toOut(Object o) {
		if (o instanceof String)
			toOut((String) o);
		else if (o instanceof Integer) 
			toOut((Integer) o);
		else if (o instanceof Double) 
			toOut((Double) o);
		else if (o instanceof Double[][][]) {
			Double ds[][][] = (Double[][][]) o;
			out.print("[ ");
			for (Double[][] dl : ds) {
				for (Double d[] : dl)
					for (Double d2 : d)
						toOut(d2);
			}
			out.print(" ] ");
		}
		else if (o instanceof double[][][]) {
			double ds[][][] = (double[][][]) o;
			out.print("[ ");
			for (double[][] dl : ds) {
				for (double d[] : dl)
					for (double d2 : d)
						toOut(d2);
			}
			out.print(" ] ");
		}else if (o instanceof int[]) {
			int ds[] = (int[]) o;
			out.print("[ ");
			for (int d : ds) {
				toOut(d);
			}
			out.print(" ] ");
		}
		else if (o instanceof double[]) {
			double ds[] = (double[]) o;
			out.print("[ ");
			for (double d : ds) {
				toOut(d);
			}
			out.print(" ] ");
		}
		else 	if (o instanceof String)
			toOut((String) o);
		else if (o instanceof Integer) 
			toOut((Integer) o);
		else if (o instanceof double[][]) {
			double ds[][] = (double[][]) o;
			out.print("[ ");
			for (double[] dl : ds) {
				for (double d : dl)
					toOut(d);
			}
			out.print(" ] ");
		}
		else if (o instanceof Double[][]) {
			Double ds[][] = (Double[][]) o;
			out.print("[ ");
			for (Double[] dl : ds) {
				for (Double d : dl)
					toOut(d);
			}
			out.print(" ] ");
		}
		
		else if (o instanceof double[]) {
			double ds[] = (double[]) o;
			out.print("[");
			for (double d : ds) {
				toOut(d);
			}
			out.print(" ] ");
		}
		else
			toOut("Problem with "+o.getClass());
	}

	private void toOut(Integer i) {
		out.print(i.intValue()+" ");
	}

	private void toOut(Double i) {
		out.print(i.doubleValue()+" ");
	}
	
	private void toOut(int i) {
		out.print(i+" ");
	}
	private void toOut(double d) {
		out.print(d+" ");
	}

	private void toOut(String name) {
		out.print("\""+name+"\" ");
	}

	protected void RiColor(double d, double e, double f) {
		double[] c = {d,e,f};
		RiColor(c);
		
	}

	protected void RiPoints(int n,Object... os) {
			out.print("Points ");
			toOut(os);
			lineEnd();
	}







protected void RiReadArchive(String string, Object... os) {
		out.print("ReadArchive ");
		toOut(string);
		toOut(os);
		lineEnd();
		
	}

    //Below here added 2020

    protected void RiBxdf(String s, Object... os) {
	out.print("Bxdf ");
	toOut(s);
	toOut(os);
	lineEnd();
    }

    public void RiIntegrator(String name, Object... os) {
		simple("Integrator ", name, os);
	}

	protected void RiLight(String string, Object...os) {
		simple("Light",string,os);
		
	}

    /*    protected void RiHider(String s, Object... os) {
	out.print("Hider ");
	toOut(s);
	toOut(os);
	lineEnd();
    }
    */
    
	private double[] currentColor = new double[] {1,1,1};
    
}
