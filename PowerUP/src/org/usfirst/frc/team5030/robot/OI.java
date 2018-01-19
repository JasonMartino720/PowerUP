package org.usfirst.frc.team5030.robot;

//Import all commands for binding
import org.usfirst.frc.team5030.robot.commands.*;
//Import all subsytems
import org.usfirst.frc.team5030.robot.subsystems.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;


public class OI 
{
	
	//Instantiate, create, and name Driver Joystick
	public static Joystick driver = new Joystick(0);
		public JoystickButton rbbutton = new JoystickButton(driver, 6);
	
	//Instantiate, create, and name Operator Joystick
	public static Joystick operator = new Joystick(1);
		public JoystickButton intake = new JoystickButton(operator, 6);
		

	public OI()
	{
		
	}
	
}
