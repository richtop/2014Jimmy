package com.team254.frc2014;

/**
 * This is where the magic happens!
 *
 */
import com.team254.frc2014.auto.AerialAssistAuto;
import com.team254.frc2014.auto.DoNothingAuto;
//RGT import com.team254.frc2014.auto.TwoBallHotAutoMode;
import com.team254.frc2014.paths.AutoPaths;
import com.team254.lib.ChezyIterativeRobot;
import com.team254.lib.ChezyHTTPServer;
//RGT import com.team254.lib.util.Latch;
import com.team254.lib.util.ThrottledPrinter; // Limites printing of messages
import com.team5053.frc2014.auto.FollowPathAuto;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class ChezyCompetition extends ChezyIterativeRobot {
  AutoMode currentAutoMode = null;
  AutoModeSelector selector = new AutoModeSelector();
  ChezyHTTPServer s = new ChezyHTTPServer();
  ThrottledPrinter p = new ThrottledPrinter(.5);
  DriverStationLCD lcd;

  public void initAutoModes() {
    AutoPaths.loadPaths();
    selector.addAutoMode(new FollowPathAuto());
//RGT    selector.addAutoMode(new AerialAssistAuto());
//RGT    selector.ad/dAutoMode(new TwoBallHotAutoMode());
//RGT    selector.addAutoMode(new DoNothingAuto());
  }

  public void robotInit() {
    initAutoModes();
    lcd = DriverStationLCD.getInstance();
    ChezyRobot.initRobot();
//RGT    ChezyRobot.shooterController.enable();
    ChezyRobot.subsystemUpdater100Hz.start();
//RGT    lcdUpdateTimer.start();
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
//RGT    ChezyRobot.drivebase.setLowgear(false);
  }

  public void disabledInit() {
    Constants.readConstantsFromFile();
    if (currentAutoMode != null) {
      currentAutoMode.stop();
    }
    ChezyRobot.drivebase.turnOffControllers();
    ChezyRobot.drivebase.resetGyro();
//RGT    ChezyRobot.pinniped.wantFront = false;
//RGT    ChezyRobot.pinniped.wantRear = false;
//RGT    ChezyRobot.frontIntake.wantBumperGather = false;
//RGT    ChezyRobot.rearIntake.wantBumperGather = false;
//RGT    ChezyRobot.bannerHotGoalDetector.reset();
//RGT    ChezyRobot.pinniped.doingRunning = false;
    System.out.println("cfs:disable_start");
  }

  public void teleopInit() {
    if (currentAutoMode != null) {
      currentAutoMode.stop();
    }
    ChezyRobot.drivebase.turnOffControllers();
//RGT    ChezyRobot.frontIntake.setAutoIntake(false);
    ChezyRobot.drivebase.resetEncoders();
//RGT    ChezyRobot.shooter.setHood(false);
//RGT    ChezyRobot.shooterController.disable();
//RGT    ChezyRobot.shooterController.setVelocityGoal(0);
//RGT    ChezyRobot.pinniped.doingRunning = false;
    System.out.println("cfs:teleop_start");
    // This is just here for testing purposes
  }
//RGT  double wantedRpm = 4000;
//TODO understant the purpose of these
//RGT  Latch upLatch = new Latch();
//RGT  Latch downLatch = new Latch();
//RGT  Latch autoSelectLatch = new Latch();
//RGT  Latch laneSelectLatch = new Latch();
//RGT  Latch numBallsSelectLatch = new Latch();
//RGT  Latch startOnLeftLatch = new Latch();
//RGT  Latch endCloseLatch = new Latch();
//RGT  Latch gyroInitLatch = new Latch();

  public void teleopPeriodic() {
//RGT    double frontRollerPower = 0;
//RGT    double rearRollerPower = 0;
    // Intake Roller
//RGT    if (ChezyRobot.operatorJoystick.getIntakeButton()) {
//RGT      frontRollerPower = rearRollerPower = 1;
//RGT    } else if (ChezyRobot.operatorJoystick.getExhaustButton()) {
//RGT      frontRollerPower = rearRollerPower = -1;
//RGT    } else if (ChezyRobot.operatorJoystick.getPassFrontButton()) {
//RGT      frontRollerPower = -1;
//RGT    } else if (ChezyRobot.operatorJoystick.getPassRearButton()) {
//RGT      rearRollerPower = -1;
//RGT    }
  
    // Intakes
//RGT    if (ChezyRobot.operatorJoystick.getAutoIntakeOff()) { // manual intake
//RGT      ChezyRobot.pinniped.setControlLoopsOff();
//RGT      ChezyRobot.frontIntake.wantGather = false;
//RGT      ChezyRobot.rearIntake.wantGather = false;
//RGT      if (ChezyRobot.operatorJoystick.getAutoIntakeFrontButton()) {
//RGT        frontRollerPower = 1;
//RGT      } else if (ChezyRobot.operatorJoystick.getAutoIntakeRearButton()) {
//RGT        rearRollerPower = 1;
//RGT      }
//RGT      ChezyRobot.frontIntake.wantDown = ChezyRobot.operatorJoystick.getAutoIntakeFrontButton();
//RGT      ChezyRobot.rearIntake.wantDown = ChezyRobot.operatorJoystick.getAutoIntakeRearButton();
//RGT    } else { // auto intake
//RGT      ChezyRobot.pinniped.setControlLoopsOn();
//RGT      ChezyRobot.frontIntake.wantGather = ChezyRobot.operatorJoystick.getAutoIntakeFrontButton();
//RGT      ChezyRobot.rearIntake.wantGather = ChezyRobot.operatorJoystick.getAutoIntakeRearButton();
    }
    

    // Shooter presets
    // Off
//RGT    if (ChezyRobot.operatorJoystick.getShooterOffButton()) {
//RGT      ChezyRobot.shooterController.disable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(0);
//RGT      ChezyRobot.pinniped.doingRunning = false;
//RGT      ChezyRobot.shooterController.setNarrowOnTargetWindow();
//RGT    }
    // Running close
//RGT    if (ChezyRobot.operatorJoystick.getPreset1Button()) {
//RGT      ChezyRobot.pinniped.doingRunning = true;
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.cheekyPassPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.shooterController.setWideOnTargetWindow();
//RGT    }
    // static close
//RGT    if (ChezyRobot.operatorJoystick.getPreset2Button()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.staticClosePreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(true);
//RGT      ChezyRobot.pinniped.doingRunning = false;
//RGT      ChezyRobot.shooterController.setNarrowOnTargetWindow();
//RGT    }
//RGT    /`/ static Far
//RGT    if (ChezyRobot.operatorJoystick.getPreset3Button()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.staticFarPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.pinniped.doingRunning = false;
//RGT      ChezyRobot.shooterController.setNarrowOnTargetWindow();
//RGT    }
    // running far
//RGT    if (ChezyRobot.operatorJoystick.getPreset4Button()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.runningFarPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.pinniped.doingRunning = true;
//RGT      ChezyRobot.shooterController.setWideOnTargetWindow();
//RGT    }
    // Hella Far
//RGT    if (ChezyRobot.operatorJoystick.getPreset6Button()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.hellaFarPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.pinniped.doingRunning = true;
//RGT      ChezyRobot.shooterController.setWideOnTargetWindow();
//RGT    }
    // HP Shot
//RGT    if (ChezyRobot.operatorJoystick.getPreset5Button()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.hpShotPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.pinniped.doingRunning = true;
//RGT      ChezyRobot.shooterController.setWideOnTargetWindow();
//RGT    }
    
    // Inbounding
//RGT    ChezyRobot.operatorJoystick.autonInboundButton.update();
//RGT    boolean wantCatcherOpen = ChezyRobot.operatorJoystick.autonInboundButton.get() || ChezyRobot.operatorJoystick.getNoMotorInboundButton();
//RGT    ChezyRobot.shooter.wantCatcherOpen = wantCatcherOpen;
//RGT    if (wantCatcherOpen) {
//RGT      ChezyRobot.shooter.setHood(false);
//RGT    }
//RGT    if (ChezyRobot.operatorJoystick.autonInboundButton.wasPressed()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(Constants.inboundRpmPreset.getDouble());
//RGT      ChezyRobot.shooter.setHood(false);
//RGT      ChezyRobot.pinniped.doingRunning = false;
//RGT    } else if (ChezyRobot.operatorJoystick.autonInboundButton.wasReleased()) {
//RGT      ChezyRobot.shooterController.enable();
//RGT      ChezyRobot.shooterController.setVelocityGoal(0);
//RGT      ChezyRobot.pinniped.doingRunning = false;
//RGT      ChezyRobot.shooterController.setNarrowOnTargetWindow();
//RGT    }


    
    // Shooting Buttons
//RGT    ChezyRobot.pinniped.wantShot = ChezyRobot.pinniped.wantTimedShot =  ChezyRobot.leftStick.getRawButton(1);
    
    // Pass buttons
//RGT    ChezyRobot.pinniped.wantFront = ChezyRobot.operatorJoystick.getPassRearButton();
//RGT    ChezyRobot.pinniped.wantRear = ChezyRobot.operatorJoystick.getPassFrontButton();
    
    // Run the rear roller in reverse if needed
//RGT    ChezyRobot.rearIntake.wantShoot = ChezyRobot.pinniped.wantShot;

    // Gearing
//RGT    if(ChezyRobot.rightStick.getRawButton(2)) {
//RGT      ChezyRobot.drivebase.setLowgear(true);
//RGT    } else {
//RGT      ChezyRobot.drivebase.setLowgear(false);
//RGT    }
    
    // Cheesy Drive
//RGT    boolean qt = ChezyRobot.rightStick.getTrigger();
//RGT    double turn = ChezyRobot.rightStick.getX();
//RGT    if (qt) {
      // Square the inputs on turn in quick turn
//RGT      boolean turnNeg = turn < 0.0;
//RGT      turn = Math.abs(turn * turn) * (turnNeg ? -1.0 : 1.0);
//RGT    }
    
//RGT    ChezyRobot.cdh.cheesyDrive(-ChezyRobot.leftStick.getBorkedY(), turn, qt, !ChezyRobot.rightStick.getRawButton(2));

    
    // Set rollers
//RGT    ChezyRobot.frontIntake.setManualRollerPower(frontRollerPower);
//RGT    ChezyRobot.rearIntake.setManualRollerPower(rearRollerPower);
 
//RGT    ChezyRobot.settler.set(ChezyRobot.leftStick.getRawButton(2));
//RGT  }

  
//RGT  public void allPeriodic() {
//RGT    if (downLatch.update(ChezyRobot.operatorJoystick.getRawButton(3))) {
//RGT      wantedRpm -= 50;
//RGT    }
//RGT    if (upLatch.update(ChezyRobot.operatorJoystick.getRawButton(4))) {
//RGT      wantedRpm += 50;
//RGT    }
//RGT    if (wantedRpm > 10000) {
//RGT      wantedRpm = 10000;
//RGT    } else if (wantedRpm < 0) {
//RGT      wantedRpm = 0;
//RGT    }
    
//RGT    lcd();
    
//RGT    if(ChezyRobot.shooterController.onTarget() && ChezyRobot.shooterController.enabled() && Math.abs(ChezyRobot.shooterController.getVelocityGoal()) > 0) {
//RGT      ChezyRobot.shooter.shooterLed.set(true);
//RGT      ChezyRobot.shooter.shooterLedRelay.set(Relay.Value.kForward);
//RGT    } else {
//RGT      ChezyRobot.shooter.shooterLed.set(false);
//RGT      ChezyRobot.shooter.shooterLedRelay.set(Relay.Value.kOff);
//RGT    }
//RGT  }

//RGT  public void disabledPeriodic() {
//RGT    if (autoSelectLatch.update(ChezyRobot.operatorJoystick.getShooterOffButton() && ChezyRobot.operatorJoystick.getPreset2Button() && ChezyRobot.operatorJoystick.getNoMotorInboundButton())) { //secrets!
//RGT      selector.increment();
//RGT    }
//RGT    if (laneSelectLatch.update(ChezyRobot.operatorJoystick.getIntakeButton())) {
//RGT      selector.incrementLane();
//RGT    }
//RGT    if (numBallsSelectLatch.update(ChezyRobot.operatorJoystick.getPassFrontButton())) {
//RGT      selector.decrementNumBalls();
//RGT    }
//RGT    if (startOnLeftLatch.update(ChezyRobot.operatorJoystick.getExhaustButton())) {
//RGT      selector.toggleStartOnLeft();
//RGT    }
//RGT    if (endCloseLatch.update(ChezyRobot.operatorJoystick.getPassRearButton())) {

//RGT    }
    
//RGT    if (gyroInitLatch.update(ChezyRobot.operatorJoystick.getPreset6Button())) {
//RGT      ChezyRobot.drivebase.gyro.initGyro();
//RGT    }
//RGT    ChezyRobot.drivebase.setLowgear(false);
//RGT  }

  // LCD
  //RGTTimer lcdUpdateTimer = new Timer();
  //RGTpublic void lcd() {
  //RGT  if (lcdUpdateTimer.get() < .1) {
  //RGT    return;
  //RGT  }
  //RGT  lcdUpdateTimer.reset();
  //RGT  lcd.println(DriverStationLCD.Line.kUser1, 1, "M:" + selector.currentAutoMode().getDescription() + "                  ");
  //RGT  lcd.println(DriverStationLCD.Line.kUser2, 1, "#B:" +  selector.getNumBallsWithPreference() +  "            ");
  //RGT  lcd.println(DriverStationLCD.Line.kUser3, 1, "Path: " +  selector.getPathName() + "           ");
  //RGT  lcd.println(DriverStationLCD.Line.kUser4, 1, "Side:" + (selector.getStartOnLeft() ? "Left" : "Right") + " | VIZ:" + (ChezyRobot.visionHotGoalDetector.hasClientConnection() ? "Yes":"No") + "      ");
  //RGT  lcd.println(DriverStationLCD.Line.kUser6, 1,  Math.floor(Timer.getFPGATimestamp() * 10) / 10 +  " gyro: " + Math.floor(ChezyRobot.drivebase.getGyroAngle() * 10) / 10 + "        ");
  //RGT  lcd.println(DriverStationLCD.Line.kUser5, 1, "HOT: " + ChezyRobot.hotGoalDirection + "          "); 
  //RGT  lcd.updateLCD();
  //RGT}
}
