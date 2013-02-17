package factory;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import simulation.Model;



/**
 * Reads in a data file and creates the specified forces
 * 
 * @author Ryan Fishel and Kevin Oh
 */


public class PhysicsFactory extends Factory {
	public static final int TOP_ID = 1;
	public static final int RIGHT_ID = 2;
	public static final int BOTTOM_ID = 3;
	public static final int LEFT_ID = 4;
	// data file keywords
	private static final String GRAVITY_KEYWORD = "gravity";
	private static final String VISCOSITY_KEYWORD = "viscosity";
	private static final String CENTERMASS_KEYWORD = "centermass";
	private static final String WALL_REPULSION = "wall";
	private static final String TOP_WALL = "top";
	private static final String BOTTOM_WALL = "bottom";
	private static final String RIGHT_WALL = "right";
	private static final String LEFT_WALL = "left";
	private Map<Integer, String> wallIDs = 
			new HashMap<Integer, String>();

	private Map<String, PhysicsCommand> physicsCreator = 
			new HashMap<String, PhysicsCommand>();

	/**
	 * initializes a map that maps the keyword of a force to the command that creates that force
	 */
	@Override
	public void initMaps() {
		physicsCreator.put(GRAVITY_KEYWORD, new GravityCommand());
		physicsCreator.put(VISCOSITY_KEYWORD, new ViscosityCommand());
		physicsCreator.put(CENTERMASS_KEYWORD, new CenterOfMassCommand());
		physicsCreator.put(WALL_REPULSION, new WallRepulsionCommand());
		
		wallIDs.put(TOP_ID, "top");
		wallIDs.put(RIGHT_ID, "right");
		wallIDs.put(BOTTOM_ID, "bottom");
		wallIDs.put(LEFT_ID, "left");
	}
	/**
	 * creates the specified force and adds it to the model
	 * @param model this is the model where the simulation takes place
	 * @param: line this is a Scanner which reads in lines from a data file
	 */
	@Override
	public void create(Model model, Scanner line) {
		if (line.hasNext()) {
			String type = line.next();
			if (physicsCreator.containsKey(type)) {
				String walltype = "";
				System.out.println("type: " + type);
				if (type.equals("wall")) {
					int wallId = line.nextInt();
					walltype = wallIDs.get(wallId);
					model.add(walltype, ((WallRepulsionCommand) physicsCreator.get(type))
							.returnForce(line, wallId));
				}         	
				else {
					model.add(type, physicsCreator.get(type).returnForce(line));
				}
			}
		}
	}





}
