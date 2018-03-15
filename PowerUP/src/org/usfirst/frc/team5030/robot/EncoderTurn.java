package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderTurn extends Command {

	private double speed;
	private double distance;
	private boolean turnFinished = false;
	
	public EncoderTurn(double DistanceInches , double RotationSpeed)
	{
		speed = RotationSpeed;
		distance = DistanceInches;
	}
	
	protected void initialize()
	{
		Robot.drivetrainSubsystem.EncReset();
	}
	
	protected void execute()
	{
		if(speed > 0)
		{
			if((Robot.robotmap.FL.getSelectedSensorPosition(0) * Robot.kEncoderConversion) < distance)
			{
				Robot.drivetrainSubsystem.ArcadeDrive(0.0, speed);
				System.out.println("Turning Right");
				turnFinished = false;
			}
			else
			{
				turnFinished = true;
			}
		}
		else if(speed < 0)
		{
			if((Robot.robotmap.FR.getSelectedSensorPosition(0) * Robot.kEncoderConversion) < distance)
			{
				Robot.drivetrainSubsystem.ArcadeDrive(0.0, speed);
				System.out.println("Turning Left");
				turnFinished = false;
			}
			else
			{
				turnFinished = true;
			}
		
		}
		else
		{
			Robot.drivetrainSubsystem.AllStop();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return turnFinished;
	}
	
	protected void end()
	{
		Robot.drivetrainSubsystem.AllStop();
	}
	
	protected void interrupted()
	{
		Robot.drivetrainSubsystem.AllStop();
	}
	
	

	
	
}
