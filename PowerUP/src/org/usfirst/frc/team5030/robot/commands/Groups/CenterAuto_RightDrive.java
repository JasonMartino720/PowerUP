package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.DriveDistanceMaintainHeader;
import org.usfirst.frc.team5030.robot.SplineDrive;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.Elevator.LiftDeadReckon;
import org.usfirst.frc.team5030.robot.commands.Intake.PlaceCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAuto_RightDrive extends CommandGroup {

    public CenterAuto_RightDrive() {
        
    	//IF YOU NEED TO REVERT UNCOMMENT THIS STUFF AND COMMENT OUT WHATS ACTIVE
    	/*
    	addSequential(new DriveDistanceMaintainHeader(20 , 0.65 , 10));
		addSequential(new TurnToAngle(15 , 0.5));
		addSequential(new DriveDistanceMaintainHeader(90 , 0.65 , 10));
		addSequential(new TurnToAngle(-25 , -0.5));
		addSequential(new DriveDistanceMaintainHeader(25 , 0.65 , 10) , 1.25);
		addSequential(new LiftDeadReckon(0.75, 0.75));
		addSequential(new PlaceCube(0.5));
		*/
    	
    	addSequential(new SplineDrive(65, 45, 'R'));
    	addParallel(new LiftDeadReckon(0.75, 0.75));
    	addSequential(new SplineDrive(85, 40, 'L'));
		addSequential(new PlaceCube(0.5));
    }
}
