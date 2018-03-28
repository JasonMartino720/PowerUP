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
public class AUTO_CenterPosition extends CommandGroup {

	private char parsedGameData;

	public AUTO_CenterPosition(String gameData) {

		
		parsedGameData = gameData.charAt(0);

		switch (parsedGameData) {

		case 'L':
						
			if(Robot.twoCube)
			{	
				System.out.println("2 Cube");
				
				addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(-20 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(20 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 10));
				//addSequential(new PlaceCube() , 0.5);
				addSequential(new DriveDistanceMaintainHeader(22 , -0.65 , 10));
				addSequential(new TurnToAngle(80 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(55 , 0.65 , 10));
				//Intake
				addSequential(new DriveDistanceMaintainHeader(45 , -0.65 , 10));
				addSequential(new TurnToAngle(-80 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(35 , 0.65 , 10));
			}
			else
			{
				System.out.println("Single Cube Left");
				
				addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(-15 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(87 , 0.65 , 10));
				addSequential(new TurnToAngle(20 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 10));
				
			}
			break;

		case 'R':
			
			if(Robot.twoCube)
			{	
				System.out.println("2 Cube");
				
				addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(15 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(-25 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(15 , 0.65 , 10));
				//addSequential(new PlaceCube() , 0.5);
				addSequential(new DriveDistanceMaintainHeader(22 , -0.65 , 10));
				addSequential(new TurnToAngle(-80 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(55 , 0.65 , 10));
				//Intake
				addSequential(new DriveDistanceMaintainHeader(45 , -0.65 , 10));
				addSequential(new TurnToAngle(80 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(35 , 0.65 , 10));
			}
			else
			{
				
				addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(15 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(-25 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(15 , 0.65 , 10));
				
			}
			break;

		default:
			Robot.drivetrainSubsystem.AllStop();
			break;

		}

	}
}
