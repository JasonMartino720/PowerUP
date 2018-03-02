package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.MotionProfiles.Test1;
import com.ctre.phoenix.motion.*;

import edu.wpi.first.wpilibj.command.Command;

//TODO Switch to MAG Encoder
//TODO Fix KNUMPOINTS
//TODO Make it run
public class AUTO_ExecuteMotionProfile extends Command {
	
	private int kNumPoints = 45;
	private int i = 0;
	
	private boolean profileFinished = false;

	private TrajectoryPoint LPoint = new TrajectoryPoint();
	private TrajectoryPoint RPoint = new TrajectoryPoint();
	
	private MotionProfileStatus MPStatus = new MotionProfileStatus();
	private SetValueMotionProfile MPValue = SetValueMotionProfile.Disable;
	
    public AUTO_ExecuteMotionProfile() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.EncReset();
    	Robot.drivetrainSubsystem.ClearMotionProfiles();
    	//Robot.drivetrainSubsystem.ConifgMagEncoder();
    	
    	Robot.robotmap.FL.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.FR.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	
    	Robot.robotmap.FL.configMotionProfileTrajectoryPeriod(10, 10);
    	
    	System.out.println("Set");
    	System.out.println(this.kNumPoints);
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  
    	if (i < this.kNumPoints) 
    	{
    		double LPos = Test1.leftProfilePosition[i];
			double RPos = Test1.rightProfilePosition[i];
			
			double LV = Test1.leftProfileVelocity[i];
			double RV = Test1.rightProfileVelocity[i];
			
			
			
			/* for each point, fill our structure and pass it to API 
			LPoint.position = LPos * Robot.drivetrainSubsystem.kSensorUnitsPerRotation; //Convert Revolutions to Units
			RPoint.position = RPos * Robot.drivetrainSubsystem.kSensorUnitsPerRotation; //Convert Revolutions to Units
			
			LPoint.velocity = LV * Robot.drivetrainSubsystem.kSensorUnitsPerRotation / 600.0; //Convert RPM to Units/100ms
			RPoint.velocity = RV * Robot.drivetrainSubsystem.kSensorUnitsPerRotation / 600.0;
			*/
			
			//point.profileSlotSelect0 = 0; /* which set of gains would you like to use [0,3]? */
			//point.profileSlotSelect1 = 0; /* future feature  - not used in this example - cascaded PID [0,1], leave zero */
			
			LPoint.timeDur = com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration.Trajectory_Duration_5ms;
			RPoint.timeDur = com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration.Trajectory_Duration_5ms;
			
			LPoint.zeroPos = false;
			if (i == 0)
				LPoint.zeroPos = true; /* set this to true on the first point */
			
			RPoint.zeroPos = false;
			if (i == 0)
				RPoint.zeroPos = true; /* set this to true on the first point */
			
			LPoint.isLastPoint = false;
			if ((i + 1) == this.kNumPoints)
				LPoint.isLastPoint = true; /* set this to true on the last point  */
			
			RPoint.isLastPoint = false;
			if ((i + 1) == this.kNumPoints)
				RPoint.isLastPoint = true; /* set this to true on the last point  */
			
			
			Robot.robotmap.FL.pushMotionProfileTrajectory(LPoint);
			Robot.robotmap.FR.pushMotionProfileTrajectory(RPoint);
			
			i++;
			System.out.println(i);
    	}
    	else
    	{
    		MPValue = SetValueMotionProfile.Enable;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         
    	
    	/*
        if((i+1) == this.kNumPoints)
        {
        	profileFinished = true;
        }
        
        return profileFinished;
        */
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.drivetrainSubsystem.AllStop();
    	System.out.println("Ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
