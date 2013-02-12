package simulation;

import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;

public class buttonPresses {
	
    private static final JFileChooser INPUT_CHOOSER = 
	            new JFileChooser(System.getProperties().getProperty("user.dir"));
	 
	private Model mySimulation;
	
	private static final int LOAD_ASSEMBLY = KeyEvent.VK_N;
	private static final int CLEAR_ASSEMBLY = KeyEvent.VK_C;
	private static final int tOGGLE_GRAVITY = KeyEvent.VK_G;
	private static final int TOGGLE_VISCOSITY = KeyEvent.VK_V;
	private static final int TOGGLE_CENTER_OF_MASS = KeyEvent.VK_M;
	private static final int TOGGLE_WALL_ONE = KeyEvent.VK_1;
	private static final int TOGGLE_WALL_TWO = KeyEvent.VK_2;
	private static final int TOGGLE_WALL_THREE = KeyEvent.VK_3;
	private static final int TOGGLE_WALL_FOUR = KeyEvent.VK_4;
	
	
	
	public buttonPresses()
	{
		
	}
	
	public void update()
	{
		
	}
	
	private void loadModel () {
        SpriteFactory factory = new SpriteFactory();
        int response = INPUT_CHOOSER.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
        	response = INPUT_CHOOSER.showOpenDialog(null);
            factory.loadModel(mySimulation, INPUT_CHOOSER.getSelectedFile());
            
        }
       
    }
}
