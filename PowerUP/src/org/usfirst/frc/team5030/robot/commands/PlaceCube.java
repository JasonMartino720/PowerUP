package org.usfirst.frc.team5030.robot.commands;

import javax.management.timer.Timer;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceCube extends Command {

	private double timeStart;
	private boolean finished = false;
	
    public PlaceCube() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intakeSubsytem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeStart = edu.wpi.first.wpilibj.Timer.getMatchTime();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(edu.wpi.first.wpilibj.Timer.getMatchTime() < timeStart + 0.5)
    	{
    		Robot.intakeSubsytem.PlaceCube();
    	}
    	else
    	{
    		Robot.intakeSubsytem.IntakeStop();
    		finished = true;
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSubsytem.IntakeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
