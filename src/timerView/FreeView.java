package timerView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FreeView extends JFrame {
	
	public static final String bS = "Ω√¿€";
	public static final String bP = "¡§¡ˆ";
	public static final String bN = "¢∫";
	public static final String bF = "¢∏";
	
	private JLabel dName[];
	
	private JButton bStart,bStart1, bPause,bPause1, bNext,bNext1, bFormer,bFormer1;
	private JPanel fPane, mPane, pTime[], pButtons, pName[];
	private JLabel[] lMinute, lSecond, lMilli, l1, l2;
	private JLabel ll;
	
	private GridBagLayout gbl,gbl1;
	private GridBagConstraints gbc,gbc1;
	
	private Font f1 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,250);
	private Font f2 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,150);
	private Font f3 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,50);
	private Font f4 = new Font("-¿±∞ÌµÒ320",Font.PLAIN,100);
	
	private CardLayout card;
	
	public FreeView(){
		Init();
	}
	
	private void Init(){
		InitButtons();
		InitLabels();
		InitPanels();
		InitFrame();
	}
	
	private void InitButtons(){
		bStart = new JButton(bS);
		bStart.setFont(f3);
		bStart.setBackground(new Color(130,180,255));
		bStart.setBorderPainted(false);
		
		bStart1 = new JButton(bS);
		bStart1.setFont(f3);
		bStart1.setBackground(new Color(130,180,255));
		bStart1.setBorderPainted(false);
		
		bPause = new JButton(bP);
		bPause.setFont(f3);
		bPause.setBackground(new Color(255,100,100));
		bPause.setBorderPainted(false);
		
		bPause1 = new JButton(bP);
		bPause1.setFont(f3);
		bPause1.setBackground(new Color(255,100,100));
		bPause1.setBorderPainted(false);
		
		bNext = new JButton(bN);
		bNext.setFont(f3);
		bNext.setBackground(new Color(245,245,245));
		bNext.setBorderPainted(false);
		
		bNext1 = new JButton(bN);
		bNext1.setFont(f3);
		bNext1.setBackground(new Color(245,245,245));
		bNext1.setBorderPainted(false);
		
		bFormer = new JButton(bF);
		bFormer.setFont(f3);
		bFormer.setBackground(new Color(245,245,245));
		bFormer.setBorderPainted(false);
		
		bFormer1 = new JButton(bF);
		bFormer1.setFont(f3);
		bFormer1.setBackground(new Color(245,245,245));
		bFormer1.setBorderPainted(false);
	}
	
	private void InitLabels(){
		dName = new JLabel[3];
		for( int i = 0; i<3; i++){
			dName[i] = new JLabel("≈‰∑–¿⁄"+(i+1));
		}
		dName[0].setFont(f2);
		dName[1].setFont(f3);
		dName[2].setFont(f3);
		
		lMinute = new JLabel[3];
		lSecond = new JLabel[3];
		lMilli = new JLabel[3];
		l1 = new JLabel[3];
		l2 = new JLabel[3];
		
		for(int i = 0; i<3; i++){
			lMinute[i] = new JLabel("00",JLabel.CENTER);
			lSecond[i]= new JLabel("00",JLabel.CENTER);
			lMilli[i] = new JLabel("00",JLabel.CENTER);
			l1[i] = new JLabel(":",JLabel.CENTER);
			l2[i] = new JLabel(".",JLabel.CENTER);		
					
			lMinute[i].setFont(f4);
			lSecond[i].setFont(f4);
			lMilli[i].setFont(f4);
			l1[i].setFont(f4);
			l2[i].setFont(f4);
			
		}
		lMinute[0].setFont(f1);
		lSecond[0].setFont(f1);
		lMilli[0].setFont(f1);
		l1[0].setFont(f1);
		l2[0].setFont(f1);
		
		
		ll = new JLabel(" ");
		ll.setFont(f2);
	}
	
	private void InitPanels(){
		fPane = new JPanel();
		mPane = new JPanel();
		pButtons = new JPanel();
		pTime = new JPanel[4];
		pName = new JPanel[2];
		for(int i=0; i<2; i++){
			pTime[i] = new JPanel();
			pName[i] = new JPanel();
		}
		
		gbl = new GridBagLayout();
		gbl1 = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		mPane.setLayout(gbl);
		
		pName[0].add(dName[0]);
		pName[0].setBackground(Color.WHITE);
		
		pTime[0].setLayout(gbl);
		pTime[0].add(lMinute[0]);
		pTime[0].add(l1[0]);
		pTime[0].add(lSecond[0]);
		pTime[0].add(l2[0]);
		pTime[0].add(lMilli[0]);
		pTime[0].setBackground(Color.WHITE);
		
		pButtons.add(bFormer);
		pButtons.add(bStart);
		pButtons.add(bPause);
		pButtons.add(bNext);
		
		addGrid(mPane, gbl, gbc, pName[0],0,0,4,1,0,0);
		addGrid(mPane,gbl,gbc,pTime[0],0,1,4,1,0,8);
		addGrid(mPane,gbl,gbc,bFormer1,0,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bStart1,1,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bPause1,2,2,1,1,1,1);
		addGrid(mPane,gbl,gbc,bNext1,3,2,1,1,1,1);
		
		
		/*Free panel*/
		fPane.setLayout(gbl1);
		pTime[1].setLayout(new GridLayout(1,2));
		pName[1].setLayout(new GridLayout(1,2));
		
		pName[1].setLayout(gbl1);
		//gbc.anchor = GridBagConstraints.CENTER;
		addGrid(pName[1],gbl1,gbc,dName[1],0,0,1,1,0,0);
		addGrid(pName[1],gbl1,gbc,dName[2],1,0,1,1,0,0);
		//pName[1].add(dName[1]);
		//pName[1].add(dName[2]);
		pName[1].setBackground(Color.WHITE);
		
		pTime[1].setLayout(gbl1);
		pTime[1].add(lMinute[1]);
		pTime[1].add(l1[1]);
		pTime[1].add(lSecond[1]);
		pTime[1].add(l2[1]);
		pTime[1].add(lMilli[1]);
		
		pTime[1].add(ll);
		
		pTime[1].add(lMinute[2]);
		pTime[1].add(l1[2]);
		pTime[1].add(lSecond[2]);
		pTime[1].add(l2[2]);
		pTime[1].add(lMilli[2]);
		pTime[1].setBackground(Color.WHITE);
		
		addGrid(fPane, gbl1, gbc, pName[1],0,0,4,1,0,0);
		addGrid(fPane,gbl1,gbc,pTime[1],0,1,4,1,0,8);
		addGrid(fPane,gbl1,gbc,bFormer,0,2,1,1,1,1);
		addGrid(fPane,gbl1,gbc,bStart,1,2,1,1,1,1);
		addGrid(fPane,gbl1,gbc,bPause,2,2,1,1,1,1);
		addGrid(fPane,gbl1,gbc,bNext,3,2,1,1,1,1);
	}
	
	private void InitFrame(){
		card = new CardLayout();
		setLayout(card);
		
		add("Ceda",mPane);
		add("Free",fPane);
		//add(mPane);
		setSize(1400,800);
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tik = getToolkit();
		int x = (tik.getScreenSize().width/2) - (getSize().width/2);
		int y = (tik.getScreenSize().height/2) - (getSize().height/2);
		setLocation(x, y);
		
		setVisible(true);
	}
	
	public void addButtonListener(ActionListener actionListener){
		bStart.addActionListener(actionListener);
		bPause.addActionListener(actionListener);
		bNext.addActionListener(actionListener);
		bFormer.addActionListener(actionListener);
		
		bStart1.addActionListener(actionListener);
		bPause1.addActionListener(actionListener);
		bNext1.addActionListener(actionListener);
		bFormer1.addActionListener(actionListener);
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
	
	public void setName(int i,String name){
		dName[i].setText(name);
		repaint();
	}
	
	public void setTime(int i,int minute, int second, int milli){
		lMinute[i].setText(String.format( "%02d", minute));
		lSecond[i].setText(String.format("%02d",second));
		lMilli[i].setText(String.format("%02d",milli));
		repaint();
		
	}
	
	public void setTC(int i, int num){
		if (i ==1){
			lMinute[num].setForeground(Color.yellow);
			lSecond[num].setForeground(Color.yellow);
			lMilli[num].setForeground(Color.yellow);
		}else if (i ==2){
			lMinute[num].setForeground(Color.red);
			lSecond[num].setForeground(Color.red);
			lMilli[num].setForeground(Color.red);
		}else if (i ==3){
			lMinute[num].setForeground(Color.BLACK);
			lSecond[num].setForeground(Color.BLACK);
			lMilli[num].setForeground(Color.BLACK);
		}
		
	}
	
	public void showPane(Container con, String name){
		card.show(con, name);
	}
	
	public void setBSf(){
		bStart.setEnabled(false);
		bStart1.setEnabled(false);
	}
	
	public void setBSe(){
		bStart.setEnabled(true);
		bStart1.setEnabled(true);
	}
	
	public void setBPf(){
		bPause.setEnabled(false);
		bPause.setEnabled(false);
	}
	
	public void setBPe(){
		bPause.setEnabled(true);
		bPause.setEnabled(true);
	}
}
