package com.team5053.frc2014.auto;

import com.team254.frc2014.AutoModeSelector.Configuration;
import com.team254.frc2014.auto.ConfigurationAutoMode;
import com.team254.frc2014.controllers.HoldPositionController;
import com.team254.frc2014.paths.AutoPaths;
import com.team254.lib.trajectory.Path;


/**
 *
 * @author Tom Botiglieri
 * @author Brandon Gonzales
 * @author Jared Russel
 * @author Art Kalb
 * @author Richard Topolewski
*/
public class FollowPathAuto extends ConfigurationAutoMode {

  protected boolean endsClose(Configuration config) {
    if (config.pathToTake >= 0 && config.pathToTake < AutoPaths.kPathNames.length) {
      return "RGTTry5".equals(AutoPaths.kPathNames[config.pathToTake]); 
    }
    return false;
  }
  
  public FollowPathAuto() {
    super("Follow Path Auton");
  }
  
  protected void routine() {
      System.out.println("routine entered in FollowPathAuto");
    drivebase.resetEncoders();
    headingController.setHeading(0);
    drivebase.useController(headingController);
    
    boolean endingClose = endsClose(config);
       
    Path path = AutoPaths.getByIndex(config.pathToTake);
    if (path == null) {
      path = AutoPaths.get("RGTTry5");
    }

   HoldPositionController holdPositionController;
      holdPositionController = headingController;
    
    // Turn on heading controller
    holdPositionController.setDistance(0);
    double endHeading = Math.toDegrees(path.getEndHeading());
    drivebase.resetEncoders();
    holdPositionController.setHeading(endHeading);
    drivebase.useController(holdPositionController);
    
   // Print out time
    System.out.println("Auto done at: " + autoTimer.get());
    
  }

}
