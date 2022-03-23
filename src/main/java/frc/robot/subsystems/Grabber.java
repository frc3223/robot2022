package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grabber extends SubsystemBase{
    WPI_VictorSPX leftIntakeMotor = null;
    WPI_VictorSPX rightIntakeMotor = null;
    WPI_VictorSPX grabberWindowMotor = null;

    public Grabber() {
        this.leftIntakeMotor = new WPI_VictorSPX(Constants.leftIntakeMotor);
        this.rightIntakeMotor = new WPI_VictorSPX(Constants.rightIntakeMotor);
        this.grabberWindowMotor = new WPI_VictorSPX(Constants.grabberWindowMotor);

        leftIntakeMotor.setInverted(false);
        rightIntakeMotor.setInverted(false);
        grabberWindowMotor.setInverted(false);

    }

    public void intakeCube(){
        this.leftIntakeMotor.set(1);
        this.rightIntakeMotor.set(-1);
    }

    public void removeCube(){
        this.leftIntakeMotor.set(-1);
        this.rightIntakeMotor.set(1);
    }

    public void openGrabber(double openSpeed){
        this.grabberWindowMotor.set(openSpeed*0.4);
    }
    
    public void closeGrabber(double closeSpeed){
        this.grabberWindowMotor.set(-(closeSpeed*0.4));
    }

    public void stopGrabber(){
        this.grabberWindowMotor.set(0);
    }

    public void stopIntake(){
        this.leftIntakeMotor.set(0);
        this.rightIntakeMotor.set(0);
    }
    
    public void stop(){
        this.grabberWindowMotor.set(0);
        this.leftIntakeMotor.set(0);
        this.rightIntakeMotor.set(0);
    }
}
