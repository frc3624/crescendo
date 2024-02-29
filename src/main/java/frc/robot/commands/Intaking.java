// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;

import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.LEDContstants.INTAKELIGHT;

import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Intaking extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake intake;
  private final Conveyor conveyor;
  private final LED led;

  public Intaking(Intake intake, Conveyor conveyor, LED led) {
   this.intake = intake;
   this.conveyor = conveyor;
   this.led = led;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(led);
    addRequirements(conveyor);
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    INTAKELIGHT = true;
    led.decideColor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!SHOT){
      if(conveyor.isLimit()){
        intake.set(0);
        conveyor.set(0);
      }else{
        intake.set(.3);
        conveyor.set(.3);
      }
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.set(0);
    conveyor.set(0);
    if(conveyor.isLimit()){
      SHOT = true;
    }
    INTAKELIGHT = false;
    led.decideColor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return conveyor.isLimit();
  }
}
