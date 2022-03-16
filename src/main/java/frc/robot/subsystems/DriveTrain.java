// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  DifferentialDrive differentialDrive = null;
  WPI_TalonSRX rightBackMotor_Talon = null;
  WPI_VictorSPX rightFrontMotor_Victor = null;
  WPI_TalonSRX leftBackMotor_Talon = null;
  WPI_VictorSPX leftFrontMotor_Victor = null;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    this.rightBackMotor_Talon = new WPI_TalonSRX(1);
    this.rightFrontMotor_Victor = new WPI_VictorSPX(17);
    this.leftBackMotor_Talon = new WPI_TalonSRX(13);
    this.leftFrontMotor_Victor = new WPI_VictorSPX(12);

    rightBackMotor_Talon.setInverted(false);
    rightFrontMotor_Victor.setInverted(false);
    leftBackMotor_Talon.setInverted(false);
    leftFrontMotor_Victor.setInverted(false);

    MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontMotor_Victor, rightBackMotor_Talon);
    MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontMotor_Victor, leftBackMotor_Talon);

    this.differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed)
  {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void tankDrive (double leftSpeed, double rightSpeed)
  {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }
  public void moveLeft()
  {
    //using Robot2020 values
    this.tankDrive(-1, 1);
  }

  public void moveRight()
  {
    //using Robot2020 values
    this.tankDrive(1, -1);
  }

  public void moveForward()
  {
    //using Robot2020 values
    this.tankDrive(1, 1);
  }

  public void stop()
  {
    //using Robot2020 values
    this.tankDrive(0, 0);
  }

  public void moveBackward()
  {
    //using Robot2020 values
    this.tankDrive(-1, -1);
  }

}
