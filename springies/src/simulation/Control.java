package simulation;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashSet;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;

public class Control extends JComponent{
	
	    public static final int NO_KEY_PRESSED = -1;  
	    public static final int NO_MOUSE_PRESSED = -1;
	  
	    private int mouseClick = MouseEvent.BUTTON1;
	  
	    private int myLastKeyPressed;
	    private HashSet<Integer> myKeysPressed;
	    private Point myLastMousePosition;
	    
	    public Control()
	    {
	    	 setInputListeners(); // this should be in canvas?
	         myKeysPressed = new HashSet<Integer>();
	    }
	    
	    public HashSet<Integer> getLastKeyPressed () {
	        return myKeysPressed;
	    }
	    
	    public int getMouseButton()
	    {
	    	return mouseClick;
	    }
	    
	    public Point getLastMousePosition () {
	        return myLastMousePosition;
	    }
	    
	    //need action performed method? or should that be in canvas?
	    
	    private void setInputListeners () {
	        // initialize input state
	        myLastKeyPressed = NO_KEY_PRESSED;
	        addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed (KeyEvent e) {
	                myKeysPressed.add(e.getKeyCode());
	            }
	            @Override
	            public void keyReleased (KeyEvent e) {
	                myKeysPressed.remove(e.getKeyCode());
	            }
	        });
	        
	        myLastMousePosition = new Point();
	        addMouseMotionListener(new MouseMotionAdapter() {
	            @Override
	            public void mouseMoved (MouseEvent e) {
	                myLastMousePosition = e.getPoint();
	            }
	        });
	        mouseClick = MouseEvent.NOBUTTON;
	        addMouseListener(
	        		new MouseInputAdapter() {
	        			@Override
	        			public void mousePressed(MouseEvent e)
	        			{
	        				mouseClick = e.getButton();
	        			}
	        			
	        			@Override
	        			public void mouseReleased(MouseEvent e)
	        			{
	        				mouseClick = e.NOBUTTON;
	        			}	
					}
	        		);
	    }
	    
	    public boolean isKeyContained(int key)
	    {
	    	return myKeysPressed.contains(key);
	    }
	    

}
