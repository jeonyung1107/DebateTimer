package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import routedeventhendler.StopwatchTickListener;
import timerView.CedaView;
import timerView.FreeView;
import view.components.TimerButtons;

public class FreeControl {

	private Adapter[] mAdapter;
	private FreeView mFreeView;
	
	private Thread mT;
	
	private int orderNum;//Adapter 불러올 때 쓸 매개변수, 숫자에 해당하는 Adapter 사용
	
	public FreeControl(long[] dTime, String[] dName){
		initialization(dTime, dName);
		mT = new Thread(mAdapter[orderNum]);
		//System.out.print(String.valueOf(mAdapter[orderNum].getMinute()));
		mFreeView.setTime(orderNum,mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
		mFreeView.setName(orderNum,mAdapter[orderNum].getdName());
		//mFreeView.showPane(mFreeView.getContentPane(), "Free");
		
		System.out.println(dName[0]);
		System.out.println(dName[1]);
		
	}
	
	private void initialization(long[] dTime, String[] dName){
		orderNum = 0;//
		mAdapter = new Adapter[6];
		
		mAdapter[0] = new Adapter(dTime[0], "찬성 기조연설");
		mAdapter[1] = new Adapter(dTime[0], "반대 기조연설");
		mAdapter[2] = new Adapter(dTime[1], dName[0]);	
		mAdapter[3] = new Adapter(dTime[1], dName[1]);
		mAdapter[4] = new Adapter(dTime[2], "반대 마무리");
		mAdapter[5] = new Adapter(dTime[2], "찬성 마무리");
			
		for(int i = 0; i<6;i++){
			mAdapter[i].interval = 10;
			mAdapter[i].onTick(mTickListener);
		}
		
		mFreeView = new FreeView();
		mFreeView.addButtonListener(mButtonListener);
	}
	
private ActionListener mButtonListener = new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == FreeView.bP){
				mAdapter[orderNum%6].stop();
				mT.interrupt();
				
			}else if(e.getActionCommand() ==FreeView.bS){
				mT = new Thread(mAdapter[orderNum%6]);
				mAdapter[orderNum%6].start();
				mT.start();

			}
			else if(e.getActionCommand() == FreeView.bN){
				int i = orderNum;
				mAdapter[orderNum%6].stop();
				mT.interrupt();
				orderNum = (orderNum+1)%6;
				System.out.println(orderNum);
				if (orderNum%6 ==2 || orderNum%6 ==3){
					mFreeView.showPane(mFreeView.getContentPane(),"Free");
				}else{
					mFreeView.showPane(mFreeView.getContentPane(),"Ceda");
				}
				if(orderNum%6 ==3 || orderNum%6 ==2){
					mFreeView.setTime(2,mAdapter[3].getMinute(),mAdapter[3].getSecond(),mAdapter[3].getMilli());
					mFreeView.setName(2,mAdapter[3].getdName());
					
					mFreeView.setTime(1,mAdapter[2].getMinute(),mAdapter[2].getSecond(),mAdapter[2].getMilli());
					mFreeView.setName(1,mAdapter[2].getdName());
					if(i!=1){
						mT = new Thread(mAdapter[orderNum%6]);
						mAdapter[orderNum].start();
						mT.start();
					}
					
					
				}else{
					mFreeView.setTime(0,mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
					mFreeView.setName(0,mAdapter[orderNum].getdName());
				}
				if (mAdapter[orderNum].getTimeShow() <30000){
					mFreeView.setTC(2,0);
					mFreeView.setTC(2,1);
					mFreeView.setTC(2,2);
				}else if(mAdapter[orderNum].getTimeShow()>=30000 && mAdapter[orderNum].getTimeShow()<60000){
					mFreeView.setTC(1,0);
					mFreeView.setTC(1,1);
					mFreeView.setTC(1,2);
				}else if(mAdapter[orderNum].getTimeShow()>=60000){
					mFreeView.setTC(3,0);
					mFreeView.setTC(3,1);
					mFreeView.setTC(3,2);
				}
			}else if(e.getActionCommand() == CedaView.bF){
				int i = orderNum;
				mAdapter[orderNum%6].stop();
				mT.interrupt();
				if(orderNum>0){
					orderNum--;
				}else if(orderNum ==0){
					orderNum = 5;
				}
				if (orderNum%6 ==2 || orderNum%6 ==3){
					mFreeView.showPane(mFreeView.getContentPane(),"Free");
				}else{
					mFreeView.showPane(mFreeView.getContentPane(),"Ceda");
				}
				if(orderNum%6 ==3 || orderNum%6 ==2){
					mFreeView.setTime(2,mAdapter[3].getMinute(),mAdapter[3].getSecond(),mAdapter[3].getMilli());
					mFreeView.setName(2,mAdapter[3].getdName());
					
					mFreeView.setTime(1,mAdapter[2].getMinute(),mAdapter[2].getSecond(),mAdapter[2].getMilli());
					mFreeView.setName(1,mAdapter[2].getdName());
					if(i!=4){
						mT = new Thread(mAdapter[orderNum%6]);
						mAdapter[orderNum].start();
						mT.start();
					}
					
				}else{
					mFreeView.setTime(0,mAdapter[orderNum].getMinute(),mAdapter[orderNum].getSecond(),mAdapter[orderNum].getMilli());
					mFreeView.setName(0,mAdapter[orderNum].getdName());
				}
				if (mAdapter[orderNum].getTimeShow() <30000){
					mFreeView.setTC(2,0);
					mFreeView.setTC(2,1);
					mFreeView.setTC(2,2);
				}else if(mAdapter[orderNum].getTimeShow()>=30000 && mAdapter[orderNum].getTimeShow()<60000){
					mFreeView.setTC(1,0);
					mFreeView.setTC(1,1);
					mFreeView.setTC(1,2);
				}else if(mAdapter[orderNum].getTimeShow()>=60000){
					mFreeView.setTC(3,0);
					mFreeView.setTC(3,1);
					mFreeView.setTC(3,2);
				}
			}
		}
	};
	
	private StopwatchTickListener mTickListener = new StopwatchTickListener(){
		public void actionTick(long timeRemain){
			int q = 0;
			int milli = (int)(timeRemain * 0.1) % 100;
			int second = (int)(timeRemain *0.001) % 60;
			int minute = (int)(timeRemain *0.001/60)%60;
			if (orderNum ==2){
				q = 1;
			}else if (orderNum ==3){
				q = 2;
			}
			
			mFreeView.setTime(q,minute, second, milli);
			
			if (timeRemain <30000){
				mFreeView.setTC(2,q);
			}else if(timeRemain>=30000 && timeRemain<60000){
				mFreeView.setTC(1,q);
			}
		}
	};
	
}

