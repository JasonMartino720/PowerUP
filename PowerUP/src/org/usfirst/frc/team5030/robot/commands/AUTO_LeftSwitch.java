package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TurnToAngle;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_LeftSwitch extends CommandGroup {

private String gameData;
	
    public AUTO_LeftSwitch() 
{
        
    if(gameData.length() > 0)
    {
		if(gameData.charAt(0) == 'L')
		{
			addSequential(new AUTO_DriveLeftSwitch());
			addSequential(new PlaceCube());
		}
    	
    }
    else
    {
    	Robot.drivetrainSubsystem.AllStop();
    }
}

}