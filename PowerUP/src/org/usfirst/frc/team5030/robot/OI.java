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

	private final int LT = 2;
	private final int RT = 3;
	
	//Instantiate, create, and name Driver Joystick
	public static Joystick driver = new Joystick(0);
		public JoystickButton rbbutton = new JoystickButton(driver, 6);
	
	//Instantiate, create, and name Operator Joystick
	public static Joystick operator = new Joystick(1);
		public JoystickButton IntakeIn = new JoystickButton(operator, 6); //RB		
		public JoystickButton IntakeOut = new JoystickButton(operator, 5);//LB
		public JoystickButton placeCube = new JoystickButton(operator, 1);//A
		public JoystickButton climb = new JoystickButton(operator, 7); //Back Button
		public Button operatorPOVLeft = new DPad(operator, 270); //Left on the DPad used for Scale
		public Button operatorPOVRight = new DPad(operator, 90); //Right on the DPAD used for Switch
		public Button operatorRT = new TriggerButton(operator, this.RT, .2);
		public Button operatorLT = new TriggerButton(operator, this.LT, .2);
		

	public OI()
	{
		//Intake Binding
		IntakeIn.whileHeld(new IntakeState());
		IntakeIn.whenPressed(new IntakeOff());
		IntakeOut.whileHeld(new IntakeState());
		IntakeOut.whenPressed(new IntakeOff());
		operatorLT.whenPressed(new IntakeStartingPosition());	
		operatorRT.whenPressed(new IntakeOutwardPosition());	
		
		//DPAD Binding for Elevator
		operatorPOVLeft.whileHeld(new ElevatorSetPosition());
		operatorPOVRight.whileHeld(new ElevatorSetPosition());

		//Climber Binding
		climb.whileHeld(new ClimberState());
		climb.whenReleased(new ClimberOff());
		
		//
		
	}
	
}
