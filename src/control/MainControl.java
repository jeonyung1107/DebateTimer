package control;

import routedeventhendler.StopwatchTickListener;
import timerView.*;
import view.components.*;

import view.components.TimerButtons;


import java.awt.event.*;

public class MainControl {
	private TimerMainView mMainView;
	
	private Adapter mAdapter;
	
	private Thread mThread;
	
	private CedaControl mCeda;
	private FreeControl mFree;
	
	private int dNum;
	private String CorF;
	
	private String dName[];
	private long dTime[];
	
	public MainControl(){
		initialization();
	}
	
	private void initialization(){
		
		/*Adapter는 일단 CEDA와 FREE 컨트롤에서 다루게 함*/
		/*mAdapter = new Adapter();
		mAdapter.interval = 10;
		mAdapter.onTick(mTickListener);*/
		
		mMainView = new TimerMainView();
		mMainView.setButtonListener(mButtonListener);

		
	}
	
	private ActionListener mButtonListener = new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == TimerButtons.MCEDA){
				dNum = 2;
				CorF = NameView.CHOICE_CEDA;
				mMainView.setCon(dNum,CorF);
				mMainView.addPane();
				mMainView.setButton(nButtonListener);
				mMainView.showPane("Name");
			}else if(e.getActionCommand() == TimerButtons.MFREE){
				dNum = 3;
				CorF = NameView.CHOICE_FREE;
				mMainView.setCon(dNum,CorF);
				mMainView.addPane();
				mMainView.setButton(nButtonListener);
				mMainView.showPane("Name");
			}/*else if(e.getActionCommand() == TimerButtons.MCUSTOM){
				
			}*/
		}
	};
	
	private ActionListener nButtonListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "확인"){
				
				if(CorF == NameView.CHOICE_CEDA){
					
					dName = new String[4];
					for (int i = 0; i<4;i++){
						dName[i] = mMainView.getdName(i);
					}
					dTime = new long[3];
					for(int i = 0; i<3;i++){
						dTime[i] = mMainView.getdTime(i);
					}
					mCeda = new CedaControl(dTime, dName);
					
				}else if(CorF == NameView.CHOICE_FREE){
					dName = new String[2];
					dName[0] = "";
					dName[1] = "";
					for (int i = 0; i<3; i++){
						
						dName[0]+= " " +mMainView.getdName(i);
						dName[1]+= " " +mMainView.getdName(3+i);
					}
					dTime = new long[3];
					for(int i = 0; i<3;i++){
						dTime[i] = mMainView.getdTime(i);
					}
					
					mFree = new FreeControl(dTime, dName);
					
				}
			}else if(e.getActionCommand() =="취소"){
				mMainView.showPane("Main");
			}
		}
	};
}
