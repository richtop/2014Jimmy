package com.team254.frc2014.auto;

import com.team254.frc2014.AutoModeSelector.Configuration;
import com.team254.frc2014.controllers.HoldPositionController;
import com.team254.frc2014.paths.AutoPaths;
import com.team254.lib.trajectory.Path;


/**
 *
 * @author Tom Botiglieri
 * @author Brandon Gonzales
 * @author Jared Russel
 * @author Art Kalb
 */
public class AerialAssistAuto extends ConfigurationAutoMode {

  protected boolean endsClose(Configuration config) {
    if (config.pathToTake >= 0 && config.pathToTake < AutoPaths.kPathNames.length) {
      return "InsideLanePathClose".equals(AutoPaths.kPathNames[config.pathToTake]); 
    }
    return false;
  }
  
  public AerialAssistAuto() {
    super("Default auto mode");
  }
  
  protected void routine() {
    drivebase.resetEncoders();
    headingController.setHeading(0);
    drivebase.useController(headingController);
    
    boolean endingClose = endsClose(config);
    
//RGT    // Start voting 
//RGT    visionHotGoalDetector.reset();
//RGT    visionHotGoalDetector.startSampling();
   
//RGT2    if (endingClose) {
//RGT2      wantedStartRpm = config.numBalls == 0 ? 0 : config.numBalls > 1 ? closeIntakeDownPreset : closeIntakeUpPreset;
//RGT2    } else {
//RGT2      wantedStartRpm = config.numBalls == 0 ? 0 : config.numBalls > 1 ? farIntakeDownPreset : farIntakeUpPreset;
//RGT2    }

//RGT    // Settler down
//RGT    settler.set(true);
//RGT    
//RGT    // Grab balls from ground
//RGT    pinniped.wantFront = false;
//RGT    pinniped.wantRear = false;
//RGT    frontIntake.wantBumperGather = config.numBalls == 3 || (config.numBalls == 2 && !config.preferRearBall);
//RGT    rearIntake.wantBumperGather = config.numBalls == 3 || (config.numBalls == 2 && config.preferRearBall);
//RGT    
//RGT    // Turn on wheel
//RGT    shooterController.enable();
//RGT    System.out.println("Using " + wantedStartRpm + " RPM for first shot");
//RGT    shooterController.setVelocityGoal(wantedStartRpm);
    
    // Wait for interrupt from hot goal sensor
    double howLongToWait = 1.5;
    if (config.pathToTake == AutoPaths.WALL_LANE_ID) {
      howLongToWait = 1.2;
    }
    waitUntilTime(howLongToWait);
    
    Path path = AutoPaths.getByIndex(config.pathToTake);
    if (path == null) {
      path = AutoPaths.get("InsideLanePathFar");
    }

//RGT    drivePathWithFlip(path, visionHotGoalDetector, 10);
//RGT    visionHotGoalDetector.stopSampling();

    System.out.println("Finished driving at: " + autoTimer.get());
   
    
    // Maybe activate steering controller for dekes
    //RGT steering based on vision system
    boolean doSteer = config.doSteer;
    HoldPositionController holdPositionController;
//RGT    if (doSteer) {
//RGT      holdPositionController=  steerHeadingController;
//RGT      // Reset steering stuf
//RGT      steerHeadingController.reset();
//RGT      visionHotGoalDetector.reset();
//RGT      visionHotGoalDetector.startSampling();
//RGT    } else {
      holdPositionController = headingController;
//RGT    }
    
    // Turn on heading controller
    holdPositionController.setDistance(0);
    double endHeading = Math.toDegrees(path.getEndHeading());
    drivebase.resetEncoders();
    holdPositionController.setHeading(endHeading);
    drivebase.useController(holdPositionController);
    
    // Wait until hot goal is about to switch
//RGT2    waitUntilTime(4.5);
    
    
    // Last shot rpm
//RGT2    wantedEndRpm = endingClose ? closeIntakeUpPreset : farIntakeUpPreset;
//RGT2    System.out.println("Using " + wantedEndRpm + " RPM for end shots");
 
//RGT    if (config.numBalls == 3) {
//RGT      shootThree();
//RGT    } else if (config.numBalls == 2) {
//RGT      if (config.preferRearBall) {
//RGT        shootTwoWithRearBall();
//RGT      } else {
//RGT        shootTwoWithFrontBall();
//RGT      }
//RGT    } else if (config.numBalls == 1)  {
//RGT      shootOne();
//RGT    }
 
    // Print out time
    System.out.println("Auto done at: " + autoTimer.get());
    
//RGT    // Clean up
//RGT    rearIntake.setManualRollerPower(0);
//RGT    shooterController.setVelocityGoal(0);
  }

}
