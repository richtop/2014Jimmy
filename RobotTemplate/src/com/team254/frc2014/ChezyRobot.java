package com.team254.frc2014;

import com.team254.frc2014.controllers.HoldPositionController;
//RGT import com.team254.lib.OpenLoopController;
//RGTimport com.team254.frc2014.controllers.RpmFlywheelController;
//RGTimport com.team254.frc2014.controllers.SteerableHoldPositionController;
import com.team254.frc2014.controllers.TrajectoryDriveController;
//RGTimport com.team254.frc2014.hotgoal.BannerHotGoalDetector;
//RGTimport com.team254.frc2014.hotgoal.CheesyVisionHotGoalDetector;
import com.team254.frc2014.subsystems.*;
import com.team254.lib.MultiLooper;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * ChezyRobot defines all of the subsystems.
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class ChezyRobot {

  static {
    poke();
  }

  // this method does nothing. It is here to combat Java's lazy loading of static classes.
  private static void poke() {} 
  
  // Subsystems
  public static final Drivebase drivebase = new Drivebase();
  //RGTpublic static final Shooter shooter = new Shooter();
  public static final Compressor compressor = new Compressor(Constants.pressureSwitch.getInt(), Constants.compressorRelay.getInt());
  //RGTpublic static final Pinniped pinniped = new Pinniped();
  
  // Set up the intakes
  public static final Talon frontIntakeRoller = new Talon(Constants.frontIntakeRollerPort.getInt());
  public static final Solenoid frontIntakeSolenoid = new Solenoid(Constants.frontIntakeSolenoidPort.getInt());
  public static final AnalogChannel frontIntakeSwitch = new AnalogChannel(Constants.frontIntakeSwitchPort.getInt());
  
  public static final Talon rearIntakeRoller = new Talon(Constants.rearIntakeRollerPort.getInt());
  public static final Solenoid rearIntakeSolenoid = new Solenoid(Constants.rearIntakeSolenoidPort.getInt());
  public static final AnalogChannel rearIntakeSwitch = new AnalogChannel(Constants.rearIntakeSwitchPort.getInt());
  
  //RGT public static final Intake frontIntake = new Intake("Front Intake", frontIntakeRoller, frontIntakeSwitch, frontIntakeSolenoid, true, 1.0);
  //RGT public static final Intake rearIntake = new Intake("Rear Intake", rearIntakeRoller, rearIntakeSwitch, rearIntakeSolenoid, true, .65);
  
  //RGT public static final CheesyDriveHelper cdh = new CheesyDriveHelper(drivebase);
  
  //RGT public static final BorkedJoystick leftStick = new BorkedJoystick(Constants.leftJoystickPort.getInt());
  public static final Joystick rightStick = new Joystick(Constants.rightJoystickPort.getInt());
  //RGT public static final OperatorJoystick operatorJoystick = new OperatorJoystick(Constants.gamepadPort.getInt());
  //RGT public static final AutoModeSelector ams = new AutoModeSelector();

  public static final Solenoid settler = new Solenoid(Constants.settlerSolenoidPort.getInt());
  public static final Solenoid popUpPistion = settler;
  
  // Controllers
  public static MultiLooper subsystemUpdater100Hz = new MultiLooper(1.0 / 100.0);
  public static TrajectoryDriveController driveController = new TrajectoryDriveController();
  public static HoldPositionController headingController = new HoldPositionController();
  //RGT public static SteerableHoldPositionController steerHeadingController = new SteerableHoldPositionController();
  public static Navigator navigator = new Navigator(drivebase);
  //RGT public static OpenLoopController openLoopShooterController = new OpenLoopController(shooter);
  //RGT public static final RpmFlywheelController shooterController = new RpmFlywheelController("ShooterController", shooter, shooter, ShooterGains.getGains()[0], 1.0/100.0);
  
  //RGT public static final BannerHotGoalDetector bannerHotGoalDetector = new BannerHotGoalDetector();
  //RGT public static final CheesyVisionHotGoalDetector visionHotGoalDetector = new CheesyVisionHotGoalDetector();
  //RGT public static final Thread hotGoalThread = new Thread(visionHotGoalDetector);
  
  public static String hotGoalDirection = "UNSURE";

  public static void initRobot() {
    // Add all subsystems to a 100Hz Looper
    subsystemUpdater100Hz.addLoopable(drivebase);
    //RGT subsystemUpdater100Hz.addLoopable(frontIntake);
    //RGT subsystemUpdater100Hz.addLoopable(rearIntake);
    subsystemUpdater100Hz.addLoopable(navigator);
    //RGT subsystemUpdater100Hz.addLoopable(pinniped);
    //RGT subsystemUpdater100Hz.addLoopable(shooter);
    
    //RGT hotGoalThread.start();
    
    compressor.start();
    //RGT shooter.useController(shooterController);
  }
}
