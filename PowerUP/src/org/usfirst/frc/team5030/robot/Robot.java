package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5030.robot.Enums.AutoMode;
import org.usfirst.frc.team5030.robot.commands.*;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_CenterPosition;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_LeftPosition;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_RightPosition;
import org.usfirst.frc.team5030.robot.commands.Groups.BangBangTurnSwitchLEFT;
import org.usfirst.frc.team5030.robot.commands.Groups.BangBangTurnSwitchRIGHT;
import org.usfirst.frc.team5030.robot.subsystems.*;
 

public class Robot extends TimedRobot {
	
	public static double kEncoderConversion = ((6*Math.PI) / 4100);
	
	public static boolean crossCheckbox;
	
	public static String receivedGameData;
	
	public static RobotMap robotmap;
	public static Intake intakeSubsytem;
	public static Drivetrain drivetrainSubsystem;
	public static Climber climberSubsytem;
	public static Elevator elevatorSubsystem;
	public static OI oi;

	Command m_autonomousCommand;
	SendableChooser<AutoMode> m_chooser = new SendableChooser<>();
	SendableChooser<Boolean> CrossCheckbox = new SendableChooser<>();
	

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
		m_chooser.addDefault("Default Auto", AutoMode.DEFAULT);//new AUTO_Default());
		m_chooser.addObject("Cross Line For Time" , AutoMode.CROSS_LINE);
		m_chooser.addObject("Right Position", AutoMode.RIGHT_POSITION);
		m_chooser.addObject("Center Position" , AutoMode.CENTER_POSITION);
		m_chooser.addObject("Left Position"	, AutoMode.LEFT_POSITION);

	/*	m_chooser.addObject("Right Position", new AUTO_RightPosition());
		m_chooser.addObject("Decide Switch" , new AUTO_CenterPosition());
		m_chooser.addObject("Left Position" , new AUTO_LeftPosition());
		*/
		
		CrossCheckbox.addDefault("NO", false);
		CrossCheckbox.addObject("YES", true);
		
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putData("Cross?" , CrossCheckbox);
		
		Robot.drivetrainSubsystem.EncReset();
		Robot.drivetrainSubsystem.configIMU();
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
		debug();
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
		
		Robot.drivetrainSubsystem.EncReset();
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if (gameData != null && gameData.length() == 3) {
			switch(m_chooser.getSelected()) {
			
			case CROSS_LINE:
				m_autonomousCommand = new AUTO_CrossLine();
				break;
				
			case RIGHT_POSITION:
				m_autonomousCommand = new AUTO_RightPosition(gameData);
				break;
				
			case CENTER_POSITION:
				m_autonomousCommand = new AUTO_CenterPosition(gameData);
				break;
				
			case LEFT_POSITION:
				m_autonomousCommand = new AUTO_LeftPosition(gameData);
				break;
				
			case DEFAULT:
			default:
				m_autonomousCommand = new AUTO_Default();
			}
		}
		
		else {
			m_autonomousCommand = new AUTO_Default();
		}
		
		crossCheckbox = CrossCheckbox.getSelected();
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
		debug();
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
		Robot.drivetrainSubsystem.configIMU();
		Robot.elevatorSubsystem.elevatorEncoderReset();
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println("Heading " + Robot.drivetrainSubsystem.getGyroAngle());
		debug();
			
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
	
	/*public void updateGameData(boolean retry){
		String data = DriverStation.getInstance().getGameSpecificMessage();
		if(retry) {
			int retries = 50;
			// Retry code taken from 5687! Thanks!
			// https://www.chiefdelphi.com/forums/showpost.php?p=1735952&postcount=22
			data = DriverStation.getInstance().getGameSpecificMessage();
	        while (data.length() < 2 && retries > 0) {
	            retries--;
	            try {
	                Thread.sleep(5);
	            } catch (InterruptedException ie) {
	                // Just ignore the interrupted exception
	            }
	            data = DriverStation.getInstance().getGameSpecificMessage();
	        }
		}

	}
	*/
	
	public void debug() {
		SmartDashboard.putNumber("Right Encoder", robotmap.FR.getSelectedSensorPosition(0) * this.kEncoderConversion);
		SmartDashboard.putNumber("Left Encoder" , robotmap.FL.getSelectedSensorPosition(0) * this.kEncoderConversion);
		SmartDashboard.putNumber("Elevator Encoder", this.elevatorSubsystem.getPosition()); 
		SmartDashboard.putNumber("Yaw" , this.drivetrainSubsystem.getGyroAngle());
	
	}
}
