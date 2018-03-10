package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TimedTurn extends Command {
	
	private boolean Finished = false;
	private double speed;
	private double time;
	
	public TimedTurn(double Speed, double Time)
	{
		speed = Speed;
		time = Time;
	}

	protected void initialize()
	{
		requires(Robot.drivetrainSubsystem);
		
	}
	
	protected void execute()
	{
		Robot.drivetrainSubsystem.ArcadeDrive(0, speed);
		Timer.delay(time);
		Finished = true;
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Finished;
	}
	
	protected void end()
	{
		Robot.drivetrainSubsystem.AllStop();
	}

	protected void interrupted()
	{
		end();
	}
}
