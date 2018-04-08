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
	
	private double Gripper_Intake_Speed = 0.5;
	
	public Intake()
	{
		//Invert One of the gripper motors
		
		Robot.robotmap.leftGripper.setInverted(true);
		Robot.robotmap.rightGripper.setInverted(false);
	} 
	
	//Turn off both SpeedControllerGroups
    public void IntakeStop()
    {
    	this.Gripper_Group.set(0.0);
    	//this.Compliant_Arm_Group.set(0.0);
    }
    
    //Bring in Cube
    //Slight offset on the speeds of the arms to help facilitate corner grabbing
    public void IntakeIn()
    {
    	Robot.robotmap.leftGripper.set(-0.55);
    	Robot.robotmap.rightGripper.set(-0.45);
    
    }

    //Intake outwards, used for when cube is on the ground still
    public void IntakeOut()
    {
    	this.Gripper_Group.set(0.5);
   
    }
    
    //Place cube in Switch or scale
    //Uses the gripper section of the elevator ONLY
    public void PlaceCube()
    {
    	Robot.robotmap.leftGripper.set(0.5);
    	Robot.robotmap.rightGripper.set(0.5);
    }
 
    public void OpenPistons()
    {
    	Robot.robotmap.intakeSolenoidLeft.set(Value.kForward);
    	Robot.robotmap.intakeSolenoidRight.set(Value.kForward);
    }
    
    public void ClampCube()
    {
    	Robot.robotmap.intakeSolenoidLeft.set(Value.kReverse);
    	Robot.robotmap.intakeSolenoidRight.set(Value.kReverse);
    }
    
    public void PistonNeutralPosition()
    {
    	Robot.robotmap.intakeSolenoidLeft.set(Value.kOff);
    	Robot.robotmap.intakeSolenoidRight.set(Value.kOff);
    }
    
    public boolean CubePresent()
    {
    	return Robot.robotmap.cubeSensor.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand();
    }
}

