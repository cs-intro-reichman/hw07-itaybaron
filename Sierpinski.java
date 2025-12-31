/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    StdDraw.setScale(0, 1);
	StdDraw.enableDoubleBuffering();
    StdDraw.clear();

    sierpinski(n,
        0.0, 0.0,
        1.0, 0.0,
        0.5, 0.866);

		StdDraw.show();

	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double y1, double x2,
		                                 double y2, double x3, double y3) {
		
		if (n == 0){
			StdDraw.polygon(new double[]{x1, x2, x3},
				 new double[] {y1, y2, y3});
			return;
		}
	
		double x12 = (x1 + x2) / 2;
		double x31 = (x1 + x3) / 2;
		double x23 = (x3 + x2) / 2;
		double y12 = (y1 + y2) / 2;
		double y31 = (y1 + y3) / 2;
		double y23 = (y3 + y2) / 2;

		sierpinski(n-1, x1, y1, x12, y12, x31, y31);
    	sierpinski(n-1, x12, y12, x2, y2, x23, y23);
    	sierpinski(n-1, x31, y31, x23, y23, x3, y3);
	}
}
