package timerView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NameView extends JPanel {
	
	public static final String CHOICE_CEDA = "CEDA";
	public static final String CHOICE_FREE = "FREE";
	
	private String CorF;
	private int dNum;
	
	private JPanel namePane;
	private JPanel timePane;
	
	private JTextField[] nDebators;
	private JTextField[] nTime;
	private JLabel PnC;
	private JLabel lTime;
	private JButton ok, cancel;
	
	private Font f1 = new Font("-윤고딕320",Font.PLAIN,50);
	private Font f2 = new Font("-윤고딕310",Font.PLAIN,40);
	
	public NameView(int num, String CorF){
		Initialization(num,CorF);
	}
	
	private void Initialization(int num,String CorF){
		InitializationButtons();
		InitializationLabels();
		InitializationTextFields(num, CorF);
		InitializationPanel();
	}
	
	private void InitializationButtons(){
		ok = new JButton("확인");
		ok.setFont(f1);
		ok.setBackground(new Color(153,204,255));
		cancel = new JButton("취소");
		cancel.setFont(f1);
		cancel.setBackground(new Color(255,124,128));
	}
	
	private void InitializationLabels(){
	
		PnC = new JLabel("이름", JLabel.CENTER);
		PnC.setFont(f1);
		PnC.setBackground(Color.WHITE);
		PnC.setOpaque(true);
		
		lTime = new JLabel("시간", JLabel.CENTER);
		lTime.setFont(f1);
		lTime.setBackground(Color.WHITE);
		lTime.setOpaque(true);

	}
	
	private void InitializationTextFields(int num,String CorF){
		dNum = num;
		this.CorF = CorF;
		if(dNum ==2){
			nDebators = new JTextField[4];
			nDebators[0] = new JTextField("찬성1");
			nDebators[1] = new JTextField("찬성2");
			nDebators[2] = new JTextField("반대1");
			nDebators[3] = new JTextField("반대2");
		}else if (dNum ==3){
			nDebators = new JTextField[6];
			nDebators[0] = new JTextField("찬성1");
			nDebators[1] = new JTextField("찬성2");
			nDebators[2] = new JTextField("찬성3");
			nDebators[3] = new JTextField("반대1");
			nDebators[4] = new JTextField("반대2");
			nDebators[5] = new JTextField("반대3");
		}
		if(this.CorF == CHOICE_CEDA){
			nTime = new JTextField[3];
			nTime[0] = new JTextField("4");
			nTime[1] = new JTextField("3");
			nTime[2] = new JTextField("3");
			
		}
		else if(this.CorF == CHOICE_FREE){
			nTime = new JTextField[3];
			nTime[0] = new JTextField("1");
			nTime[1] = new JTextField("8");
			nTime[2] = new JTextField("1");
		}
		
		for(int i = 0; i<dNum*2;i++){
			nDebators[i].setFont(f2);
		}
		for (int i = 0; i<nTime.length;i++){
			nTime[i].setFont(f2);
		}
	}
	
	private void InitializationPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		namePane = new JPanel();
		namePane.setSize(200,300);
		timePane = new JPanel();
		
		if(dNum ==2){
			namePane.setLayout(new GridLayout(2,2));
			namePane.add(nDebators[0]);
			namePane.add(nDebators[2]);
			namePane.add(nDebators[1]);
			namePane.add(nDebators[3]);
		}else if(dNum ==3){
			namePane.setLayout(new GridLayout(3,2));
			namePane.add(nDebators[0]);
			namePane.add(nDebators[3]);
			namePane.add(nDebators[1]);
			namePane.add(nDebators[4]);
			namePane.add(nDebators[2]);
			namePane.add(nDebators[5]);
		}
		
		if(this.CorF ==CHOICE_CEDA){
			timePane.setLayout(new GridLayout(1,3));
			timePane.add(nTime[0]);
			timePane.add(nTime[1]);
			timePane.add(nTime[2]);
		}else if(this.CorF ==CHOICE_FREE){
			timePane.setLayout(new GridLayout(1,3));
			timePane.add(nTime[0]);
			timePane.add(nTime[1]);
			timePane.add(nTime[2]);
		}
		
		setLayout(gbl);
		
		addGrid(gbl,gbc,PnC,0,0,2,1,0,0);
		addGrid(gbl,gbc,namePane,0,1,2,3,1,3);
		addGrid(gbl,gbc,lTime,0,4,2,1,0,0);
		addGrid(gbl,gbc,timePane,0,5,2,1,1,1);
		addGrid(gbl,gbc,ok,0,6,1,2,1,0);
		addGrid(gbl,gbc,cancel,1,6,1,2,1,0);
		setVisible(true);
	}
	
	 private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c,  
             int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
       gbc.gridx = gridx;
       gbc.gridy = gridy;
       gbc.gridwidth = gridwidth;
       gbc.gridheight = gridheight;
       gbc.weightx = weightx;
       gbc.weighty = weighty;
       gbl.setConstraints(c, gbc);
       add(c);
 }
	 
	 public String getdName(int i){
		 return nDebators[i].getText();
	 }
	 
	 public long getdTime(int i){
		 return Integer.parseInt(nTime[i].getText());
	 }
	 
	 public void setButtonListener(ActionListener actionListener){
		 ok.addActionListener(actionListener);
		 cancel.addActionListener(actionListener);
	 }
}
