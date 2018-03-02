package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {

private double targetAngle;
private double currentAngle;
private double error;
private double speed;
private final double kTolerance = 1; 
private final double kP = 1;


	public TurnToAngle(double TargetAngle, double Speed)
	{
		targetAngle = TargetAngle;
		speed = Speed;
	}
	
	protected void initialize()
	{
		Robot.drivetrainSubsystem.GyroReset();
	}
	
	protected void Execute()
	{
		currentAngle = Robot.robotmap.gyro.getAngle();
		System.out.println("Gyro " + currentAngle);
		error = targetAngle - currentAngle;
		speed = error / (kP / Math.abs(speed));
		
		if(speed > 1){
			speed = 1; }
		
		if(speed < -1) {
			speed = -1; }
		
		Robot.drivetrainSubsystem.ArcadeDrive(0.0, speed);
	}
	
	
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(targetAngle - currentAngle) < 3;
	
	}
	
	protected void end() {
    	System.out.println("DONE");
    	Robot.drivetrainSubsystem.AllStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrainSubsystem.AllStop();
    }
}
