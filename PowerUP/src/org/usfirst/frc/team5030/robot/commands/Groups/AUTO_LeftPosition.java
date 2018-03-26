 package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.AutoTimeDelay;
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
public class AUTO_LeftPosition extends CommandGroup {

	private char parsedGameData;

	public AUTO_LeftPosition(String gameData) {
		parsedGameData = gameData.charAt(0);

		switch (parsedGameData) {
		case 'R':
			if (Robot.crossCheckbox)
			{
				System.out.println("Right Switch , Box Checked, Crossing");
				
				
				
		

			}
			else
			{
				System.out.println("Box Unchecked , Line Crossing ");
				addSequential(new AUTO_CrossLine(), 5.5);
			}
			break;

		case 'L':
			
			System.out.println("Left Switch Lets Score");
		
			addSequential(new AUTO_CrossLine() , 3.25);
			addSequential(new AutoTimeDelay(1));
			addSequential(new TimedTurn(-0.6 , 0.8));
			addSequential(new AutoTimeDelay(1));
			addSequential(new AutoDriveDistance(15 , 0.55 , 0));
			addSequential(new AutoTimeDelay(1));
			addSequential(new PlaceCube(), 0.5);
			break;

			default:
			Robot.drivetrainSubsystem.AllStop();
			break;
		}
	}
}
