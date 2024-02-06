// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Conveying extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Conveyor conveyor;
  private final DigitalInput limitSwitch = new DigitalInput(DriveConstants.LIMIT);
  public Conveying(Conveyor conveyor) {;
    this.conveyor = conveyor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.set(.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return limitSwitch.get();
  }
}
