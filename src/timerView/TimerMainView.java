package timerView;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.components.TimerButtons;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TimerMainView {
	private int dNum;
	private String CorF;
	
	private JFrame mFrame;
	private JPanel mPanel;
	private JPanel mCardPane;
	
	private JButton mCeda;
	private JButton mFree;
	private JButton mCustom;
	
	private CedaView mCedaView;
	private FreeView mFreeView;
	private NameView mNameView;
	
	private CardLayout card;
	
	private Font f1 = new Font("-윤고딕320",Font.PLAIN,90);
	
	public TimerMainView(){
		Initialization();
	}
	
	private void Initialization(){
		InitializationButtons();
		InitializationPanel();
		InitializationFrame();
	}
	
	private void InitializationFrame(){
		mFrame = new JFrame();
		
		card = new CardLayout();
		mFrame.setLayout(card);
		
		mFrame.getContentPane().add("Main", mPanel);
		
		mFrame.setTitle("SKFC 토론시계                                 by 20th 전예영");
		mFrame.setSize(400, 600);
		mFrame.setResizable(false);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tik = mFrame.getToolkit();
		int x = (tik.getScreenSize().width/2) - (mFrame.getSize().width/2);
		int y = (tik.getScreenSize().height/2) - (mFrame.getSize().height/2);
		mFrame.setLocation(x, y);
		
		mFrame.setVisible(true);
		//card.show(mFrame.getContentPane(),"Name");
	}
	
	private void InitializationPanel(){
		
		mPanel = new JPanel();
		mPanel.setVisible(true);
		mPanel.setLayout(new GridLayout(2,1));
		
		mPanel.add(mCeda);
		mPanel.add(mFree);
		
		//mPanel.add(mCustom); Custom은 추후 구현
	}
	
	private void InitializationButtons(){
		
		mCeda = new JButton(TimerButtons.MCEDA);
		mCeda.setFont(f1);
		mCeda.setBackground(new Color(153,204,255));
		mFree = new JButton(TimerButtons.MFREE);
		mFree.setFont(f1);
		mFree.setBackground(new Color(222,222,222));
		mCustom = new JButton(TimerButtons.MCUSTOM);
		mCustom.setFont(f1);
		mCustom.setBackground(new Color(153,255,204));
	}
	
	public void setButtonListener(ActionListener actionListener){
		mCeda.addActionListener(actionListener);
		mFree.addActionListener(actionListener);
		mCustom.addActionListener(actionListener);
	}
	
	public void setButton(ActionListener actionListener){
		mNameView.setButtonListener(actionListener);
	}
	
	public void addPane(){
		mNameView = new NameView(dNum,CorF);
		mFrame.getContentPane().add("Name", mNameView);
	}
	
	public String getdName(int i){
		String s;
		s = mNameView.getdName(i);
		return s;
	}
	
	public long getdTime(int i){
		long l;
		l = mNameView.getdTime(i);
		return l;
	}
	
	public void showPane(String name){
		card.show(mFrame.getContentPane(), name);
	}
	
	public void setCon(int num, String choice){
		this.dNum = num;
		this.CorF = choice;
	}
}