// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.DriveConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Shoot;

public class HighShooting extends Command {
  /** Creates a new Shooting. */
  private final Shoot shoot;
  private final Conveyor conveyor;
  private final LED led;
  public HighShooting(Shoot shoot, Conveyor conveyor, LED led) {
    this.shoot = shoot;
    this.conveyor = conveyor;
    this.led = led;
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
    shoot.set(.7);
    conveyor.set(.2);
    led.decideColor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shoot.set(0);
    conveyor.set(0);
    SHOT = false;
    led.decideColor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
