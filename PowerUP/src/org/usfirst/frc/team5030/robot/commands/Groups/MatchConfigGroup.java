package org.usfirst.frc.team5030.robot.commands.Groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5030.robot.commands.*;
import org.usfirst.frc.team5030.robot.commands.Intake.IntakeOutwardPosition;

/**
 *
 */
public class MatchConfigGroup extends CommandGroup {

    public MatchConfigGroup() {
      
    	addParallel(new IntakeOutwardPosition());
    	
    	
    }
}
