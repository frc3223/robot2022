// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

/** An example command that uses an example subsystem. */
public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_subsystem;
  private final Joystick m_driverController;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Drive(DriveTrain subsystem, Joystick driverController) {
    this.m_subsystem = subsystem;
    this.m_driverController = driverController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    //Constants.DRIVER_CONTROLLER_TANK_RIGHT
    double leftStick = m_driverController.getRawAxis(5); //right joystick up down
    //Constants.DRIVER_CONTROLLER_TANK_LEFT
    double rightStick = m_driverController.getRawAxis(10); //left joystick up down

    if(leftStick*rightStick < 0){
      //Turning make it slower
      //Constants.TANK_DRIVE_SPEED_RATIO
      m_subsystem.tankDrive(leftStick*0.8, rightStick*0.8);
    }else{
      m_subsystem.tankDrive(leftStick, rightStick);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    m_subsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
