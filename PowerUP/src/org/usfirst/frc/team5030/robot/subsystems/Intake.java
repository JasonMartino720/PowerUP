package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

//TODO Create "Intelligent" Intake system based off of Linear pot position
//TODO Test all motors and correct imports
public class Intake extends Subsystem {
	
	//Create SpeedControllerGroup for gripper and arm motors
	private SpeedControllerGroup Gripper_Group 
		= new SpeedControllerGroup(Robot.robotmap.leftGripper, Robot.robotmap.rightGripper);
	
	private SpeedControllerGroup Compliant_Arm_Group 
		= new SpeedControllerGroup(Robot.robotmap.leftCompliantArm, Robot.robotmap.rightCompliantArm);
	
	private double Gripper_Intake_Speed = 0.5;
	
	public Intake()
	{
		//Invert One of the gripper motors
		
		Robot.robotmap.leftGripper.setInverted(true);
		Robot.robotmap.leftCompliantArm.setInverted(true);
		Robot.robotmap.rightCompliantArm.setInverted(true);
	} 
	
	//Turn off both SpeedControllerGroups
    public void IntakeStop()
    {
    	this.Gripper_Group.set(0.0);
    	this.Compliant_Arm_Group.set(0.0);
    }
    
    //Bring in Cube
    //Slight offset on the speeds of the arms to help facilitate corner grabbing
    public void IntakeIn()
    {
    	Robot.robotmap.leftGripper.set(0.5);
    	Robot.robotmap.rightGripper.set(0.5);
    	Robot.robotmap.leftCompliantArm.set(0.4);
    	Robot.robotmap.rightCompliantArm.set(0.35);
    }

    //Intake outwards, used for when cube is on the ground still
    public void IntakeOut()
    {
    	this.Gripper_Group.set(-0.5);
    	Compliant_Arm_Group.set(-0.5);
    }
    
    //Place cube in Switch or scale
    //Uses the gripper section of the elevator ONLY
    public void PlaceCube()
    {
    	Robot.robotmap.leftGripper.set(1.0);
    	Robot.robotmap.rightGripper.set(1.0);
    }
    
    public void intakeStartPosition()
    {
    	Robot.robotmap.intakeSolenoid.set(Value.kReverse);
    }
    
    public void intakeOutPosition()
    {
    	Robot.robotmap.intakeSolenoid.set(Value.kForward);
    }
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeState());
    }
}

