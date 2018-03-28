package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceMaintainHeader extends Command {

	private double targetDistance , power , timeOut , currentAngle , currentDistance , startAngle , rotation , remainingDistance;
	
	protected Timer timer = new Timer();
	
    public DriveDistanceMaintainHeader(double DistanceInches , double Power , double TimeOut) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivetrainSubsystem);
        
    	targetDistance = DistanceInches;
    	power = Power;
    	timeOut = TimeOut;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetDistance = targetDistance * Math.signum(power);
    	
    	startAngle = Robot.drivetrainSubsystem.getGyroAngle();
    	
    	Robot.drivetrainSubsystem.EncReset();
    	Robot.drivetrainSubsystem.configIMU();
    
    	System.out.println("Remaining Distance " + remainingDistance); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	currentAngle = Robot.drivetrainSubsystem.getGyroAngle();
    	
    	currentDistance = Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage();
    	
    	remainingDistance = targetDistance - currentDistance;
    	
       	 if (currentAngle > startAngle + 15){
       		 rotation = -0.25;
       	 }else if (currentAngle > startAngle + 5){
       		 rotation = -0.15;
       	 }else if (currentAngle < startAngle - 5){
       		 rotation = 0.15;
       	 }else if (currentAngle < startAngle - 15){
       		 rotation = 0.25;
       	 }else{
       		 rotation = 0;
       	 }	 
       	 
       	 Robot.drivetrainSubsystem.ArcadeDrive(power, 0);
       	
       	System.out.println("current avg " + Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage());
       	System.out.println("Remaining Distance " + remainingDistance); 
       	System.out.println("Rotation " + rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
    	return Math.abs(remainingDistance) < 10.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.drivetrainSubsystem.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
