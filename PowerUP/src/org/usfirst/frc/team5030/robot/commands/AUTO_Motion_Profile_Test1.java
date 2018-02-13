package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import org.usfirst.frc.team5030.robot.commands.MotionProfiles.*;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team5030.robot.Instrumentation;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*TODO Make this work
	   Find a way to clear buffer
	   FInd a better way to enumerate org.usfirst.frc.team5030.robot.commands.MotionProfiles.*
*/
public class AUTO_Motion_Profile_Test1 extends Command {
	
	private int i;
	int kPoints = Test1.Points + 1;
	int kSensorUnitsPerRotation = 4096;
	
	public AUTO_Motion_Profile_Test1() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Set Encoder Type and Port
    	Robot.robotmap.FL.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.FR.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	
    	Robot.robotmap.FR.setInverted(true);
    	
    	//Set Talon Control Profiles
    	Robot.robotmap.FL.set(ControlMode.MotionProfile, 1);
    	Robot.robotmap.BL.follow(Robot.robotmap.FL);
    	
    	Robot.robotmap.FR.set(ControlMode.MotionProfile, 1);
    	Robot.robotmap.BR.follow(Robot.robotmap.FR);
    		
    	//Clear Any Existing Trajectories
    	Robot.robotmap.FL.clearMotionProfileTrajectories();
    	Robot.robotmap.FR.clearMotionProfileTrajectories();
    	System.out.println("cleared");
    	
    	Robot.robotmap.FL.config_kP(0, 0.5 , 5);
    	Robot.robotmap.FR.config_kP(0, 0.5 , 5);
    	
    	Robot.robotmap.FL.clearMotionProfileHasUnderrun(0);
    	Robot.robotmap.FR.clearMotionProfileHasUnderrun(0);
    	
    	Robot.robotmap.FR.configMotionProfileTrajectoryPeriod(10, 10);
    	Robot.robotmap.FL.configMotionProfileTrajectoryPeriod(10, 10);   	
    	
    	Robot.robotmap.BL.follow(Robot.robotmap.FL);
    	Robot.robotmap.BR.follow(Robot.robotmap.FR);
    	
    	    	
    }

    // Called repeatedly when this Command is scheduled to run 
    protected void execute() 
    {
    	
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
