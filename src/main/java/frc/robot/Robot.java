// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.POVButton;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   * 
   */
   // Motors
   public static final TalonSRX leftMotor = new TalonSRX(1);
   public static final TalonSRX rightMotor = new TalonSRX(2);
   
   //Controller
   public static final Joystick joystick = new Joystick(0);
   //public static final POVButton up = new POVButton(joystick, 0);
   //public static final POVButton down = new POVButton(joystick, 180);

   //Mecanism
   public static final Spark arm = new Spark(0);





  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    //Drivetrain + DriveArcade
    double speed = -joystick.getRawAxis(1) * 0.6;
    double turn = joystick.getRawAxis(4) * 0.3;
    double armRotate = joystick.getPOV();
    

    double left = speed + turn;
    double right = speed - turn;

    leftMotor.set(ControlMode.PercentOutput, left);
    rightMotor.set(ControlMode.PercentOutput, right);


    // POV Button
    //POVButton[] dpad = new POVButton[] {up, down};

    //Mecanism
    if(armRotate == 0) {
      arm.setSpeed(-0.1);
    } else {
      if(armRotate == 180) {
        arm.setSpeed(0.1);
      }
    }
     

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
