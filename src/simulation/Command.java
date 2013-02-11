package simulation;

import java.util.Scanner;

public interface Command {

	void getCommand();
}
//TODO: i dont know what to do. 

public class muscleCommand implements Command
{
	private Muscle getCommand(Scanner line) {
		Mass m1 = myMasses.get(line.nextInt());
		Mass m2 = myMasses.get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		double amplitude = line.nextDouble();

		return new Muscle(m1, m2, restLength, ks, amplitude);
	}

	@Override
	public void getCommand() {
		// TODO Auto-generated method stub
		
	}
}
	
	
	
