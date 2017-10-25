package simulación;

 
import javax.swing.*;
import java.awt.*;
 
public class Chi_interfaz extends JFrame{
	
	Chi x;
 
    public Chi_interfaz() {
    	super("Prueba de la Uniformidad");
    	
    	Container c = getContentPane();
    	x = new Chi();
    	c.add(x);
    	
    	this.setVisible(true);
    	this.setSize(851, 514);
    	this.setLocation(100, 100);
    	this.setResizable(false);
    }
	
	public static void main(String args[]) {
		
		Chi_interfaz pU = new Chi_interfaz();
		pU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}