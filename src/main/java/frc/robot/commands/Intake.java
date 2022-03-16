package frc.robot.commands;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

public class Intake extends CommandBase {
    private final Grabber m_Grabber;
    private final Joystick m_driverController;

    public Intake(Grabber Grabber, Joystick driverController){
        this.m_Grabber = Grabber;
        this.m_driverController = driverController;
        
        //addRequirements(Grabber);
    }

    @Override
    public void execute(){
        double openArmTrigger = m_driverController.getRawAxis(2);
        double closeArmTrigger = m_driverController.getRawAxis(3);
        boolean intakeInWheels = m_driverController.getRawButton(6);
        boolean intakeOutWheels = m_driverController.getRawButton(5);
        
        if(openArmTrigger >= 0.1){
            m_Grabber.openGrabber(openArmTrigger);
        }else if(closeArmTrigger >= 0.1){
            m_Grabber.closeGrabber(closeArmTrigger);
        }else{
            m_Grabber.stopGrabber();
        }

        if(intakeInWheels == true){
            m_Grabber.intakeCube();
        }else if(intakeOutWheels == true){
            m_Grabber.removeCube();
        }else{
            m_Grabber.stopIntake();
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        m_Grabber.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
