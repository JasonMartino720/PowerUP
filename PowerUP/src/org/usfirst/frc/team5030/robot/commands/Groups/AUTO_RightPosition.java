package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.AUTO_CrossLine;
import org.usfirst.frc.team5030.robot.commands.PlaceCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_RightPosition extends CommandGroup {

	private char parsedGameData;

	public AUTO_RightPosition(String gameData) {

		parsedGameData = gameData.charAt(0);

		switch (parsedGameData) {
		case 'L':
			if (Robot.crossCheckbox)
			{
				addSequential(new TurnToAngle(-15, 0.5), 1);
				addSequential(new AutoDriveDistance(100, 0.65, 0), 5);
				addSequential(new TurnToAngle(0, 0.5), 1);
				addSequential(new PlaceCube(), 0.5);

			}
			else
			{
				addSequential(new AUTO_CrossLine(), 14);
			}
			break;

		case 'R':
			addSequential(new AutoDriveDistance(125, 0.65, 0), 6);
			addSequential(new PlaceCube(), 0.5);
			break;

		default:
			Robot.drivetrainSubsystem.AllStop();
			break;
		}
	}
}
