package org.usfirst.frc.team5030.robot;

//Import all commands for binding
import org.usfirst.frc.team5030.robot.commands.*;
//Import all subsytems
import org.usfirst.frc.team5030.robot.subsystems.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;


public class OI 
{
	
	//Instantiate, create, and name Driver Joystick
	public static Joystick driver = new Joystick(0);
		public JoystickButton rbbutton = new JoystickButton(driver, 6);
	
	//Instantiate, create, and name Operator Joystick
	public static Joystick operator = new Joystick(1);
		public JoystickButton intakeIn = new JoystickButton(operator, 6); //RB		
		public JoystickButton intakeOut = new JoystickButton(operator, 5);//LB
		public JoystickButton climb = new JoystickButton(operator, 2); //X
		public Button operatorPOVLeft = new DPad(operator, 270); //Left on the DPad used for Scale
		public Button operatorPOVRight = new DPad(operator, 90);
		
		

	public OI()
	{
		//Intake Binding
		intakeIn.whileHeld(new IntakeState());
		intakeIn.whenPressed(new IntakeOff());
		intakeOut.whileHeld(new IntakeState());
		intakeOut.whenPressed(new IntakeOff());
		
		
		//DPAD Binding for Elevator
		operatorPOVLeft.whileHeld(new ElevatorSetPosition());
		operatorPOVRight.whileHeld(new ElevatorSetPosition());

		//Climber Binding
		climb.whileHeld(new ClimberState());
		climb.whenReleased(new ClimberOff());
		
		//
		
	}
	
}
