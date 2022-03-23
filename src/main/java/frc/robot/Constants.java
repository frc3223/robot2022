// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/*
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

/*
 * All Controller Bindings are assigned as if a Xbox Controller is being used.
 * No other controller will work correctly! (VERY IMPORTANT)
 */

public final class Constants {
    //Grabber CAN/Controller
    public static final int leftIntakeMotor = 5;
    public static final int rightIntakeMotor = 4;
    public static final int grabberWindowMotor = 6;
    
    public static final int openArmTrigger = 2; //Left Trigger
    public static final int closeArmTrigger = 3; //Right Trigger
    public static final int intakeInWheels = 6; //Right Bumper
    public static final int intakeOutWheels = 5; //Left Bumper

    //Elevator CAN/Controller
    public static final int motorPrimary_Talon = 3;
    public static final int motorOther_Talon = 2;
    public static final int motorRight_Talon = 14;
    public static final int motorRightOther_Talon = 15;
    public static final int fan1 = 1;
    public static final int fan2 = 0;
    public static final int sensor = 9;

    public static final int dPadUp = 0;
    public static final int dPadDown = 180;

    //Drivetrain CAN/Controller
    public static final int rightBackMotor_Talon = 1;
    public static final int rightFrontMotor_Victor = 17;
    public static final int leftBackMotor_Talon = 13;
    public static final int leftFrontMotor_Victor = 12;

    public static final int leftStickUpDown = 1;
    public static final int rightStickUpDown = 5;
    public static final int leftStickLeftRight = 0;
    public static final int rightStickLeftRight = 4;
}
