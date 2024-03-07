// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final CommandXboxController xbox = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final Compressor compressor = new Compressor(PneumaticsModuleType.REVPH);
  
  //Camera
 UsbCamera rearCam = CameraServer.startAutomaticCapture();
	UsbCamera frontCam = CameraServer.startAutomaticCapture();
 CvSink cvSink = CameraServer.getVideo();
	CvSource outputStream = CameraServer.putVideo("Rear Cam", 680, 480);
  CvSource output2 = CameraServer.putVideo("Front Cam", 680, 480);

  //Subsystems
  private final Drive drive = new Drive();
  private final Climb climb = new Climb();
  private final Intake intake = new Intake();
  private final Conveyor conveyor= new Conveyor();
  private final Shoot shoot = new Shoot();
  private final Pan pan = new Pan();
  private final LED led = new LED();


  //Commands
  private final DriveTrain driveTrain = new DriveTrain(drive);
  private final ShiftGear shiftGear = new ShiftGear(drive);
  private final Climbing climbing = new Climbing(climb);
  private final Intaking intaking = new Intaking(intake,conveyor,led);
  private final Conveying conveying = new Conveying(conveyor);
  private final HighShooting highShooting = new HighShooting(shoot, conveyor,led);
  private final LowShooting lowShooting = new LowShooting(shoot,conveyor,pan,led);
  private final Pop pop = new Pop(pan);
  private final Reverse reverse = new Reverse(intake);
 
  private final ShiftLight shiftLight = new ShiftLight(led);
  private final ClimbLight climbLight = new ClimbLight(led);

 
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    compressor.enableDigital();
    drive.setDefaultCommand(driveTrain);
    configureBindings();
    //System.out.println(drive.getAngle());
  }

  private void configureBindings() {
    xbox.b().whileTrue(shiftGear);
    xbox.b().whileTrue(shiftLight);
    xbox.y().whileTrue(climbing);
    xbox.y().whileTrue(climbLight);
    xbox.a().toggleOnTrue(intaking);
    xbox.povRight().toggleOnTrue(conveying);
    xbox.x().toggleOnTrue(highShooting); 
    xbox.leftTrigger().toggleOnTrue(lowShooting);
    xbox.leftBumper().toggleOnTrue(pop);
    xbox.rightTrigger().whileTrue(highShooting);
    xbox.povDown().toggleOnTrue(reverse);
  }

  


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   return new AutoJank(drive, intake, conveyor, shoot);
   
  // return null;
  }
}
