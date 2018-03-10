package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2791.robot.commands.auto.BangBangTurnSwitchLEFT;
import org.usfirst.frc.team2791.robot.commands.auto.BangBangTurnSwitchRIGHT;
import org.usfirst.frc.team2791.robot.util.autonChoosers.AutonCommandChooser;
import org.usfirst.frc.team2791.robot.util.autonChoosers.NearSwitchAutonChooser;
import org.usfirst.frc.team5030.robot.commands.*;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_CenterPosition;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_LeftPosition;
import org.usfirst.frc.team5030.robot.commands.Groups.AUTO_RightPosition;
import org.usfirst.frc.team5030.robot.subsystems.*;


public class Robot extends TimedRobot {
	
	public static boolean crossCheckbox;
	
	public static String receivedGameData;
	
	public static RobotMap robotmap;
	public static Intake intakeSubsytem;
	public static Drivetrain drivetrainSubsystem;
	public static Climber climberSubsytem;
	public static Elevator elevatorSubsystem;
	public static OI oi;
	
	public static boolean weOwnLeftSideNearSwitch, weOwnLeftSideScale, weOwnLeftSideFarSwitch;
	AutonCommandChooser autonCommandChooser;

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
		
		// TODO
		// put get game data here.
		// put shaker chooser code here.
		updateGameData(true);
		
		autonCommandChooser = new NearSwitchAutonChooser(
				new BangBangTurnSwitchLEFT(), // this will run when we are on the left side of the switch
				new BangBangTurnSwitchRIGHT() // this will run when we are on the right side of the switch
			);
			
		m_autonomousCommand = autonCommandChooser.getCommand(weOwnLeftSideNearSwitch, weOwnLeftSideScale, weOwnLeftSideFarSwitch);

//		// schedule the autonomous command (example)
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.start();
//		} else {
//			m_autonomousCommand = new AUTO_CrossLine();
//			m_autonomousCommand.start();
//		}
		
		
		m_autonomousCommand = new AUTO_CrossLine();
		m_autonomousCommand.start();
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
	
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		debug();
			
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public void updateGameData(boolean retry){
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

		if(data.length() > 0){
			weOwnLeftSideNearSwitch = data.charAt(0) == 'L';
			weOwnLeftSideScale = data.charAt(1) == 'L';
			weOwnLeftSideFarSwitch = data.charAt(2) == 'L';

			SmartDashboard.putBoolean("leftSwitchNear", weOwnLeftSideNearSwitch);
			SmartDashboard.putBoolean("leftScale", weOwnLeftSideScale);
			SmartDashboard.putBoolean("leftSwitchFar", weOwnLeftSideFarSwitch);
		}
	}
	
	public void debug() {
		SmartDashboard.putNumber("! GYRO ", robotmap.gyro.getAngle());
		SmartDashboard.putNumber("! Encoders", drivetrainSubsystem.CurrentEncoderPositionInchesAverage());
	}
}
