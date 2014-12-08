package com.team5053.frc2014.subsystems;

import com.team5053.frc2014.Jimmy;
//RGT import com.team254.frc2014.Constants;
import com.team254.lib.ChezyGyro;
//RGT import com.team254.lib.Controller;
import com.team254.lib.Loopable;
import com.team254.lib.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
//RGT import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Hashtable;

/**
 * This class defines the drivebase.
 * @author spinkerton
 */
public class DrivebaseTEMPHide extends com.team254.frc2014.subsystems.Drivebase{

  // ticks to feet
  public final double RIGHT_ENCOCDER_TO_DISTANCE_RATIO = (3.5 * Math.PI) / (12.0 * 256.0); //TODO
  public final double LEFT_ENCOCDER_TO_DISTANCE_RATIO = (3.5 * Math.PI) / (12.0 * 256.0); //TODO
  // Speed controllers
//RGT  private Talon leftDriveA = Jimmy.leftDriveA;//new Talon(Jimmy.PWM_LEFT_MOTOR_1/*RGT Constants.leftDrivePortA.getInt()*/);
//RGT  private Talon leftDriveB = Jimmy.leftDriveB;//new Talon(Jimmy.PWM_LEFT_MOTOR_2/*RGT Constants.leftDrivePortB.getInt()*/);
  //RGT private Talon leftDriveC = new Talon(/*RGT Constants.leftDrivePortC.getInt()*/);
//RGT  private Talon rightDriveA = Jimmy.rightDriveA;//new Talon(Jimmy.PWM_RIGHT_MOTOR_1/*RGT Constants.rightDrivePortA.getInt()*/);
//RGT  private Talon rightDriveB = Jimmy.rightDriveB;//new Talon(Jimmy.PWM_RIGHT_MOTOR_2/*RGT Constants.rightDrivePortB.getInt()*/);
  //RGT private Talon rightDriveC = new Talon(/*RGT Constants.rightDrivePortC.getInt()*/);
  //Encoders
//RGT  private Encoder leftEncoder = new Encoder(Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A/*RGT Constants.leftEncoderPortA.getInt()*/,
//RGT                                            Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B/*RGT Constants.leftEncoderPortB.getInt()*/,
//RGT                                            false);
//RGT  private Encoder rightEncoder = new Encoder(Jimmy.INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_A/*RGT Constants.rightEncoderPortA.getInt()*/,
//RGT                                             Jimmy.INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_B/*RGT Constants.rightEncoderPortB.getInt()*/,
//RGT                                             true);
  
  //Solenoids
//RGT  private Solenoid shifter = new Solenoid(Constants.shifterPort.getInt());
  //Gyro
  public ChezyGyro gyro;

  public void setLeftRightPower(double leftPower, double rightPower) {
//RGT    leftDriveA.set(leftPower);
//RGT    leftDriveB.set(leftPower);
    //RGT leftDriveC.set(leftPower);
//RGT    rightDriveA.set(-rightPower);
//RGT    rightDriveB.set(-rightPower);
    //RGT rightDriveC.set(-rightPower);
  }
  //RGT public void setLowgear(boolean low) {
  //RGT   shifter.set(low);
  //RGT }
  public DrivebaseTEMPHide() {
    super(/*RGT "DrivebaseTEMPHide"*/);//RGT the parent will pass in "DrivebaseTEMPHide" to the super
//RGT    gyro = new ChezyGyro(Jimmy.INPUT_ANALOG_GYROSCOPE/*RGT Constants.gyroPort.getInt()*/);
//RGT    leftEncoder.start();
//RGT    rightEncoder.start();
  }

  public Hashtable serialize() {
    Hashtable leftDrive = new Hashtable();
    Hashtable rightDrive = new Hashtable();
    Hashtable encoders = new Hashtable();

//RGT    leftDrive.put("leftDriveA", new Double(leftDriveA.get()));
//RGT    leftDrive.put("leftDriveB", new Double(leftDriveB.get()));
    //RGT leftDrive.put("leftDriveC", new Double(leftDriveC.get()));

//RGT    rightDrive.put("rightDriveA", new Double(rightDriveA.get()));
//RGT    rightDrive.put("rightDriveB", new Double(rightDriveB.get()));
    //RGT rightDrive.put("rightDriveC", new Double(rightDriveC.get()));

//RGT    encoders.put("leftEncoder", new Double(leftEncoder.get()));
//RGT    encoders.put("rightEncoder", new Double(rightEncoder.get()));    
    data.put("leftDrive", leftDrive);
    data.put("rightDrive", rightDrive);
    data.put("encoders", encoders);
    data.put("gyro", new Double(getGyroAngle()));
    return data;
  }

//RGT  public Encoder getLeftEncoder() {
//RGT    return leftEncoder;
//RGT  }

//RGT  public double getLeftEncoderDistance() { // in feet
//RGT    return leftEncoder.get() * LEFT_ENCOCDER_TO_DISTANCE_RATIO;
//RGT  }

  public double getLeftEncoderDistanceInMeters() {
    return getLeftEncoderDistance() * 0.3048; //TODO
  }

//RGT  public Encoder getRightEncoder() {
//RGT    return rightEncoder;
//RGT  }

 //RGT public double getRightEncoderDistance() {
//RGT    return rightEncoder.get() * RIGHT_ENCOCDER_TO_DISTANCE_RATIO;
//RGT  }

  public double getRightEncoderDistanceInMeters() {
    return getRightEncoderDistance() * 0.3048;
  }

  public double getGyroAngle() {
    return -gyro.getAngle();
  }

  public double getGyroAngleInRadians() {
    return (getGyroAngle() * Math.PI) / 180.0;
  }

  public void resetGyro() {
    gyro.reset();
  }
  

  public double getUltrasonicDistance() {
    return 3;
  }

  public double getAverageDistance() {
    return (getRightEncoderDistance() + getLeftEncoderDistance()) / 2.0;
  }

  public void driveSpeedTurn(double speed, double turn) {
    double left = speed + turn;
    double right = speed - turn;
    setLeftRightPower(left, right);
  }
  
  public void resetEncoders() {
//RGT    leftEncoder.reset();
//RGT    rightEncoder.reset();
  }
  
  public void update() {
    SmartDashboard.putNumber("driveLeftEncoder", getLeftEncoderDistance());
    SmartDashboard.putNumber("driveRightEncoder", getRightEncoderDistance());
    SmartDashboard.putNumber("gyro", getGyroAngle());
    super.update();
  }

}
