package simulation;


import java.util.Scanner;
import simulation.*;

import util.Sprite;

public abstract class SpriteCommand {
	private Factory myFactory;
	
	public SpriteCommand(Factory factory)
	{
		myFactory = factory;
	}
	
	public abstract Sprite getCommand(Scanner line);
	public Factory getFactory()
	{
		return myFactory;
	}
}


class muscleCommand extends SpriteCommand
{
	public muscleCommand(Factory factory)
	{
		super(factory);
	}
	
	@Override
	public Muscle getCommand(Scanner line) {
		Mass m1 = myMasses.get(line.nextInt());
		Mass m2 = myMasses.get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		double amplitude = line.nextDouble();

		return new Muscle(m1, m2, restLength, ks, amplitude);
	}

}


	
