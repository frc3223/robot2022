Yes, this is indeed a Readme

Rockslides code (robot2018) was built in Python 2.7 and therefore it no longer works. Fret not! robot2022 is a rebuild of Rockslides code from the ground up, but this time in Java instead of Python for your viewing pleasure!
Be happy, this code should be exponentially easier to work on. If it isn't, hunt down and give your complaints to Colin Gideon or any of the other ROCK 2022 members.

    DRIVETRAIN CAN
    self.motor_rb = ctre.WPI_TalonSRX(1)
    self.motor_rf = ctre.WPI_VictorSPX(17)
    self.motor_lb = ctre.WPI_TalonSRX(13)
    self.motor_lf = ctre.WPI_VictorSPX(12)

    ELEVATOR CAN
    self.motor = ctre.WPI_TalonSRX(3)
    self.other_motor = ctre.WPI_TalonSRX(2)
    self.right_motor = ctre.WPI_TalonSRX(14)
    self.other_right_motor = ctre.WPI_TalonSRX(15)

    ELEVATOR PWM
    self.fan = wpilib.PWM(1)
    self.fan2 = wpilib.PWM(0)

    INTAKE CAN
    Right grabber intake Motor
        CAN 4
    Left grabber intake Motor
        CAN 5
    Grabber Window Motor
        CAN 6

    DRIVETRAIN INPUTS

    fw = joystick.getRawAxis(1)
    lr = joystick.getRawAxis(0)

    fw2 = joystick.getRawAxis(5)
    lr2 = joystick.getRawAxis(4)

    ELEVATOR INPUTS
    if self.joystick1.getPOV(0) == 0: #Up on D-pad pressed
        self.elevator.test_drive_positive()
    elif self.joystick1.getPOV(0) == 180: #Down on D-pad pressed
        self.elevator.test_drive_negative()
    elif isDisabled:
            self.elevator.off()
    else:
            self.elevator.hover()

    INTAKE INPUTS
    closeArm_trigger = joystick1.getRawAxis(3) #Right Trigger
    openArm_trigger = joystick1.getRawAxis(2) #Left Trigger
    if abs(closeArm_trigger) > 0.1: # right trigger triggered
        self.intake.closeGrabber(closeArm_trigger)
    elif abs(openArm_trigger) > 0.1: #left trigger triggered
        self.intake.openGrabber()
    elif joystick1.getRawButton(3):
        self.intake.open2Grabber()
    elif joystick1.getRawButton(2):
        self.intake.open2Grabber()
        turnOffWheels = False
    else:
        self.intake.grabberOff()

    if joystick1.getRawButton(5):
        self.intake.cubeOut()
    elif joystick1.getRawButton(6):
        self.intake.cubeIn()
    elif turnOffWheels:
        self.intake.intakeWheelsOff()
