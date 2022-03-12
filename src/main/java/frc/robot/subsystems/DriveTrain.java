// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  PowerDistribution pdp;
  DifferentialDrive differentialDrive = null;
  TalonSRX rightBackMotor_Talon = null;
  VictorSPX rightFrontMotor_Victor = null;
  TalonSRX leftBackMotor_Talon = null;
  VictorSPX leftFrontMotor_Victor = null;

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    rightBackMotor_Talon = new TalonSRX(1);
    rightFrontMotor_Victor = new VictorSPX(17);
    leftBackMotor_Talon = new TalonSRX(13);
    leftFrontMotor_Victor = new VictorSPX(12);

   // this.pdp = new PowerDistribution().

  //should be setNeutralMode(ctre.NeutralMode.Brake)
   leftBackMotor_Talon.set(ControlMode.PercentOutput, 0);
   rightBackMotor_Talon.set(ControlMode.PercentOutput, 0);
   leftFrontMotor_Victor.set(ControlMode.PercentOutput, 0);
  rightFrontMotor_Victor.set(ControlMode.PercentOutput, 0);






  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
