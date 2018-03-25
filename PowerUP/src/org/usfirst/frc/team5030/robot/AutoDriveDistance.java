package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.command.Command;

//TODO Decide on P Loop or direct speed

public class AutoDriveDistance extends Command 
{


	public boolean DrivingFinished = false;
	public double kSensorUnitsPerRotation = 1024;
	private double EncoderDrivingDistance;
	private double error;
	private double speed;
	private double setSpeed;
	private double rotation;
	private double leftEncPos;
	private double rightEncPos;
	private final double kP = 5;
	
    public AutoDriveDistance(double distanceInches, double Speed , double Rotation)
    {
    	EncoderDrivingDistance = distanceInches;
    	speed = Speed;
    	rotation = Rotation;
    }

    protected void initialize()
    {
    	Robot.drivetrainSubsystem.EncReset();
    }
    
    protected void execute()
    {
    	leftEncPos = Robot.robotmap.FL.getSelectedSensorPosition(0);
    	rightEncPos = Robot.robotmap.FR.getSelectedSensorPosition(0);
    	System.out.println("CurrentEncAvg " + Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage());
    	System.out.println("Target Distance " + EncoderDrivingDistance);
    	  	
    	//error = EncoderDrivingDistance - Robot.drivetrainSubsystem.CurrentEncoderPositionAverage();
    	//setSpeed = speed;
    	
    	if(Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage() < EncoderDrivingDistance)
    	{
    		Robot.drivetrainSubsystem.ArcadeDrive(-speed, rotation);
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
	
	protected void interrupted()
	{
		this.end();
	}
	
}
