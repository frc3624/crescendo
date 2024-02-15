// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shoot;

public class Shooting extends Command {
  /** Creates a new Shooting. */
  private Shoot shoot;
  private Conveyor conveyor;
  public Shooting(Shoot shoot, Conveyor conveyor) {
    this.shoot = shoot;
    this.conveyor = conveyor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shoot);
    addRequirements(conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shoot.set(.3);
    conveyor.set(.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shoot.set(0);
    conveyor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
