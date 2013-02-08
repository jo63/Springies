/**
 * 
 */
package simulation;

import java.awt.Dimension;

/**
 * @author junho
 * ryan
 *
 */
public class Muscle extends Spring {

	private double myAmplitude;
	private double initLength;
	//private double myLength;
	private double time;
	/**
	 * @param start
	 * @param end
	 * @param length
	 * @param kVal
	 */
	public Muscle(Mass start, Mass end, double length, double kVal, double amplitude) {
		super(start, end, length, kVal);
		myAmplitude = amplitude;
		initLength = length;

		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void update (double elapsedTime, Dimension bounds) {
		super.update(elapsedTime, bounds);
		time += elapsedTime;
		setLength();		
    }
	
	public void setLength(){
		super.setLength(initLength+(Math.sin(time)*myAmplitude));
	}

}
