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
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class DriveConstants{
    public static int LEFTLEAD = 1;
    public static int LEFTFOLLOW = 2;
    
    public static int RIGHTLEAD = 4;
    public static int RIGHTFOLLOW = 3;
    
  }
  public static class PneumaticsConstants{
    public static int PCM = 0;
    public static int LOWRATIO = 0;
    public static int HIGHRATIO = 0;
  }
}
