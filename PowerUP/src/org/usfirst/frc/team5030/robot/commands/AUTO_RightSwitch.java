package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_RightSwitch extends CommandGroup {

	private String gameData;
	
    public AUTO_RightSwitch() 
{
        
    if(gameData.length() > 0)
    {
		if(gameData.charAt(0) == 'R')
		{
			addSequential(new AutoDriveDistance(120 , 0.65) , 6);
	    	addSequential(new PlaceCube() , 0.5);
		}
    	
    }
    else
    {
    	Robot.drivetrainSubsystem.AllStop();
    }
}

}