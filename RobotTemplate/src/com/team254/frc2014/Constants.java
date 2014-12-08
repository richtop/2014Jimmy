package com.team254.frc2014;

import com.team254.lib.util.ConstantsBase;

/**
 * Manages constant values used everywhere in the robot code.
 * Variables can be declared here with default values and overridden with a text file uploaded to
 * the robot's file system.
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */

public class Constants extends ConstantsBase {
  // Declare the constants and their default values here.

  // Control board mappings
//RGT  public static final Constant leftJoystickPort = new Constant("leftJoystickPort", 1);
  public static final Constant leftJoystickPort = new Constant("leftJoystickPort", 1);
//RGT  public static final Constant rightJoystickPort = new Constant("rightJoystickPort", 2);
  public static final Constant rightJoystickPort = new Constant("rightJoystickPort", 2);
  //RGT  public static final Constant gamepadPort = new Constant("gamepadPort", 3);

  // Speed controller mappings
//RGT  public static final Constant leftDrivePortA = new Constant("leftDrivePortA", 6);
//RGT  public static final Constant leftDrivePortB = new Constant("leftDrivePortB", 7);
  public static final Constant leftDrivePortA = new Constant("leftDrivePortA", 1);
  public static final Constant leftDrivePortB = new Constant("leftDrivePortB", 4);
//RGT  public static final Constant leftDrivePortC = new Constant("leftDrivePortC", 8);
//RGT  public static final Constant rightDrivePortA = new Constant("rightDrivePortA", 3);
//RGT  public static final Constant rightDrivePortB = new Constant("rightDrivePortB", 4);
  public static final Constant rightDrivePortA = new Constant("rightDrivePortA", 2);
  public static final Constant rightDrivePortB = new Constant("rightDrivePortB", 5);
//RGT  public static final Constant rightDrivePortC = new Constant("rightDrivePortC", 5);

//RGT  public static final Constant frontIntakeRollerPort = new Constant("frontIntakeRollerPort", 1);
//RGT  public static final Constant rearIntakeRollerPort = new Constant("rearIntakeRollerPort", 10);

//RGT  public static final Constant leftShooterWheelPort = new Constant("leftShooterWheelPort", 9);
//RGT  public static final Constant rightShooterWheelPort = new Constant("rightShooterWheelPort", 2);

  // Solenoids
//RGT  public static final Constant pressureSwitch = new Constant("pressureSwitch",  14);
//RGT  public static final Constant compressorRelay = new Constant("compressorRelay", 1);
//RGT  public static final Constant shooterLed = new Constant("shooterLed", 10);
//RGT  public static final Constant shooterLedRelay = new Constant("shooterLedRelay", 2);
//RGT  public static final Constant shifterPort = new Constant("shifterPort", 1);
//RGT  public static final Constant catcherSolenoidPort = new Constant("catcherSolenoidPort", 2);
//RGT  public static final Constant settlerSolenoidPort = new Constant("settlerSolenoidPort", 8);
//RGT  public static final Constant rearClapperSolenoidPort = new Constant("rearClapperSolenoidPort", 3); 
//RGT  public static final Constant frontClapperSolenoidPort = new Constant("frontClapperSolenoidPort", 4); 
//RGT  public static final Constant hoodSolenoidPort = new Constant("hoodSolenoidPort", 7);
//RGT  public static final Constant frontIntakeSolenoidPort = new Constant("frontIntakeSolenoidPort", 5);
//RGT  public static final Constant rearIntakeSolenoidPort = new Constant("rearIntakeSolenoidPort", 6);

  // Operator control mappings
//RGT  public static final Constant autonSelectControlPort = new Constant("autonSelectControlPort",11);

  // Sensor mappings
//RGT  public static final Constant gyroPort = new Constant("gyroPort", 1);
  public static final Constant gyroPort = new Constant("gyroPort", 2);
  // Drive encoders
//RGT  public static final Constant leftEncoderPortA = new Constant("leftEncoderPortA", 1);
//RGT  public static final Constant leftEncoderPortB = new Constant("leftEncoderPortB", 2);
//RGT  public static final Constant rightEncoderPortA = new Constant("rightEncoderPortA", 3);
//RGT  public static final Constant rightEncoderPortB = new Constant("rightEncoderPortB", 4);
  public static final Constant rightEncoderPortA = new Constant("rightEncoderPortA", 9);
  public static final Constant rightEncoderPortB = new Constant("rightEncoderPortB", 10);
  public static final Constant leftEncoderPortA = new Constant("leftEncoderPortA", 11);
  public static final Constant leftEncoderPortB = new Constant("leftEncoderPortB", 12);

  // Shooter encoders
//RGT  public static final Constant shooterReflectorPort = new Constant("shooterReflectorPort", 13);
  
  // Drive tuning
  public static final Constant sensitivityHigh = new Constant("sensitivityHigh", .75);
  public static final Constant sensitivityLow = new Constant("sensitivityLow", .75);


//RGT  public static final Constant frontIntakeSwitchPort = new Constant("frontIntakeSwitchPort", 2);
//RGT  public static final Constant rearIntakeSwitchPort = new Constant("rearIntakeSwitchPort", 3);
  
//RGT  public static final Constant intakeUpButtonPort = new Constant("intakeUpPort", 10);
//RGT  public static final Constant intakeDownButtonPort = new Constant("intakeDownPort", 9);
//RGT  public static final Constant intakeDownSwitchPort = new Constant("intakeDownSwitchPort", 12);
  
//RGT  public static final Constant frontIntakeEncoderPortA = new Constant("frontIntakeEncoderPortA", 6);
//RGT  public static final Constant frontIntakeEncoderPortB = new Constant("frontIntakeEncoderPortB", 12);
  
//RGT  public static final Constant rearIntakeEncoderPortA = new Constant("frontIntakeEncoderPortA", 7);
//RGT  public static final Constant rearIntakeEncoderPortB = new Constant("frontIntakeEncoderPortB", 8);
  
  public static final Constant robotWidth = new Constant("robotWidth", 25.5 / 12.0);
  public static final Constant robotDt = new Constant("robotDt", 1.0 / 100.0);
    
  public static final Constant rearRollerShootPower = new Constant("rearRollerShootPower", 0.5);
  
  public static final Constant runningClosePreset = new Constant("runningClosePreset", 5200);
  public static final Constant runningFarPreset = new Constant("runningFarPreset", 4900);
  public static final Constant staticFarPreset = new Constant("staticFarPreset", 5250);
  public static final Constant staticClosePreset = new Constant("staticClosePreset", 4275);
  public static final Constant hellaFarPreset = new Constant("hellaFarPreset", 10000);
  public static final Constant hpShotPreset = new Constant("hpShotPreset", 5600);
  public static final Constant cheekyPassPreset = new Constant("cheekyPassPreset", 2750);
  public static final Constant inboundRpmPreset = new Constant("inboundRpmPreset", -2600);
  
  public static final Constant autonFarIntakeUpPreset = new Constant("autonFarIntakeUpPreset", 5200);
  public static final Constant autonFarIntakeDownPreset = new Constant("autonFarIntakeDownPreset", 4950);
  public static final Constant autonClosePreset = new Constant("autonClosePreset", 5700);
  
  
  public static final Constant headingKp = new Constant("headingKp", -0.035);
  public static final Constant headingKpFar = new Constant("headingKpFar", -0.01);
  public static final Constant headingKi = new Constant("headingKi", -0.0002);
  
  
  public static final double fieldWidth = 26.0;
  public static final double distanceToWhiteLine = 18.0;
  
  static {
    // Set any overridden constants from the file on startup.
    readConstantsFromFile();
  }

  // Prevent instantiation of this class, as it should only be used statically.
  private Constants() {
  }
}
