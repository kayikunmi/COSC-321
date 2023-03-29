
import Jama.Matrix; 

public class Matrices {

	Matrix A;

	public Matrices(double[][] a) {
		A = new Matrix(a);
	}

	public Matrices(Matrix b) {
		A = b;
	}

	public static Matrices mult(Matrices a, Matrices b) {
		Matrix t = a.A.times(b.A);
		Matrices answer = new Matrices(t);
		return answer;	
	}

	public static Matrices mult(Matrices... mults) {
		Matrices answer = identity();

		for (Matrices m : mults) {
			answer = mult(answer,m);

		}

		return answer;
	}

	public static <E extends Tuple> E apply(Matrices m, E v) {

		Matrix a = m.A;   

		Matrix b = new Matrix(v.getT(), 4);  

		Matrix c = a.times(b);  

		E copy = v.dup();
		
		double[] temp = c.transpose().getArray()[0];
		
		for (int i=0; i<4; i++)
			copy.t[i] = temp[i];
		
		return copy;	
	}

	public  Matrices invert() {

		Matrix t = this.A.inverse();
		Matrices answer = new Matrices(t);
		return answer;

	}

	public static Matrices identity() {
		double[][] array = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		Matrices C = new Matrices(array);
		return C;
	}


	public Matrices transpose() {
		double[][] a = this.A.getArrayCopy();
		double[][] answer = new double[a.length][a[0].length];
		for (int i=0; i< a.length; i++) {
			for (int j=0; j< a[i].length; j++)
				answer[j][i] = a[i][j];

		}

		return new Matrices(answer);
	}
	public String toString() {

		String answer = "";

		double[][] a = A.getArrayCopy();
		for (int i=0; i< a.length; i++) {
			for (int j=0; j< a[i].length; j++)
				answer = answer + (a[i][j]+"  ");
			answer = answer + "\n";;

		}
		return answer;
	}

	public boolean equals(Object o) {
		Matrix other = ((Matrices) o).A;
		double[][] a = A.getArrayCopy();
		double[][] b = other.getArrayCopy();	

		for (int i=0; i< a.length; i++)
			for (int j=0; j< a[i].length; j++)
				if (a[i][j] != b[i][j])
					return false;

		return true;
	}


	public static void main(String[] args) {

	}

}
