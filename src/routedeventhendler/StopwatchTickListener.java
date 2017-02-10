package routedeventhendler;

import java.util.EventListener;

public interface StopwatchTickListener extends EventListener {
	
	public void actionTick(long timeSpan);
}
