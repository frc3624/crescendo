// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.LEDContstants.SHOOTLIGHT;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Pan;
import frc.robot.subsystems.Shoot;

public class LowShooting extends Command {
  /** Creates a new LowShooting. */
  private final Shoot shoot;
  private final Conveyor conveyor;
  private final LED led;
  private final Pan pan;
  public LowShooting(Shoot shoot, Conveyor conveyor, Pan pan,LED led) {
    this.shoot = shoot;
    this.conveyor = conveyor;
    this.led = led;
    this.pan = pan;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shoot);
    addRequirements(pan); 
    addRequirements(led);
    addRequirements(conveyor);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SHOOTLIGHT = true;  
   // pan.set(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    led.decideColor();
    // shoot.set(.08);
    // conveyor.set(.09);
    // pan.set(true);
    pan.set(true);
    conveyor.set(.09);
    shoot.set(.13);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shoot.set(0);
    conveyor.set(0);
    pan.set(false);
    SHOT = false;
    SHOOTLIGHT = false;
    led.decideColor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
