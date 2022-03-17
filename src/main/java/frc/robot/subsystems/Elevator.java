package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class Elevator extends SubsystemBase {
    WPI_TalonSRX motorPrimary_Talon = null;
    WPI_TalonSRX motorOther_Talon = null;
    WPI_TalonSRX motorRight_Talon = null;
    WPI_TalonSRX motorRightOther_Talon = null;

    PWMSparkMax fan1 = null;
    PWMSparkMax fan2 = null;

    DigitalInput sensor = null;

    double position = 0;
    //encoder ticks per revolution
    double ratio = 4096;
    double maxPosition = 3;
    double minPosition = 0;

    public Elevator()
    {
        motorPrimary_Talon = new WPI_TalonSRX(3);
        motorOther_Talon = new WPI_TalonSRX(2);
        motorRight_Talon = new WPI_TalonSRX(14);
        motorRightOther_Talon = new WPI_TalonSRX(15);

        fan1 = new PWMSparkMax(1);
        fan2 = new PWMSparkMax(0);

        sensor = new DigitalInput(9);
    }

    public void setPosition(double position)
    {
        if(this.position > this.maxPosition){
            this.position = this.maxPosition;
        }
        if(this.position < this.minPosition){
            this.position = this.minPosition;
        }
        this.motorPrimary_Talon.set(this.position * this.ratio);
    }

    public void hover()
    {
        this.motorPrimary_Talon.set(-0.1);
        this.motorOther_Talon.set(-0.1);
        this.motorRight_Talon.set(0.1);
        this.motorRightOther_Talon.set(0.1);
        this.fan1.set(1.0);
        this.fan2.set(1.0);
    }

    public void descend(double voltage)
    {
        this.motorPrimary_Talon.set(voltage);
        this.motorOther_Talon.set(voltage);
        this.motorRight_Talon.set(-voltage);
        this.motorRightOther_Talon.set(-voltage);
    }
    
    public void ascend(double voltage)
    {
        this.motorPrimary_Talon.set(-voltage);
        this.motorOther_Talon.set(-voltage);
        this.motorRight_Talon.set(voltage);
        this.motorRightOther_Talon.set(voltage);
    }

    public void testDrivePositive()
    {
        this.motorPrimary_Talon.set(-1.0);
        this.motorOther_Talon.set(-1.0);
        this.motorRight_Talon.set(1.0);
        this.motorRightOther_Talon.set(1.0);
    }

    public void testDriveNegative()
    {
        this.motorPrimary_Talon.set(0.6);
        this.motorOther_Talon.set(0.6);
        this.motorRight_Talon.set(-0.6);
        this.motorRightOther_Talon.set(-0.6);
    }

    public double getEncoderPosition()
    {
        return -this.motorPrimary_Talon.getSelectedSensorPosition(0);
    }

    public void off()
    {
        this.motorPrimary_Talon.stopMotor();
        this.motorRight_Talon.stopMotor();
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      this.position = motorPrimary_Talon.getSelectedSensorPosition(0);
    
    }

    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
       
    }
  
}
