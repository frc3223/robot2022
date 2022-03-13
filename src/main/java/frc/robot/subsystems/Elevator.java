package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    WPI_TalonSRX motorPrimary_Talon = null;
    WPI_TalonSRX motorOther_Talon = null;
    WPI_TalonSRX motorRight_Talon = null;
    WPI_TalonSRX motorRightOther_Talon = null;

    PWMSparkMax fan1 = null;
    PWMSparkMax fan2 = null;

    public Elevator()
    {
        motorPrimary_Talon = new WPI_TalonSRX(3);
        motorOther_Talon = new WPI_TalonSRX(2);
        motorRight_Talon = new WPI_TalonSRX(14);
        motorRightOther_Talon = new WPI_TalonSRX(15);

        fan1 = new PWMSparkMax(1);
        fan2 = new PWMSparkMax(0);
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
