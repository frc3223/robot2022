package frc.robot.commands;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;


public class ElevatorTest extends CommandBase {
    private final Elevator m_elevator;
    private final Joystick m_driverController;
    
    private int state;
    private double voltage;
    private boolean done;
    public ElevatorTest(Elevator Elevator, Joystick driverController)
    {
        this.m_elevator = Elevator;
        this.m_driverController = driverController;

        addRequirements(Elevator);
    }

      // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      //initialize state variable
      this.state = 1;
      this.voltage = 0.75;
      this.done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    //Start with test1
    test1();

    //Can run test2 as well
    //test2();
  }

  public void test1()
  {
      
    if(this.m_driverController.getPOV(0) == Constants.dPadUp){//Up on D-pad
        this.m_elevator.testDrivePositive();
    }else if (this.m_driverController.getPOV(0) == Constants.dPadDown){//Down on D-pad
        this.m_elevator.testDriveNegative();
    }else if(DriverStation.isDisabled()){
        this.m_elevator.off();
    }else{
        this.m_elevator.hover();
    }
  }

  public void test2()
  {
    double encoderPosition = this.m_elevator.getEncoderPosition();

    if(this.state == 1){
        this.m_elevator.ascend(this.voltage);
        if(encoderPosition > 28000){
            this.state =2;
            this.m_elevator.descend(this.voltage);
        }
    }
    if(this.state == 2){
        this.m_elevator.descend(this.voltage);
    }
    if(encoderPosition < 1000 && this.state ==2){
        this.state = 1;
        this.voltage += 0.25;
    }else if (this.voltage > 1){
        this.voltage = 0;
        this.done = true;
    }
  }
  @Override
  public void end(boolean interrupted)
  {
    m_elevator.hover();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.done;
  }
}
