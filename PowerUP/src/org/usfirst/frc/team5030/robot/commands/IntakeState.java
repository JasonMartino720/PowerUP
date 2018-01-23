package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeState extends Command {

    public IntakeState() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intakeSubsytem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.oi.IntakeIn.get())
    	{
    		Robot.intakeSubsytem.IntakeIn();
    	}
    	else if(Robot.oi.IntakeOut.get())
    	{
    		Robot.intakeSubsytem.IntakeOut();
    	}
    	else if(Robot.oi.placeCube.get())
    	{
    		Robot.intakeSubsytem.PlaceCube();
    	}
    	else
    	{
    		Robot.intakeSubsytem.IntakeOff();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.IntakeIn.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSubsytem.IntakeOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
