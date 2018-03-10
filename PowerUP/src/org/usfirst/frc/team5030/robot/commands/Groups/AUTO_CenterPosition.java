package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.PlaceCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_CenterPosition extends CommandGroup {

	private char parsedGameData;

	public AUTO_CenterPosition(String gameData) {

		parsedGameData = gameData.charAt(0);

		switch (parsedGameData) {

		case 'L':
			addSequential(new TurnToAngle(-10, 0.5), 1);
			addSequential(new AutoDriveDistance(85, 0.65), 5);
			addSequential(new TurnToAngle(0, 0.5), 1);
			addSequential(new PlaceCube(), 0.5);
			break;

		case 'R':
			addSequential(new TurnToAngle(10, 0.5), 1);
			addSequential(new AutoDriveDistance(85, 0.65), 5);
			addSequential(new TurnToAngle(0, 0.5), 1);
			addSequential(new PlaceCube(), 0.5);
			break;

		default:
			Robot.drivetrainSubsystem.AllStop();
			break;

		}

	}
}
