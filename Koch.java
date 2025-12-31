/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.
		
		StdDraw.enableDoubleBuffering();
		/* 
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

	
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
		StdDraw.show();

	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
    if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
    }

    double dx = x2 - x1;
    double dy = y2 - y1;

    // נקודה ראשונה בחלוקה
    double xA = x1 + dx / 3;
    double yA = y1 + dy / 3;

	// נקודה שנייה בחלוקה
    double xB = x1 + 2 * dx / 3;
    double yB = y1 + 2 * dy / 3;

    // Peak of the equilateral triangle
    double xC = (x1 + x2) / 2 + Math.sqrt(3) * (y1 - y2) / 6;
	double yC = (y1 + y2) / 2 + Math.sqrt(3) * (x2 - x1) / 6;

    // Recursive calls
    curve(n - 1, x1, y1, xA, yA);
    curve(n - 1, xA, yA, xC, yC);
    curve(n - 1, xC, yC, xB, yB);
    curve(n - 1, xB, yB, x2, y2);
}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
    StdDraw.setXscale(0, 1);
    StdDraw.setYscale(0, 1);

    // נקודות של משולש שווה־צלעות
    double x1 = 0.2, y1 = 0.33;
    double x2 = 0.8, y2 = 0.33;
    double x3 = 0.5, y3 = 0.33 + Math.sqrt(3) * 0.3;

    curve(n, x2, y2, x1, y1);
    curve(n, x3, y3, x2, y2);
    curve(n, x1, y1, x3, y3);

    StdDraw.show();
 }
}
