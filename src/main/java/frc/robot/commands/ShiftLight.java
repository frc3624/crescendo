// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.LEDContstants.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.LED;

public class ShiftLight extends Command {
  /** Creates a new LightUp. */
  private final LED led;
  public ShiftLight(LED led) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.led = led;
    addRequirements(led);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called $every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(SHIFTLIGHT){
      led.confetti();
    } else{
      led.white();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SHIFTLIGHT = !SHIFTLIGHT;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
