// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrain;
  private final Drive m_Drive;
  private final ElevatorTest m_ElevatorTest;
  private final Elevator m_Elevator;
  private final Intake m_Intake;
  private final Grabber m_Grabber;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer(Joystick driverController, Joystick manipulatorController) {
    m_driveTrain = new DriveTrain();
    m_Drive = new Drive(m_driveTrain, driverController);
    m_Elevator = new Elevator();
    m_ElevatorTest = new ElevatorTest(m_Elevator, driverController);
    m_Grabber = new Grabber();
    m_Intake = new Intake(m_Grabber,driverController);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getDrive()
  {
    return m_Drive;
  }
  public Command getElevator()
  {
    return m_ElevatorTest;
  }
  public Command getGrabber()
  {
    return m_Intake;
  }
}
