package org.usfirst.frc.team5030.robot.commands.Groups;

//import org.usfirst.frc.team5030.robot.DriveEncoderBangBang;
import org.usfirst.frc.team5030.robot.TurnToAngle;
import org.usfirst.frc.team5030.robot.commands.Elevator.LiftDeadRockon;
import org.usfirst.frc.team5030.robot.commands.Intake.PlaceCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BangBangTurnSwitchRIGHT extends CommandGroup {

    public BangBangTurnSwitchRIGHT() {
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
/*    
    	// NOTE. ALl bang bang distances have a little removed to compensate for overshoot.
    	addSequential(new DriveEncoderBangBang(0.3, 3*1.571, 100));
    	// turn towards the left side
    	addSequential(new TurnToAngle(60-10, 0.3, 100)); // want to turn 60 degrees 
    	addParallel(new LiftDeadRockon(.3, 2));
    	// stop any momentum we have so the next drive start cleanly
//    	addSequential(new PauseDrivetrain(0.5));
    	// drive towards the left side
    	addSequential(new DriveEncoderBangBang(0.3, 16.9*1.571, 100)); // was 16.9, made 32 but I wanted to add 18 in. // made 22.5 and overshot 1/2 a robot
    	// stop any momentum we have so the next drive start cleanly
//    	addSequential(new PauseDrivetrain(0.75));
    	// turn to face the switch
    	addSequential(new TurnToAngle(-(60-5), -0.35, 100)); // robot has more trouble turning counter clockwise
    	// drive into the switch. Low power so we'll hit the wall and use the timeout to stop
    	addSequential(new DriveEncoderBangBang(0.4, 14*1.571, 3.5));
    	addSequential(new DriveEncoderBangBang(0.2, 14*1.571, 3.5));
    	// score
//    	addSequential(new PlaceCube());
  
*/
 
    }
}
