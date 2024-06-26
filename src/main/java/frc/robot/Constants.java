// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 *///
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class DriveConstants{
    public static int LEFTLEAD = 1;
    public static int LEFTFOLLOW = 2;
    
    public static int RIGHTLEAD = 4;
    public static int RIGHTFOLLOW = 3;

    public static int RIGHTBELT = 5;
    public static int LEFTBELT = 6;
    public static int LIMIT = 0;

    public static int RIGHTINTAKE = 0;
    public static int LEFTINTAKE = 42;

    public static int RIGHTSHOOT = 12;
    public static int LEFTSHOOT = 11;
    
    public static boolean SHOT = false;
    public static boolean FIRST = true;

  }
  public static class PneumaticsConstants{
    public static int PCM = 20;
    public static int GEARSHIFT = 7;
    public static int CLIMB = 0;
    public static int PAN = 6;
  }
  public static class LEDContstants{
    public static boolean CLIMBLIGHT = false;
    public static boolean SHIFTLIGHT = false;
    public static boolean SHOOTLIGHT = false;
    public static boolean INTAKELIGHT = false;
  }
  public static class AutoConstants{
    //inner distance is 25, outer is 27.5, wheel diameter is 1 in
    public static double TRACKWIDTH = 25;
    public static double VX = 2;
    public static double VY = 3;
    public static double ANGSPEED = Math.PI;

  }
}
