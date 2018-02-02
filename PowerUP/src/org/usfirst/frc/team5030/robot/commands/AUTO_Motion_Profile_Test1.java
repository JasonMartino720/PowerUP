package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AUTO_Motion_Profile_Test1 extends Command {
	
	public static final int kNumPoints =185;	
	private int i;
	// Position (rotations)	Velocity (RPM)	Duration (ms)
	public static double [][]leftProfilePosition = new double[][]{		
	
	};

	public static double [][]rightProfilePosition = new double[][] {
		
	};
	
	public static double [][]leftProfileVelocity = new double[][]{		
		
	};

	public static double [][]rightProfileVelocity = new double[][] {
		
	};
	
	public static double [][]leftProfileTime = new double[][]{		
		
	};

	public static double [][]rightProfileTime = new double[][] {
		
	};
	
    public AUTO_Motion_Profile_Test1() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Set Encoder Type and Port
    	Robot.robotmap.FL.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.FR.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	
    	//Set Encoder Type
    	Robot.robotmap.FL.set(ControlMode.MotionProfile, 1);
    	Robot.robotmap.FR.set(ControlMode.MotionProfile, 1);
    	
    	//Clear Any Existing Trajectories
    	Robot.robotmap.FL.clearMotionProfileTrajectories();
    	Robot.robotmap.FR.clearMotionProfileTrajectories();
    	
    	Robot.robotmap.FL.config_kF(0,  , 5);
    	Robot.robotmap.FR.config_kF(0, arg1, 5)
    	
    	com.ctre.phoenix.motion.TrajectoryPoint LPoint = new com.ctre.phoenix.motion.TrajectoryPoint();
    	com.ctre.phoenix.motion.TrajectoryPoint RPoint = new com.ctre.phoenix.motion.TrajectoryPoint();
    	
    }

    // Called repeatedly when this Command is scheduled to run 
    protected void execute() {
    	
    	com.ctre.phoenix.motion.TrajectoryPoint LPoint = new com.ctre.phoenix.motion.TrajectoryPoint();
    	com.ctre.phoenix.motion.TrajectoryPoint RPoint = new com.ctre.phoenix.motion.TrajectoryPoint();
    	
    	for(i = 0; i < kNumPoints; i++)
    	{
    		LPoint.position = leftProfilePosition[i][0];
    		RPoint.position = rightProfilePosition[i][0];
    		
    		LPoint.velocity = leftProfileVelocity[i][1];
    		RPoint.velocity = rightProfileVelocity[i][1];
    		
    		LPoint. = (int)leftProfileTime[i][2];
    		RPoint.timeDurMs = (int)rightProfileTime[i][2];
    		
    		LPoint.profileSlotSelect0 = 0;
    		RPoint.profileSlotSelect0 = 0;
    		
    		LPoint.zeroPos = false;
    		RPoint.zeroPos = false; 
    		
    		if(i == 0) LPoint.zeroPos = true;
    		if(i == 0) RPoint.zeroPos = true;
    		
    		LPoint.isLastPoint = false;
    		RPoint.isLastPoint = false;
    		
    		if((i=0) == kNumPoints) LPoint.isLastPoint = true;
    		if((i=0) == kNumPoints) RPoint.isLastPoint = true;
    		
    		Robot.robotmap.FL.pushMotionProfileTrajectory(LPoint);
    		Robot.robotmap.FR.pushMotionProfileTrajectory(RPoint);
    		
    		
    	}
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
