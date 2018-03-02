package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_SwitchSelector extends CommandGroup {

	private String gameData;
	
    public AUTO_SwitchSelector() {
 
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                
		if(gameData.length() > 0)
        {
			if(gameData.charAt(0) == 'L')
			{
				addParallel(new AUTO_LeftSwitch());
			} 
			else if(gameData.charAt(0) == 'R') 
			{
				addParallel(new AUTO_RightSwitch());
			}
			else
			{
				addParallel(new AUTO_Default());
			}
        }
        
    }

    
}
