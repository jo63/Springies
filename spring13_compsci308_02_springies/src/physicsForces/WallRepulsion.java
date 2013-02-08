package physicsForces;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import simulation.Mass;
import util.Location;
import util.Vector;

public class WallRepulsion extends CenterOfMass {

	private double distanceFromWall;

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

	public WallRepulsion(int id, double magnitude, double exponent, Dimension bounds) {		
		super(magnitude, exponent);
		System.out.println(id);
		myID = id;
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
		myVectors = map;

	}
	private void distance(Mass mass)
	{
		switch(myID)
		{	
		case 1: distanceFromWall = mass.getY();  //top
		case 2: distanceFromWall = myBounds.getWidth() - mass.getX(); //right
		case 3: distanceFromWall = myBounds.getHeight() - mass.getY(); //bottom
		case 4: distanceFromWall = mass.getX(); //left
		default: break;
		}
	}

	@Override
	public Vector applyForce()
	{
		initializeVectorMap();
		double distFromWall = distanceFromWall/50; //need an offset?
		Vector v = myVectors.get(myID);
		v.setMagnitude(v.getMagnitude()/distFromWall);
		return v; 

		//mass.applyForce(new Vector(angle, magnitude));
	}

}
