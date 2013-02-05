package physicsForces;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import simulation.Mass;
import util.Location;
import util.Vector;

public class WallRepulsion extends CenterOfMass {
	
    public static final int RIGHT_DIRECTION = 0;
    public static final int DOWN_DIRECTION =  90;
    public static final int LEFT_DIRECTION = 180;
    public static final int UP_DIRECTION = 270;
    
    public static final int[] DIRECTIONS = 
    	{
    		90,
    		180,
    		270,
    		0
    	};
    
    private Map<Integer,Vector> myVectors;
	private int myID;
	private Dimension myBounds;
	

	public WallRepulsion() {
		// TODO Auto-generated constructor stub
	}

	public WallRepulsion(double id, double magnitude, double exponent, Dimension bounds) {		
		super(magnitude, exponent);
		System.out.println(id);
		myID = (int) id;
		myBounds = bounds;
		
		// TODO Auto-generated constructor stub
	}
	
	private void initializeVectorMap()
	{
		Map<Integer,Vector> map = new HashMap<Integer, Vector>();
		
		for(int i = 0; i< DIRECTIONS.length;i++)
		{
			map.put(i+1, new Vector(DIRECTIONS[i], getMagnitude()));
		}
//		map.put(1, new Vector(DOWN_DIRECTION,myMagnitude));
//		map.put(2, new Vector(LEFT_DIRECTION,myMagnitude));
//		map.put(3, new Vector(UP_DIRECTION,myMagnitude));
//		map.put(4, new Vector(RIGHT_DIRECTION,myMagnitude));
//		
		myVectors = map;
		
	}
	
//	@Override
//	public void setValues(double[] values)
//	{
//		myID = (int)values[0];
//		
//		super.setValues( new double[] { 
//				values[1],
//				values[2]
//			});	
//	}
	
	private double distance(Mass mass)
	{
		switch(myID)
		{	
		case 1: return mass.getY();  //top
		case 2: return myBounds.getWidth() - mass.getX(); //right
		case 3: return myBounds.getHeight() - mass.getY(); //bottom
		case 4: return mass.getX(); //left
		default: break;
		}
		return 0;
	}
	
	@Override
	public void applyForce(Mass mass)
	{
		initializeVectorMap();
		double distFromWall = distance(mass)/50; //need an offset?
		Vector v = myVectors.get(myID);
		v.setMagnitude(v.getMagnitude()/distFromWall);
		mass.applyForce(v); //?? 
		
		//mass.applyForce(new Vector(angle, magnitude));
	}
	
}
