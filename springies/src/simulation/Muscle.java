/**
 * 
 */
package simulation;

import java.awt.Dimension;

/**
 * @author Ryan Fishel and Kevin Oh
 *
 */
public class Muscle extends Spring {

	private double myAmplitude;
	//private double initLength;
	//private double myLength;
	private double time;
	/**
	 * @param start the mass at the start of the muscle
	 * @param end: the mass at the end of the muscle
	 * @param length: the length of the muscle
	 * @param kVal: the springiness of the muscle
	 * @param amplitude: the amplitude of the muscle
	 */
	public Muscle(Mass start, Mass end, double length, double kVal, double amplitude) {
		super(start, end, length, kVal);
		myAmplitude = amplitude;
		//initLength = length;

		// TODO Auto-generated constructor stub
	}

	/**
	 * Keeps a counter of the time of the simulation
	 * then calls update in Spring
	 */
	@Override
	public void update (double elapsedTime, Dimension bounds) {
		time += elapsedTime;
		super.update(elapsedTime, bounds);
				
    }
	/**
	 * calculates what the length of the muscle should be and returns the length
	 * @return: returns the length of the muscle
	 */
	public double getLength()
	{
		 return super.getLength()+(Math.sin(time)*myAmplitude);
	}

}
