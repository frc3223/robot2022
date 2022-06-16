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
        //xbox controller
        //double openArmTrigger = m_driverController.getRawAxis(2);
        //double closeArmTrigger = m_driverController.getRawAxis(3);
        //boolean intakeInWheels = m_driverController.getRawButton(6);
        //boolean intakeOutWheels = m_driverController.getRawButton(5);
        
        //logitech controller
        boolean openArmTrigger = m_driverController.getRawButton(5);
        boolean closeArmTrigger = m_driverController.getRawButton(6);
        boolean intakeInWheels = m_driverController.getRawButton(7);
        boolean intakeOutWheels = m_driverController.getRawButton(8);
        if(openArmTrigger){
            m_Grabber.openGrabber(0.5);
        }else if(closeArmTrigger){
            m_Grabber.closeGrabber(-0.5);
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
