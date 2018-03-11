package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives a set distance based on Encoders and power outputs without using PID
 */
public class DriveEncoderBangBang extends Command {
	
	double power, distanceToDrive, timeToDrive;
	double stopDistance;
	
	protected Timer timer = new Timer();
	
    public DriveEncoderBangBang(double power, double distance, double timeOut) {
    	this(power, distance);
    	timeToDrive = timeOut;
    }

    /**
     * Defaults the time out to 5.0 seconds
     * @param power
     * @param turn
     * @param distance
     */               
    public DriveEncoderBangBang(double power,  double distance) {
    	requires(Robot.drivetrainSubsystem);
    	this.power = power;
    	distanceToDrive = distance;
    	
    	timeToDrive = 5.0;
    }              

    protected void initialize() {
    	timer.start();
    	System.out.println("Starting encoder bang bang drive");
    	stopDistance = Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage() + distanceToDrive;
    }

    protected void execute() {
    	Robot.drivetrainSubsystem.ArcadeDrive(0, power);
    }

    protected boolean isFinished() {
    	if(timer.get() > timeToDrive)
    		return true;
    	
    	if(power > 0)
    		return Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage() > stopDistance;
    	else
    		return Robot.drivetrainSubsystem.CurrentEncoderPositionInchesAverage() < stopDistance;
    }

    protected void end() {
    	Robot.drivetrainSubsystem.ArcadeDrive(0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
