/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team5053.frc2014;


import com.team254.frc2014.AutoMode;
import com.team254.frc2014.AutoModeSelector;
import com.team254.frc2014.ChezyRobot;
import com.team254.frc2014.paths.AutoPaths;
import com.team254.lib.ChezyHTTPServer;
import com.team254.frc2014.actions.Action;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//RGT this is like ChezyCompetition, which is "slightly modified version of interative robot
public class Jimmy extends /*com.team254.frc2014.*/ IterativeRobot /*implments loopable*/{

  AutoMode currentAutoMode = null;
  AutoModeSelector selector = new AutoModeSelector();
  ChezyHTTPServer s = new ChezyHTTPServer();


    
// DEFINE DIGITIAL SIDE CAR CONNECTIONS    
// Define Pulse Width Module (PWM) Connections    
    public static int PWM_LEFT_MOTOR_1   = 1;
    public static int PWM_LEFT_MOTOR_2   = 4;
    public static int PWM_RIGHT_MOTOR_1  = 2;
    public static int PWM_RIGHT_MOTOR_2  = 5;

    public static int PWM_BALL_MOTOR     = 3;
    
    public static int PWM_REAR_RIGHT_NET_MOTOR = 6;
    public static int PWM_FRONT_LEFT_NET_MOTOR = 8;
    
 // INPUTS  
 ///Analog Input
    public static int INPUT_ANALOG_ULTRASONIC = 1;
    public static int INPUT_ANALOG_GYROSCOPE  = 2;
    
  //Digital Input  
    public static int INPUT_DIGITAL_LIMIT_SWITCH_NET_FRONT_LEFT_OPEN   = 3;
    public static int INPUT_DIGITAL_LIMIT_SWITCH_NET_FRONT_LEFT_CLOSED = 4;
    public static int INPUT_DIGITAL_LIMIT_SWITCH_NET_REAR_RIGHT_OPEN   = 5;
    public static int INPUT_DIGITAL_LIMIT_SWITCH_NET_REAR_RIGHT_CLOSED = 6;
    
    public static int INPUT_DIGITAL_AUTONOMOUS_SWITCH                  = 7;
    
    public static int INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_A            = 9;
    public static int INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_B            = 10;
    
    public static int INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A             = 11;
    public static int INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B             = 12;
    
// Define Controller connections (USB Connection order)
    public static int JOYSTICK_1 = 1; // 1st plugged into the computer 
    public static int JOYSTICK_2 = 2;

// Local use
   // Set this as a flag for Autonomous Periodic loop to know when it is the firt time through 
    boolean isFirstTimeInAuton = true;
    // This will keep track of the time in autonomouse
    double autonStartTime = 0.0;
    
// Define Input
    
    
    Joystick  joystick1 = new Joystick(JOYSTICK_1);
    Joystick  joystick2 = new Joystick(JOYSTICK_2);
    RobotDrive mainDrive = new RobotDrive(PWM_LEFT_MOTOR_1, PWM_LEFT_MOTOR_2,
                                          PWM_RIGHT_MOTOR_1, PWM_RIGHT_MOTOR_2);
    Encoder encoderRight = new Encoder(INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_A,
                                       INPUT_DIGITAL_ENCODER_RIGHT_CHANNEL_B);
    Encoder encoderLeft = new Encoder(INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_A,
                                      INPUT_DIGITAL_ENCODER_LEFT_CHANNEL_B);
   
    public Jimmy() {
          ChezyHTTPServer s = new ChezyHTTPServer();
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        AutoPaths.loadPaths();

        boolean isFirstTimeInAuton = true;
    }
  public void autonomousInit() {
    ChezyRobot.drivebase.resetGyro();
    
//RGT    ChezyRobot.shooterController.enable();
//RGT    ChezyRobot.pinniped.setControlLoopsOff();
    currentAutoMode = selector.currentAutoMode();
//RGT    ChezyRobot.pinniped.doingRunning = false;
    if (currentAutoMode != null) {
      currentAutoMode.start();
    }
    System.out.println("cfs:auto_start");
//    ChezyRobot.drivebase.setLowgear(false);
  }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
       if(isFirstTimeInAuton){
          isFirstTimeInAuton = false;
          autonStartTime = Timer.getFPGATimestamp();
          System.out.println("autonStartTime = "+autonStartTime);
       }
       double autonTime = Timer.getFPGATimestamp()-autonStartTime;
         System.out.println("Timer.getFPGATimestamp( = "+Timer.getFPGATimestamp()
                          + "     autonTime = " + autonTime);
         if((autonTime) < 1 ){        
//              mainDrive.setSafetyEnabled(false);
              mainDrive.drive(-0.25,0.0);
//              Timer.delay(0.1);
         }
         else{
              mainDrive.drive(0.0,0.0);
         }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        // For when practicing  this reset sso Autonomoou can be run again.
        isFirstTimeInAuton = true;
        mainDrive.arcadeDrive(joystick1);
         
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    // Added because Cheezy Poofs had it but don't think need it.
    public void disabledPeriodic() {
    }
}
