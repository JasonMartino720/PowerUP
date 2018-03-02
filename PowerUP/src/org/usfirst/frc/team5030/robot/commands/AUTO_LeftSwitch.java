package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.AutoDriveDistance;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.TurnToAngle;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_LeftSwitch extends CommandGroup {

    public AUTO_LeftSwitch() {
    	addSequential(new TurnToAngle(30 , 0.5));
    	/*addSequential(new AutoDriveDistance(150, 0.65));
    	addSequential(new TurnToAngle(0 , 0.5));
    	addSequential(new AutoDriveDistance(15 , 0.5));
    	addSequential(new PlaceCube());
    	*/
    }
}
