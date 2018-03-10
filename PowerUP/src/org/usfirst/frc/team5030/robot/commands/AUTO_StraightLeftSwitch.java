package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_StraightLeftSwitch extends CommandGroup {

	private String gameData;
	
    public AUTO_StraightLeftSwitch() 
{
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    Robot.intakeSubsytem.intakeOutPosition();	
    
    if(gameData.length() > 0)
    {
		if(gameData.charAt(0) == 'L')
		{
			addSequential(new AutoDriveDistance(120 , 0.65) , 5.5);
	    	addSequential(new PlaceCube() , 1);
	    	System.out.println("Running ");
		}
		else
		{
			addSequential(new AUTO_CrossLine());
		}
    	
    }
    else
    {
    	Robot.drivetrainSubsystem.AllStop();
    }
}

}