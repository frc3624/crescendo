// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Pan;

public class Pop extends Command {
  /** Creates a new Pop. */
  private final Pan pan;
  public Pop(Pan pan) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.pan = pan;
    addRequirements(pan);
    pan.set(false);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pan.set(!pan.get());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
