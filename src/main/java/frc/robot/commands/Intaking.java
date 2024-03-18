// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.*;

import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.LEDContstants.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Intaking extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake intake;
  private final Conveyor conveyor;
  private final LED led;
  private final Limit limit;
  private final XboxController xbox = new XboxController(OperatorConstants.kDriverControllerPort);


  public Intaking(Intake intake, Conveyor conveyor, Limit limit, LED led) {
   this.intake = intake;
   this.conveyor = conveyor;
   this.led = led;
   this.limit = limit;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limit);
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
      if(limit.isLimit()){
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
    INTAKELIGHT = false;
    led.decideColor();
    if(limit.isLimit()){
      SHOT = true;
      xbox.setRumble(RumbleType.kBothRumble, .5);
      Timer.delay(1);
      xbox.setRumble(RumbleType.kBothRumble,0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return limit.isLimit();
  }
}
