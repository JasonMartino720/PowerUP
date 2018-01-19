package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	//Create SpeedControllerGroup for gripper and arm motors
	public static SpeedControllerGroup Gripper_Group 
		= new SpeedControllerGroup(Robot.robotmap.leftGripper, Robot.robotmap.rightGripper);
	
	public static SpeedControllerGroup Compliant_Arm_Group 
		= new SpeedControllerGroup(Robot.robotmap.leftCompliantArm, Robot.robotmap.rightCompliantArm);
	
	private double Gripper_Intake_Speed = 1.0;
	
	public Intake()
	{
		//Invert One of the gripper motors
		Robot.robotmap.rightGripper.setInverted(true);
		Robot.robotmap.rightCompliantArm.setInverted(true);
	}
	
    public void IntakeOff()
    {
    	Gripper_Group.set(0.0);
    	Compliant_Arm_Group.set(0.0);
    }
    
    public void IntakeIn()
    {
    	Gripper_Group.set(Gripper_Intake_Speed);
    	Robot.robotmap.leftCompliantArm.set(0.75);
    	Robot.robotmap.rightCompliantArm.set(0.65);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeOff());
    }
}

