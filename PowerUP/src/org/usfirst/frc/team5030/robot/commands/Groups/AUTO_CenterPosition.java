package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.AutoTimeDelay;
import org.usfirst.frc.team5030.robot.DriveDistanceMaintainHeader;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TimedTurn;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.AUTO_CrossLine;
import org.usfirst.frc.team5030.robot.commands.Elevator.LiftDeadReckon;
import org.usfirst.frc.team5030.robot.commands.Intake.AutoIntakeCube;
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
				
				/*addParallel(new LiftDeadReckon(0.5, 0.5));
				addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(-20 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(20 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 3) , 2);
				addSequential(new PlaceCube(1.0));*/
				addSequential(new CenterAuto_LeftDrive());
				addParallel(new LiftDeadReckon(0.5, 0.5));
				addSequential(new DriveDistanceMaintainHeader(30 , -0.65 , 10));
				addSequential(new TurnToAngle(65 , 0.5));
				addSequential(new AutoTimeDelay(0.25));
				addParallel(new LiftDeadReckon(1.0 , -0.75));
				addParallel(new AutoIntakeCube(3.75));
				addSequential(new DriveDistanceMaintainHeader(60 , 0.55 , 5) , 4);
				//Intake
				addSequential(new DriveDistanceMaintainHeader(32 , -0.65 , 10));
				addParallel(new LiftDeadReckon(1.25 , 0.75));
				addSequential(new TurnToAngle(-63 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(35 , 0.7 , 3) , 3);
				addSequential(new PlaceCube(1.0));
			}
			else
			{
				System.out.println("Single Cube Left");
				
				addSequential(new CenterAuto_LeftDrive());
				
				/*addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(-15 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(87 , 0.65 , 10));
				addSequential(new TurnToAngle(20 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 3) , 2);
				addSequential(new PlaceCube(1.0));*/
				
			}
			break;

		case 'R':
			
			if(Robot.twoCube)
			{	
				System.out.println("2 Cube");
				
				
				/*addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(15 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(-25 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(15 , 0.65 , 10) , 2);
				addSequential(new PlaceCube(1.0));*/
				
				addSequential(new CenterAuto_RightDrive());
				addParallel(new LiftDeadReckon(0.5, 0.5));
				addSequential(new DriveDistanceMaintainHeader(30 , -0.65 , 10));
				addSequential(new TurnToAngle(-65 , -0.5));
				addSequential(new AutoTimeDelay(0.25));
				addParallel(new LiftDeadReckon(1.0 , -0.75));
				addParallel(new AutoIntakeCube(3.75));
				addSequential(new DriveDistanceMaintainHeader(60 , 0.55 , 5) , 4);
				//Intake
				addSequential(new DriveDistanceMaintainHeader(32 , -0.65 , 10));
				addParallel(new LiftDeadReckon(1.25 , 0.75));
				addSequential(new TurnToAngle(63 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(35 , 0.7 , 3) , 3);
				addSequential(new PlaceCube(1.0));
			}
			else
			{
				addSequential(new CenterAuto_RightDrive());
				
				/*addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
				addSequential(new TurnToAngle(15 , 0.5));
				addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
				addSequential(new TurnToAngle(-25 , -0.5));
				addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 10) , 2);
				addSequential(new PlaceCube(1.0));*/
				
				
			}
			break;

		default:
			Robot.drivetrainSubsystem.AllStop();
			break;

		}

	}
}
