package timerView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CedaViewPane extends JPanel {
	public static final String bS = "Ω√¿€";
	public static final String bP = "¡§¡ˆ";
	public static final String bN = "¢∫";
	public static final String bF = "¢∏";
	
	private JLabel dName;
	
	private JButton bStart, bPause, bNext, bFormer;
	private JPanel mPane, pTime, pButtons, pName;
	private JLabel lMinute, lSecond, lMilli, l1, l2;
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridLayout gl;
	
	private Font f1 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,350);
	private Font f2 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,150);
	private Font f3 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,80);
	private Font f4 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,300);
	public CedaViewPane(){
		Init();
	}
	
	private void Init(){
		InitButton();
		InitLabel();
		InitPane();
		InitFrame();
	}
	
	private void InitFrame(){
		add(mPane);
		setSize(1500,1000);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	private void InitButton(){
		bStart = new JButton(bS);
		bStart.setFont(f3);
		//bStart.setBackground(new Color(195,230,255));
		bStart.setBackground(new Color(130,180,255));
		bStart.setBorderPainted(false);
		bPause = new JButton(bP);
		bPause.setFont(f3);
		//bPause.setBackground(new Color(255,160,160));
		bPause.setBackground(new Color(255,100,100));
		bPause.setBorderPainted(false);
		bNext = new JButton(bN);
		bNext.setFont(f3);
		bNext.setBackground(new Color(245,245,245));
		bNext.setBorderPainted(false);
		bFormer = new JButton(bF);
		bFormer.setFont(f3);
		bFormer.setBackground(new Color(245,245,245));
		bFormer.setBorderPainted(false);
	}
	
	private void InitLabel(){
		dName = new JLabel("≈‰∑–¿⁄");
		dName.setFont(f2);
		lMinute = new JLabel("00",JLabel.CENTER);
		lMinute.setFont(f1);
		lSecond = new JLabel("00",JLabel.CENTER);
		lSecond.setFont(f1);
		lMilli = new JLabel("00",JLabel.CENTER);
		lMilli.setFont(f4);
		l1 = new JLabel(":",JLabel.CENTER);
		l1.setFont(f1);
		l2 = new JLabel(".",JLabel.CENTER);
		l2.setFont(f1);
	}
	
	private void InitPane(){
		
		mPane = new JPanel();
		pTime = new JPanel();
		pButtons = new JPanel();
		pName = new JPanel();
		
		gl = new GridLayout(3,1);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		mPane.setLayout(gbl);
		
		pName.add(dName);
		pName.setBackground(Color.WHITE);
		
		pTime.setLayout(gbl);
		pTime.add(lMinute);
		pTime.add(l1);
		pTime.add(lSecond);
		pTime.add(l2);
		pTime.add(lMilli);
		pTime.setBackground(Color.WHITE);
		
		pButtons.add(bFormer);
		pButtons.add(bStart);
		pButtons.add(bPause);
		pButtons.add(bNext);
		
		addGrid(mPane, gbl, gbc, pName,0,0,4,1,0,0);
		addGrid(mPane,gbl,gbc,pTime,0,1,4,1,0,8);
		//addGrid(mPane,gbl,gbc,pButtons,0,2,1,1,0,0);
		addGrid(mPane,gbl,gbc,bFormer,0,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bStart,1,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bPause,2,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bNext,3,2,1,1,1,1);
		
		gbc.fill = GridBagConstraints.NONE;
		addGrid(pTime,gbl,gbc,lMinute,0,0,2,1,0,0);
		addGrid(pTime,gbl,gbc,l1,1,0,1,1,0,0);
		addGrid(pTime,gbl,gbc,lSecond,2,0,2,1,0,0);
		addGrid(pTime,gbl,gbc,l2,3,0,1,1,0,0);
		gbc.anchor = GridBagConstraints.SOUTH;
		addGrid(pTime,gbl,gbc,lMilli,4,0,2,1,1,1);
		
	}
	
	 private void addGrid(JPanel pane, GridBagLayout gbl, GridBagConstraints gbc, Component c,  
             int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
       gbc.gridx = gridx;
       gbc.gridy = gridy;
       gbc.gridwidth = gridwidth;
       gbc.gridheight = gridheight;
       gbc.weightx = weightx;
       gbc.weighty = weighty;
       gbl.setConstraints(c, gbc);
       pane.add(c);
 }
	
	public void setButtonListener(ActionListener actionListener){
		bStart.addActionListener(actionListener);
		bPause.addActionListener(actionListener);
		bNext.addActionListener(actionListener);
		bFormer.addActionListener(actionListener);
	}
	
	public void setName(String name){
		dName.setText(name);
		repaint();
	}
	
	public void setTime(int minute, int second, int milli){
		lMinute.setText(String.format( "%02d", minute));
		lSecond.setText(String.format("%02d",second));
		lMilli.setText(String.format("%02d",milli));
		repaint();
		
	}
	
	public void setTC(int i){
		if (i ==1){
			lMinute.setForeground(Color.yellow);
			lSecond.setForeground(Color.yellow);
			lMilli.setForeground(Color.yellow);
		}else if (i ==2){
			lMinute.setForeground(Color.red);
			lSecond.setForeground(Color.red);
			lMilli.setForeground(Color.red);
		}
		
	}
}
