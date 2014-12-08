package com.team254.frc2014;

import com.team254.frc2014.ChezyRobot;
import com.team254.frc2014.Constants;
import com.team254.frc2014.actions.Action;
import com.team254.frc2014.actions.DriveAction;
import com.team254.frc2014.actions.DrivePathAction;
//import com.team254.frc2014.actions.DrivePathWithPathFlipperAction;
import com.team254.frc2014.actions.WaitAction;
//import com.team254.frc2014.actions.WaitForHotGoalToSwitchAction;
import com.team254.frc2014.actions.WaitUntilAutonTimeAction;
//import com.team254.frc2014.hotgoal.HotGoalDetector;
import com.team254.lib.trajectory.Path;
import edu.wpi.first.wpilibj.Timer;

/**
 * AutoMode provides a model which all autonomi will follow.
 */
public abstract class AutoMode extends ChezyRobot implements Runnable {

  Action currentAction = null;
  Thread autoThread = new Thread(this);
  private boolean alive = true;
  protected String description;
  protected Timer autoTimer = new Timer();

  protected double farIntakeUpPreset = Constants.autonFarIntakeUpPreset.getDouble();
  protected double farIntakeDownPreset = Constants.autonFarIntakeDownPreset.getDouble();
  protected double closeIntakeUpPreset = Constants.autonClosePreset.getDouble();
  protected double closeIntakeDownPreset = closeIntakeUpPreset - 50;
  protected double wantedStartRpm = farIntakeDownPreset;
  protected double wantedEndRpm = farIntakeUpPreset;
    
  
  public AutoMode(String description) {
    this.description = description;
  }

  protected abstract void routine();

  public String getDescription() {
    return description;
  }

  public void run() {
    System.out.println("Starting auto mode!");
    try {
      autoTimer.reset();
      autoTimer.start();
      routine();
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Ending auto mode!");
  }

  public void start() {
    stop();
    alive = true;
    autoThread = new Thread(this);
    autoThread.start();
  }

  public void stop() {
    stopCurrentAction();
    alive = false;
  }

  public void stopCurrentAction() {
    if (currentAction != null) {
      currentAction.kill();
    }
  }

  public void startCurrentAction() {
    if (currentAction != null) {
      currentAction.run();
    }
  }

  public void runAction(Action action) {
    if (alive) {
      stopCurrentAction();
      currentAction = action;
      startCurrentAction();
    }
  }
  

  public void drive(double feet, double timeout) {
    runAction(new DriveAction(feet, timeout));
  }
  

  public void driveAndCoast(double feet, double timeout) {
    runAction(new DriveAction(feet, 0, false, timeout));
  }
  public void driveArc(double feet, double heading, double timeout) {
    runAction(new DriveAction(feet, heading, false, timeout));
  }
  
  public void waitTime(double seconds) {
    runAction(new WaitAction(seconds));
  }
  
  public void waitUntilTime(double seconds) {
    runAction(new WaitUntilAutonTimeAction(autoTimer, seconds));
  }

  public void dimeStop() {
    drive(0, 0.25);
  }
  
  public void drivePath(Path r, double timeout) {
    runAction(new DrivePathAction(r, timeout)); 
  }
  
//RGT  public void drivePathWithFlip(Path r, HotGoalDetector detector, double timeout) {
//RGT    runAction(new DrivePathWithPathFlipperAction(r, detector, timeout)); 
//RGT  }

}
