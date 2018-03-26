package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	double power, amountToTurn;
	double stopAngle;
	double timeToTurn = 2791;

	protected Timer timer = new Timer();

	/**
	 * @param angle degrees that you want to turn
	 * @param power amount of power you want in the turn
	 * @param timeOut seconds before you want to time out
	 */
	public TurnToAngle(double angle, double power, double timeOut) {
		this(angle, power);
		timeToTurn = timeOut;
	}

	/**
	 * Time Out is defaulted to 2791 seconds
	 * @param turn amount of power you want in the turn
	 * @param angle degrees that you want to turn  
	 */
	public TurnToAngle(double angle, double power) {
		super("TurnGyro");
		requires(Robot.drivetrainSubsystem);
		this.power = power;
		amountToTurn = angle;
		assert(Math.signum(power) == Math.signum(angle));
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();
		stopAngle = Robot.drivetrainSubsystem.getGyroAngle() + amountToTurn;
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrainSubsystem.ArcadeDrive(0, power);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(timer.get() > timeToTurn){
			System.out.println("Gyro bang bang turn timed out");
			return true;
		}

		if(power > 0) {
			if(Robot.drivetrainSubsystem.getGyroAngle() > stopAngle) {
				
				return true;
			}
		} else {
			if(Robot.drivetrainSubsystem.getGyroAngle() < stopAngle) {
				
				return true;
			}
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrainSubsystem.ArcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
