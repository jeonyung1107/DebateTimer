package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import routedeventhendler.StopwatchTickListener;
import timerView.CedaView;
import view.components.TimerButtons;

public class CedaControl {
	
	private Adapter[] mAdapter;
	private Adapter[] mAdapter1;
	private CedaView mCedaView;
	
	private Thread mT;
	
	private int orderNum;//Adapter 불러올 때 쓸 매개변수, 숫자에 해당하는 Adapter 사용
	
	public CedaControl(long[] dTime, String[] dName){
		initialization(dTime, dName);
		mT = new Thread(mAdapter[orderNum]);
		mCedaView.setTime(mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
		mCedaView.setName(mAdapter[orderNum].getdName());
	}
	
	private void initialization(long[] dTime, String[] dName){
		orderNum = 0;//
		mAdapter = new Adapter[12];
		mAdapter1 = new Adapter[12];
		for(int i = 0 ; i<12; i++){
			if(i<4){
				mAdapter1[i] = new Adapter(dTime[0], dName[i%4]+" 입론");
			}else if(i>=4 &&i<8){
				mAdapter1[i] = new Adapter(dTime[1], dName[i%4]+" 교차조사");
			}else{
				mAdapter1[i] = new Adapter(dTime[2], dName[i%4]+" 반박");
			}
			
			mAdapter1[i].interval = 10;
			mAdapter1[i].onTick(mTickListener);
			
		}
		
		mAdapter[0] = mAdapter1[0];
		mAdapter[1] = mAdapter1[7];
		mAdapter[2] = mAdapter1[2];
		mAdapter[3] = mAdapter1[4];
	
		mAdapter[4] = mAdapter1[1];
		mAdapter[5] = mAdapter1[6];
		mAdapter[6] = mAdapter1[3];
		mAdapter[7] = mAdapter1[5];
		
		mAdapter[8] = mAdapter1[10];
		mAdapter[9] = mAdapter1[8];
		mAdapter[10] = mAdapter1[11];
		mAdapter[11] = mAdapter1[9];
		
		mCedaView = new CedaView();
		mCedaView.setButtonListener(mButtonListener);
		
	}
	
	private ActionListener mButtonListener = new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == CedaView.bP){
				mAdapter[orderNum%12].stop();
				mT.interrupt();
				//System.out.println(String.valueOf(mAdapter[orderNum].getTimeSpan()));
				//System.out.println(String.valueOf(mAdapter[orderNum].getTimeRemain()));
				
			}else if(e.getActionCommand() ==CedaView.bS){
				mT = new Thread(mAdapter[orderNum%12]);
				mAdapter[orderNum%12].start();
				mT.start();
			}
			else if(e.getActionCommand() == CedaView.bN){
				mAdapter[orderNum%12].stop();
				mT.interrupt();
				orderNum = (orderNum+1)%12;
				mCedaView.setTime(mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
				mCedaView.setName(mAdapter[orderNum].getdName());
				if (mAdapter[orderNum].getTimeShow() <30000){
					mCedaView.setTC(2);
				}else if(mAdapter[orderNum].getTimeShow()>=30000 && mAdapter[orderNum].getTimeShow()<60000){
					mCedaView.setTC(1);
				}else if(mAdapter[orderNum].getTimeShow()>=60000){
					mCedaView.setTC(3);
				}
			}else if(e.getActionCommand() == CedaView.bF){
				mAdapter[orderNum%12].stop();
				mT.interrupt();
				if(orderNum>0){
					orderNum--;
				}else if(orderNum ==0){
					orderNum = 11;
				}
				mCedaView.setTime(mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
				mCedaView.setName(mAdapter[orderNum].getdName());
				if (mAdapter[orderNum].getTimeShow() <30000){
					mCedaView.setTC(2);
				}else if(mAdapter[orderNum].getTimeShow()>=30000 && mAdapter[orderNum].getTimeShow()<60000){
					mCedaView.setTC(1);
				}else if(mAdapter[orderNum].getTimeShow()>=60000){
					mCedaView.setTC(3);
				}
				
			}
		}
	};
	
	/*private StopwatchTickListener mTickListener = new StopwatchTickListener(){
		public void actionTick(long timeRemain){
			
			int milli = (int)(timeRemain * 0.1) % 100;
			int second = (int)(timeRemain *0.001) % 60;
			int minute = (int)(timeRemain *0.001/60)%60;
			
			mCedaView.setTime(minute, second, milli);
			
			if (timeRemain <30000){
				mCedaView.setTC(2);
			}else if(timeRemain>=30000 && timeRemain<60000){
				mCedaView.setTC(1);
			}
		}
	};*/
	
	private StopwatchTickListener mTickListener = (long timeRemain) ->{
		int milli = (int)(timeRemain * 0.1) % 100;
		int second = (int)(timeRemain *0.001) % 60;
		int minute = (int)(timeRemain *0.001/60)%60;
		
		mCedaView.setTime(minute, second, milli);
		
		if (timeRemain <30000){
			mCedaView.setTC(2);
		}else if(timeRemain>=30000 && timeRemain<60000){
			mCedaView.setTC(1);
		}	};
}
