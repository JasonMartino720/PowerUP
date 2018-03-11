package org.usfirst.frc.team5030.robot.commands.Groups;

import org.usfirst.frc.team5030.robot.DriveEncoderBangBang;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.LiftDeadRockon;
import org.usfirst.frc.team5030.robot.commands.PlaceCube;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BangBangTurnSwitchLEFT extends CommandGroup {

    public BangBangTurnSwitchLEFT() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	// drive off the wall
    	// 3rd arg is drive distance 
    	
    	// NOTE. ALl bang bang distances have a little removed to compensate for overshoot.

    	addSequential(new DriveEncoderBangBang(0.4, 3*3, 100));;
    	// turn towards the left side
    	addSequential(new TurnToAngle(-60, -0.3, 100));
    	// drive towards the left side
    	addParallel(new LiftDeadRockon(.3, 2)); // was 13
    	addSequential(new DriveEncoderBangBang(0.4, 23*3, 100));
    	// turn to face the switch
    	addSequential(new TurnToAngle(60, 0.3, 100)); // there is only a weak drive after this turn so it overshoots more
    	// drive into the switch. Low power so we'll hit the wall and use the timeout to stop
    	addSequential(new DriveEncoderBangBang(0.4, 10*3, 3.5));
    	addSequential(new DriveEncoderBangBang(0.2, 14*3, 3.5));
    	// score
    	addSequential(new PlaceCube());
    }
}