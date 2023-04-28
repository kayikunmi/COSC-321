import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BSplineSurfaceDrawer extends Ri {

	void PatchDraw(String filename) throws java.io.FileNotFoundException
	{
		// assumes cubic BSpline Patch
		// data shold be in filename
		Scanner f = new Scanner(new FileReader(filename));
		


		f.useDelimiter(Pattern.compile("[,\\s]+"));

		// remove unneeded header?
		for (int kk=0; kk<19;kk++)
		    f.nextDouble();



		// writes the data to outtest so you can see that it is reading correctly

		PrintWriter pw = new PrintWriter(new File("outtest"));

		int usize, vsize;

		usize =  f.nextInt();
		vsize = f.nextInt();

		pw.println(usize+"  "+vsize);
		pw.flush();

		double[][][] Patch1 = new double[usize-4][vsize-4][3];

		double[] knotsU = new double[usize];
		double[] knotsV= new double[vsize];


		for (int i=0; i<usize; i++)
		{
			knotsU[i] = f.nextDouble();
			pw.println(knotsU[i]);
		}

		for (int i=0; i<vsize; i++)
		{ 
			knotsV[i] = f.nextDouble();
			pw.println(knotsV[i]);
		}

		double wcoord;

		for (int i=0; i<usize-4; i++) {
			for (int j=0; j<vsize-4 ;j++) {
				for (int k=0; k<3; k++) {
					Patch1[i][j][k] = f.nextDouble();
				}
				// throw away the w coordinate
				wcoord = f.nextDouble();

				pw.println(Patch1[i][j][0]+"  "+Patch1[i][j][1]+
						"  "+Patch1[i][j][2]);
			}
		}

		RiBasis(RiBSplineBasis,1,RiBSplineBasis,1);

		RiNuPatch(usize-4, 4, knotsU, 0, 1, 
				vsize-4, 4, knotsV, 0, 1, "P", Patch1, RI_NULL);
		pw.flush();


	}

	void PatchDrawClosed(String filename) throws java.io.FileNotFoundException
	{
		// assumes cubic BSpline Patch
		// data shold be in filename
		Scanner f = new Scanner(new FileReader(filename));
		f.useDelimiter(Pattern.compile("[,\\s]+"));


		// remove unneeded header?
		for (int kk=0; kk<19;kk++)
		    f.nextDouble();


		// writes the data to outtest so you can see that it is reading correctly

		PrintWriter pw = new PrintWriter(new File("outtest"));

		int usize, vsize;

		usize =  f.nextInt()+3;
		vsize = f.nextInt()+3;

		pw.println(usize+"  "+vsize);
		pw.flush();

		double[][][] Patch1 = new double[usize-4][vsize-4][3];

		double[] knotsU = new double[usize];
		double[] knotsV= new double[vsize];


		for (int i=0; i<usize-3; i++)
		    {
			knotsU[i] = f.nextDouble();
		
		    }
		

		for (int i=0; i<vsize-3; i++)
		{ 
			knotsV[i] = f.nextDouble();

		}

		for (int i=0; i<usize;i++) 
		    {
			knotsU[i] = ((double) i)/(usize-1);
			knotsV[i] = ((double) i)/(usize-1);
			pw.println("Knot"+knotsU[i]);
			pw.println(knotsV[i]);
    }

		double wcoord;

		for (int i=0; i<usize-7; i++) {
			for (int j=0; j<vsize-7 ;j++) {
				for (int k=0; k<3; k++) {
					Patch1[i][j][k] = f.nextDouble();
				}
				// throw away the w coordinate
				wcoord = f.nextDouble();

				pw.println("A "+i+" "+j);
				
				pw.println(Patch1[i][j][0]+"  "+Patch1[i][j][1]+
						"  "+Patch1[i][j][2]);
			}
		}

		for (int i=0; i<usize-7; i++) {
		    for (int j =0; j<3; j++) {
			for (int k=0; k<3; k++) {

			    Patch1[i][j+vsize-7][k] =
				Patch1[i][j][k];
			}
		    }
		}

		for (int i=0; i<3; i++) {
		    for (int j =0; j<vsize-4; j++) {
			for (int k=0; k<3; k++) {

			    Patch1[i+usize-7][j][k] =
				Patch1[i][j][k];
			}
		    }
		}

		for (int i=0; i<3; i++) {
		    for (int j =0; j<3; j++) {
			for (int k=0; k<3; k++) {

			    Patch1[i+usize-7][j+vsize-7][k] =
				Patch1[i+usize-7][j][k];

			    pw.println((i+usize-7)+" "+(j+vsize-7));

			    pw.println(Patch1[i+usize-7][j+vsize-7][0]+"  "+Patch1[i+usize-7][j+vsize-7][1]+
				       "  "+Patch1[i+usize-7][j+vsize-7][2]);
			}
		    }
		}


		for (int i=0; i<usize-4; i++) {
		    for (int j =0; j<vsize-4; j++) {
			    pw.println(i+"  "+j+"  ");
			    pw.println(Patch1[i][j][0]+"  "+Patch1[i][j][1]+
				       "  "+Patch1[i][j][2]);
		    }
		}

		RiBasis(RiBSplineBasis,1,RiBSplineBasis,1);

		RiNuPatch(usize-4, 4, knotsU, 0, 1, 
				vsize-4, 4, knotsV, 0, 1, "P", Patch1, RI_NULL);

		pw.flush();
	}
}
