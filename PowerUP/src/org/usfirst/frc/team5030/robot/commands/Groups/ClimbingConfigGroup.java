package org.usfirst.frc.team5030.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClimbingConfigGroup extends CommandGroup {

    public ClimbingConfigGroup() {
  
    	addParallel(new DeployClimbingRamps);
    	addParallel(new DeployClimbingWheels);
    	
    }
}
