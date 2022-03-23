Yes, this is indeed a Readme

Rockslides code (robot2018) was built in Python 2.7 and therefore it no longer works. Fret not! robot2022 is a rebuild of Rockslides code from the ground up, but this time in Java instead of Python for your viewing pleasure!
Be happy, this code should be exponentially easier to work on. If it isn't, hunt down and give your complaints to Colin Gideon or any of the other ROCK 2022 members.

If desired, feel free to use the Robot Dashboard at https://github.com/frc3223/dashboard2018 (WIP, not currently integrated)

ALL CAN BUS ASSIGNMENTS CAN BE FOUND IN src/main/java/frc/robot/Constants.java

Drivetrain can be switched between tank drive/arcade drive by commenting out the call for the opposite class in src/main/java/frc/robot/commands/Drive.java under the execute class

# EXAMPLE

Situation: I want to use arcade drive instead of tank drive

Solution: Comment out tankDrive2020(); and un-comment rockSlideArcadeDrive();
    
    public void execute(){
        //Use Rockslide ArcadeDrive?
        rockSlideArcadeDrive();

        //Use tankDrive from 2020 Robot by default
        //tankDrive2020();
        }

# Controller Inputs

    D-Pad UP = Elevator Up
    D-Pad DOWN = Elevator Down
    LT/RT = Grabber Open/Close (May be inverted, test to find out)
    LB = Intake In
    RB = Intake Out
    
    //ARCADE DRIVE CONTROLS
    Left Stick = Fast Mode
    Right Stick = Slow Mode
    
    //TANK DRIVE CONTROLS
    
    Left Stick = Left drive forward/backward
    Right Stick = Right drive forward/backward
    
    
