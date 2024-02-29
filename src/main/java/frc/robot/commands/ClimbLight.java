// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import static frc.robot.Constants.LEDContstants.*;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LED;

public class ClimbLight extends Command {
  /** Creates a new ClimbLight. */
  private final LED led;
  public ClimbLight(LED led) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.led = led;
    addRequirements(led);
  }
  @Override
  public void initialize() {
    CLIMBLIGHT = !CLIMBLIGHT;
  }

  // Called when the command is initially scheduled.
  @Override
  public void execute() {
    led.decideColor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
