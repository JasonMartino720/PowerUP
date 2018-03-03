package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5030.robot.commands.*;
import org.usfirst.frc.team5030.robot.subsystems.*;


public class Robot extends TimedRobot {
	
	public static RobotMap robotmap;
	public static Intake intakeSubsytem;
	public static Drivetrain drivetrainSubsystem;
	public static Climber climberSubsytem;
	public static Elevator elevatorSubsystem;
	public static OI oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */ 
	@Override
	public void robotInit() {
		robotmap = new RobotMap();
		intakeSubsytem = new Intake();
		drivetrainSubsystem = new Drivetrain();
		climberSubsytem = new Climber();
		elevatorSubsystem = new Elevator();
		oi = new OI();
		m_chooser.addDefault("Default Auto", new AUTO_Default());
		m_chooser.addObject("Cross Line For Time" , new AUTO_CrossLine());
		m_chooser.addObject("Right Switch Auto", new AUTO_RightSwitch());
		m_chooser.addObject("Left Switch" , new AUTO_LeftSwitch());
		m_chooser.addObject("Switch Selector", new AUTO_SwitchSelector());
		
		SmartDashboard.putData("Auto mode", m_chooser);
		
		Robot.drivetrainSubsystem.EncReset();
		Robot.drivetrainSubsystem.ConifgMagEncoder();
	} 

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the m_chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * m_chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the m_chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * m_chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
			
			
		}
		
		Robot.drivetrainSubsystem.EncReset();
	
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
			
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
