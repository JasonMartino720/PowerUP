package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveDistance extends Command 
{


	public boolean DrivingFinished = false;
	public double kSensorUnitsPerRotation = 1024;
	private double EncoderDrivingDistance;
	private double error;
	private double speed;
	private final double kP = 1.5;
	public static int kEncoderConversion = 54;
	
    public AutoDriveDistance(double distanceInches, double userSpeed)
    {
    	EncoderDrivingDistance = distanceInches * kEncoderConversion;
    	speed = userSpeed;

    }

    protected void initialize()
    {
    	Robot.drivetrainSubsystem.EncReset();
    }
    
    protected void execute()
    {
    	  	
    	if(Robot.robotmap.FL.getSelectedSensorPosition(1/1024) < EncoderDrivingDistance)
    	{
    		Robot.drivetrainSubsystem.ArcadeDrive(-speed, 0.0);
    		DrivingFinished = false;
    	}
    	else
    	{
    		Robot.drivetrainSubsystem.AllStop();
    		DrivingFinished = true;
    	}
    }
    
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return DrivingFinished;
	}
	
	protected void end()
	{
		Robot.drivetrainSubsystem.AllStop();
	}
	
}
