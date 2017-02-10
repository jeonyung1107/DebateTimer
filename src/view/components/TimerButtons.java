package view.components;
import javax.swing.JButton;
public class TimerButtons extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MCEDA = "CEDA";
	public static final String MFREE = "자유토론";
	public static final String MCUSTOM = "마음대로";
	
	public TimerButtons(){
		super();
	}
	
	public TimerButtons(String text){
		super.setLabel(text);
	}
	
	public void setEnabled(boolean value){
		super.setEnabled(value);
	}
}
