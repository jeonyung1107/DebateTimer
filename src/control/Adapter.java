package control;

import java.util.EventListener;

import javax.swing.JLabel;

import routedeventhendler.StopwatchTickListener;

public class Adapter implements Runnable {
	
	private boolean mRun;
	private long mStartTime;
	private long mTimeSpan;
	private long mTimeRemain;
	private long mTimeShow;
	public int interval;
	private String dName;
	private long rT;
	
	private StopwatchTickListener mTickListener;
	
	public Adapter(long t,String dName){
		
		mRun = true;
		mStartTime = 0;
		mTimeSpan = 0;
		interval = 0;
		this.dName = dName;
		mTimeRemain = t*60000;
		mTimeShow = mTimeRemain;
		rT = t;
	}
	
	public void start(){
		mRun = true;
		mStartTime = System.currentTimeMillis() - mTimeSpan;
	}
	
	public void stop(){
		mRun = false;
	}
	
	public void reset(){
		mStartTime = 0;
		mTimeSpan = 0;
		mTimeRemain = rT*60000;
	}
	/* 시간 설정하는 함수*/
	
	public void run(){
		
		while(mRun){

			mTimeSpan = System.currentTimeMillis() - mStartTime;//지나간 시간 저장
			mTimeShow = mTimeRemain - mTimeSpan;
			
			if(mTimeSpan % interval ==0){
				mTickListener.actionTick(mTimeShow);
			}
		}
	}
	
	public void onTick(EventListener eventListener){
		mTickListener = (StopwatchTickListener)eventListener;
	}
	
	public int getMinute(){
		return (int)(mTimeShow*0.001/60)%60;
	}
	
	public int getSecond(){
		return (int)(mTimeShow*0.001) % 60;
		
	}
	
	public int getMilli(){
		return (int)(mTimeShow* 0.1) % 100;
	}
	
	public String getdName(){
		return dName;
	}
	
	public long getTimeSpan(){
		return mTimeSpan;
	}
	
	public long getTimeShow(){
		return mTimeShow;
	}
}
