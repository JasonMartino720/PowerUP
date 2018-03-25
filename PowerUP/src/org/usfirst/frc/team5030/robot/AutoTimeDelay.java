package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoTimeDelay extends Command {

	private Timer timer = new Timer();
	private double time;
	private boolean finishedWaiting;
	
	
	public AutoTimeDelay(double TimeToDelay)
	{
		time = TimeToDelay;
	}
	
	protected void initialize()
	{
		timer.reset();
		timer.start();
	}
	
	protected void execute()
	{
		if(timer.get() < time)
		{
			finishedWaiting = false;
		}
		else
		{
			finishedWaiting = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finishedWaiting;
	}

	protected void end()
	{
		
	}
	
	
	
	
}
