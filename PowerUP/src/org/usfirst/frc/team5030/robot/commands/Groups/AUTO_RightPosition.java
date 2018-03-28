package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.AutoTimeDelay;
import org.usfirst.frc.team5030.robot.DriveDistanceMaintainHeader;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TimedTurn;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.AUTO_CrossLine;
import org.usfirst.frc.team5030.robot.commands.Intake.PlaceCube;

import edu.wpi.first.wpilibj.Timer;
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
			System.out.println("Box " + Robot.crossCheckbox);
			if (Robot.crossCheckbox)
			{
				System.out.println("Left Switch , Box Checked, Crossing");
				addSequential(new DriveDistanceMaintainHeader(205 , 0.65 , 10));
				addSequential(new TurnToAngle(-75 , -0.45));
				addSequential(new AutoTimeDelay(0.25));
				addSequential(new DriveDistanceMaintainHeader(155, 0.65 , 10));	
				addSequential(new TurnToAngle(-70 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(35, 0.65 , 10));	
				

			}
			else
			{
				System.out.println("Box Unchecked , Line Crossing ");
				addSequential(new AUTO_CrossLine(), 14);
			}
			
			break;

		case 'R':
			
			System.out.println("Right Switch Lets Score");
			
			addSequential(new DriveDistanceMaintainHeader(140 , 0.65 , 10));
			addSequential(new TurnToAngle(-85 , -0.5));
			addSequential(new DriveDistanceMaintainHeader(36, 0.65 , 10));
			
			break;

			default:
			Robot.drivetrainSubsystem.AllStop();
			break;
		}
	}
}
