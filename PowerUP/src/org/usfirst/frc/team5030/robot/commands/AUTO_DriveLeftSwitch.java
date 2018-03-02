package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AUTO_DriveLeftSwitch extends Command {

	private boolean Turned = false;
	
    public AUTO_DriveLeftSwitch() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.EncReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(!Turned)
    	{
    		Robot.drivetrainSubsystem.ArcadeDrive(0.0, 0.5);
    		Timer.delay(0.5);
    		Turned = true;
    	}
    	else
    	{
    		Scheduler.getInstance().add(new AutoDriveDistance(200 , 0.65));
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
