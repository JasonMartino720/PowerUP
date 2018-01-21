package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

//TODO Figure out Invert so spinning direction is positive
public class Climber extends Subsystem {
	
	   public void ClimberOff()
    {
    	Robot.robotmap.climber.set(0.0);
    }
    
    public void Climb()
    {
    	Robot.robotmap.climber.set(1.0);
    }

    public Climber()
    {
    	Robot.robotmap.climber.setInverted(false);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimberOff());
    }
}

