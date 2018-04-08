package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.DriveDistanceMaintainHeader;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.Elevator.LiftDeadReckon;
import org.usfirst.frc.team5030.robot.commands.Intake.PlaceCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAuto_LeftDrive extends CommandGroup {

    public CenterAuto_LeftDrive() {
        
    	addSequential(new DriveDistanceMaintainHeader(15 , 0.60 , 10));
		addSequential(new TurnToAngle(-18 , -0.55));
		addSequential(new DriveDistanceMaintainHeader(85 , 0.65 , 10));
		addSequential(new TurnToAngle(20 , 0.5));
		addSequential(new DriveDistanceMaintainHeader(30 , 0.65 , 3) , 1.25);
		addSequential(new LiftDeadReckon(0.75, 0.75));
		addSequential(new PlaceCube(0.5));
    }
}
