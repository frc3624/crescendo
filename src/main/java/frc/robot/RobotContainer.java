// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.PneumaticsConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Climbing;
import frc.robot.commands.Conveying;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.Intaking;
import frc.robot.commands.ShiftGear;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final CommandXboxController xbox = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final Compressor compressor = new Compressor(PneumaticsModuleType.REVPH);
  //Subsystems
  private final Drive drive = new Drive();
  private final Climb climb = new Climb();
  private final Intake intake = new Intake();
  private final Conveyor conveyor= new Conveyor();


  //Commands
  private final DriveTrain driveTrain = new DriveTrain(drive);
  private final ShiftGear shiftGear = new ShiftGear(drive);
  private final Climbing climbing = new Climbing(climb);
  private final Intaking intaking = new Intaking(intake);
  private final Conveying conveying = new Conveying(conveyor);

 
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    compressor.enableDigital();
    drive.setDefaultCommand(driveTrain);
    configureBindings();
  }

  private void configureBindings() {
    xbox.a().whileTrue(shiftGear);
    xbox.b().whileTrue(climbing);
    xbox.x().toggleOnTrue(intaking);
    xbox.y().toggleOnTrue(conveying);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
