package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.AutoTimeDelay;
import org.usfirst.frc.team5030.robot.DriveDistanceMaintainHeader;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TimedTurn;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.Intake.PlaceCube;

import edu.wpi.first.wpilibj.Timer;
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
			
			addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
			addSequential(new TurnToAngle(-15 , -0.5));
			addSequential(new DriveDistanceMaintainHeader(87 , 0.65 , 10));
			addSequential(new TurnToAngle(20 , 0.5));
			addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 10));
			break;

		case 'R':
			addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
			addSequential(new TurnToAngle(15 , 0.5));
			addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
			addSequential(new TurnToAngle(-25 , -0.5));
			addSequential(new DriveDistanceMaintainHeader(15 , 0.65 , 10));
			
			break;

		default:
			Robot.drivetrainSubsystem.AllStop();
			break;

		}

	}
}
