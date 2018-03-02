package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AUTO_CrossLine extends Command {

    public AUTO_CrossLine() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.EncReset();
    	Robot.drivetrainSubsystem.ConifgMagEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrainSubsystem.ArcadeDrive(-0.75, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeSinceInitialized() < 4)
        {
        	return false;
        }
        else
        {
        	return true;
        }
        		
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrainSubsystem.AllStop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
