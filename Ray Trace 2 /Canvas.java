import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Canvas {

	/* Make sure you understand all the methods you are given.
	 * 
	 * Then fill in the contents of toPPM.  The method should write the
	 * pixels array to a ppm file.  See the method for the details.
	 * 
	 */

	public Canvas() {
	}

	protected MyColor[][] pixels;

	public Canvas(int w, int h) {
		pixels = new MyColor[w][h];
		for (int i=0; i< w; i++)
			for (int j=0; j<h; j++)
				pixels[i][j] = new MyColor(0,0,0);
	}

	public void writeP(int i,int j,MyColor c) {
		pixels[i][j] = c;
	}


	public MyColor pixelAt(int i,int j) {
		return pixels[i][j];
	}

	public void toPPM(String name) {


		File f = new File(name);
		try {
			/* The first line of the file should be P3
			 * On the second line should the number of rows and the number of columns
			 * On the third line put the maximum integer for an RGB value 
			 * (which should be 255, at least for now)
			 * 
			 * After that the RGB values of each pixel.  
			 * 
			 * You need to convert the double values of the RGB to integer values
			 * The doubles should be between 0 and 1
			 */	

			PrintWriter p = new PrintWriter(f);
			// A printwriter has the print and println methods you usually use
			//////
			int rows = 10;
			int cols = 10;
			int maxValue = 255;
			p.println("P3");  
			p.println(cols + " " + rows);
			p.println(maxValue);
			for (int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					int red = (int) (pixels[r][c].t[0]*255);
					int green = (int) (pixels[r][c].t[1]*255);
					int blue = (int) (pixels[r][c].t[2]*255);
					p.println(red + " " + green + " " + blue);
					p.println(green + " " + blue + " " + red);
					p.println(blue + " " + red + " " + green);
					// p.println(pixels[r][c].t[1]*255 + " " + pixels[r][c].t[2]*255 + " " + pixels[r][c].t[0]*255);
					// p.println(pixels[r][c].t[2]*255 + " " + pixels[r][c].t[0]*255 + " " + pixels[r][c].t[1]*255);
					//
					// p.println("150 78 250");
					// p.println("36 178 50");
					// p.println("200 59 20");
               	}	
           }
			//////

			p.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
			System.exit(17);
		}




	}





	public static void main(String args[]) {

		Canvas c = new Canvas(100,50);
		for (int i=0; i<50; i++)
			for (int j=0;j<50; j++)
				c.writeP(i,j,new MyColor(1,0,0,1));

		for (int i=50; i<100; i++)
			for (int j=0;j<50; j++)
				c.writeP(i,j,new MyColor(0,0,1,1));

		c.toPPM("test.ppm");



	}

	////////////
	

}
