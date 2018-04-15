package org.usfirst.frc.team5030.robot;

import java.lang.annotation.AnnotationFormatError;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SplineDrive extends Command {
	
	private double throttle, targetDistance , rotation , angle  , startAngle , stopAngle  , currentAngle , angleDifference , remainingDistance , currentDistance;
	private char direction;
	private boolean isLeft = false , terminate = false;

    public SplineDrive(double ArcLength , double Angle , char Direction) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
        targetDistance = ArcLength;
        angle = Angle;
        direction = Direction;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.EncReset();
    	Robot.drivetrainSubsystem.configIMU();
    	
    	startAngle = Robot.drivetrainSubsystem.getGyroAngle();
		
    	if(direction == 'L' || direction == 'l')
    	{
    		isLeft = true;
    		stopAngle = startAngle - angle;
    	}
    	else if(direction == 'R' || direction == 'r')
    	{
    		isLeft = false;
    		stopAngle = startAngle + angle;
    	}
    	else
    	{
    		System.out.println("Incorrect Direction, Killing");
    		terminate = true;
    	}
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	currentAngle = Robot.drivetrainSubsystem.getGyroAngle();
    	angleDifference = Math.abs(stopAngle - currentAngle);
    	
    	currentDistance = Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage();
    	remainingDistance = targetDistance - currentDistance;
    	
    	if(isLeft)
    	{
    		//Decide Multiplier based on remaining value
    		 if(angleDifference > 25){
          		 rotation = -0.575;
          	 }else if (angleDifference > 5 && angleDifference <= 35){
          		 rotation = -0.45;
          	 }else{
          		 rotation = 0;
          	 }	
    		
    		if(remainingDistance > 20){ 
    			throttle = 0.75; 
    		}else if(remainingDistance < 20 && remainingDistance > 5){ 
    			throttle = 0.45; 
    		}else {
    			 
    			throttle = 0; 
    		}
    		
    		System.out.println("Left");
    	}
    	else if(!isLeft)
    	{
    		//Decide Multiplier based on remaining value
    		 if(angleDifference > 25){
          		 rotation = 0.575;
          	 }else if (angleDifference > 5 && angleDifference <= 35){
          		 rotation = 0.35;
          	 }else{
          		 rotation = 0;
          	 }	
    			
    		
    		if(remainingDistance > 20){ 
    			 throttle = 0.7; 
    	    }else if(remainingDistance < 20 && remainingDistance > 5){ 
    	    	throttle = 0.45; 
    	    }else {
    	    	throttle = 0; 
    	    }
    		
    		System.out.println("R");
    	}
    	else
    	{
    		terminate = true;
    	}
   
    		System.out.println("Throttle " + throttle); 
    		System.out.println("Rotatio " + rotation);
    		System.out.println("Angle Difference " + angleDifference);
    		Robot.drivetrainSubsystem.ArcadeDrive(throttle, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(terminate)
        {
        	System.out.println("Program Terminated");	
        	return true;	
        }
        else
    	{
        	return angleDifference < 5;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrainSubsystem.ArcadeDrive(0.0 , 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
