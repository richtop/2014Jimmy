package com.team254.frc2014.subsystems;

import com.team254.frc2014.Constants;
import com.team254.lib.ChezyGyro;
//RGT import com.team254.lib.Controller;
import com.team254.lib.Loopable;
import com.team254.lib.Subsystem;
import com.team5053.frc2014.Jimmy;
import edu.wpi.first.wpilibj.Encoder;
//RGT import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Hashtable;

/**
 * This class defines the drivebase.
 * @author spinkerton
 */
public class Drivebase extends Subsystem implements Loopable {

  // ticks to feet
  public final double RIGHT_ENCOCDER_TO_DISTANCE_RATIO = (3.5 * Math.PI) / (12.0 * 256.0);
  public final double LEFT_ENCOCDER_TO_DISTANCE_RATIO = (3.5 * Math.PI) / (12.0 * 256.0);
  // Speed controllers
  private Talon leftDriveA = /*Jimmy.leftDriveA;*/new Talon(/*Jimmy.PWM_LEFT_MOTOR_1*/Constants.leftDrivePortA.getInt());
  private Talon leftDriveB = /*Jimmy.leftDriveB;*/ new Talon(/*Jimmy.PWM_LEFT_MOTOR_2*/Constants.leftDrivePortB.getInt());
//RGT  private Talon leftDriveC = new Talon(Constants.leftDrivePortC.getInt());
  private Talon rightDriveA = /*Jimmy.rightDriveA;*/ new Talon(/*Jimmy.PWM_RIGHT_MOTOR_1*/Constants.rightDrivePortA.getInt());
  private Talon rightDriveB = /*Jimmy.rightDriveB;*/ new Talon(/*Jimmy.PWM_RIGHT_MOTOR_2*/Constants.rightDrivePortB.getInt());
//RGT  private Talon rightDriveC = new Talon(Constants.rightDrivePortC.getInt());
  //Encoders
  private Encoder leftEncoder = new Encoder(/*Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A*/ Constants.leftEncoderPortA.getInt(),
                                            /*Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B */Constants.leftEncoderPortB.getInt(), 
                                            false);
  private Encoder rightEncoder = new Encoder(/*Jimmy.INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_A */Constants.rightEncoderPortA.getInt(),
                                             /*Jimmy.INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_B */Constants.rightEncoderPortB.getInt(),
                                             true);
  
  //Solenoids
//RGT  private Solenoid shifter = new Solenoid(Constants.shifterPort.getInt());
  //Gyro
  public ChezyGyro gyro;

  public void setLeftRightPower(double leftPower, double rightPower) {
    leftDriveA.set(leftPower);
    leftDriveB.set(leftPower);
//RGT    leftDriveC.set(leftPower);
    rightDriveA.set(-rightPower);
    rightDriveB.set(-rightPower);
//RGT    rightDriveC.set(-rightPower);
  }
  public Drivebase() {
    super("Drivebase");
//  System.out.println("Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A"+Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A+
//  "   Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B="+Jimmy.INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B);

    gyro = new ChezyGyro(/*Jimmy.INPUT_ANALOG_GYROSCOPE*/Constants.gyroPort.getInt());
    leftEncoder.start();
    rightEncoder.start();
  }

  public Hashtable serialize() {
    Hashtable leftDrive = new Hashtable();
    Hashtable rightDrive = new Hashtable();
    Hashtable encoders = new Hashtable();

    leftDrive.put("leftDriveA", new Double(leftDriveA.get()));
    leftDrive.put("leftDriveB", new Double(leftDriveB.get()));
//RGT    leftDrive.put("leftDriveC", new Double(leftDriveC.get()));

    rightDrive.put("rightDriveA", new Double(rightDriveA.get()));
    rightDrive.put("rightDriveB", new Double(rightDriveB.get()));
//RGT    rightDrive.put("rightDriveC", new Double(rightDriveC.get()));

    encoders.put("leftEncoder", new Double(leftEncoder.get()));
    encoders.put("rightEncoder", new Double(rightEncoder.get()));    
    data.put("leftDrive", leftDrive);
    data.put("rightDrive", rightDrive);
    data.put("encoders", encoders);
    data.put("gyro", new Double(getGyroAngle()));
    return data;
  }

  public Encoder getLeftEncoder() {
    return leftEncoder;
  }

  public double getLeftEncoderDistance() { // in feet
    return leftEncoder.get() * LEFT_ENCOCDER_TO_DISTANCE_RATIO;
  }

  public double getLeftEncoderDistanceInMeters() {
    return getLeftEncoderDistance() * 0.3048;
  }

  public Encoder getRightEncoder() {
    return rightEncoder;
  }

  public double getRightEncoderDistance() {
    return rightEncoder.get() * RIGHT_ENCOCDER_TO_DISTANCE_RATIO;
  }

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
    leftEncoder.reset();
    rightEncoder.reset();
  }
  
  public void update() {
    SmartDashboard.putNumber("driveLeftEncoder", getLeftEncoderDistance());
    SmartDashboard.putNumber("driveRightEncoder", getRightEncoderDistance());
    SmartDashboard.putNumber("gyro", getGyroAngle());
    super.update();
  }

}
