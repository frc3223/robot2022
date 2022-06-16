// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;

public class Drive extends CommandBase {
  
  private final DriveTrain m_driveTrain;
  private final Joystick m_driverController;

  public Drive(DriveTrain driveTrain, Joystick driverController) {
    this.m_driveTrain = driveTrain;
    this.m_driverController = driverController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    //Use Rockslide ArcadeDrive?
    rockSlideArcadeDrive();

    //Use tankDrive from 2020 Robot by default
    //tankDrive2020();

  }

  public void tankDrive2020()
  {
      //taken from Robot2020 tankDrive command
    //Constants.DRIVER_CONTROLLER_TANK_RIGHT
    double leftStick = m_driverController.getRawAxis(1); //right joystick up down
    //Constants.DRIVER_CONTROLLER_TANK_LEFT
    double rightStick = m_driverController.getRawAxis(5); //left joystick up down

    if(leftStick > 0.1 || rightStick > 0.1){
      //Turning make it slower
      //Constants.TANK_DRIVE_SPEED_RATIO
      m_driveTrain.tankDrive(leftStick*0.8, rightStick*0.8);
    }else{
      m_driveTrain.tankDrive(leftStick, rightStick);
    }
  }
  public void rockSlideArcadeDrive()
  {
        //from Rockslide (robot 2018):
        double fastForward = m_driverController.getRawAxis(1);
        double fastTurn = m_driverController.getRawAxis(0);
    
        //xbox controller
        //double slowForward = m_driverController.getRawAxis(5);
        //double slowTurn = m_driverController.getRawAxis(4);
    
        //logitech controller
        double slowForward = m_driverController.getRawAxis(2);
        double slowTurn = m_driverController.getRawAxis(3);
        if(Math.abs(fastForward) > 0.1 || Math.abs(fastTurn) > 0.1){
          this.m_driveTrain.arcadeDrive(fastForward, fastTurn);
        }else if(Math.abs(slowForward) < 0.2 || Math.abs(slowTurn) < 0.2){
          this.m_driveTrain.arcadeDrive(slowForward*0.3, slowTurn*0.5);
        }else{
          this.m_driveTrain.arcadeDrive(0, 0);
        }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
