// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class AutoJank extends Command {
  /** Creates a new Auto. */
  private final Shoot shoot;
  private final Drive drive;
  private final Intake intake;
  private final Conveyor conveyor;
  private final Timer timer = new Timer();

  public AutoJank(Drive drive, Intake intake, Conveyor conveyor, Shoot shoot) {
    this.conveyor = conveyor;
    this.drive = drive;
    this.shoot = shoot;
    this.intake = intake;
    addRequirements(drive);
    addRequirements(shoot);
    addRequirements(conveyor);
    addRequirements(intake);
    timer.start();
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timedStraightHighShoot();
  }
  public void timedStraightHighShoot(){
    if(time() < 3){
      highShoot();
      drive.arcadeDrive(0, 0);
    } else if(time() < 7){
      shoot.set(0);
      drive.arcadeDrive(-.4, 0);
      intake();
    } else if(time() < 11){
      intake();
      drive.arcadeDrive(.4,0);
    } else if(time() < 13){
      drive.arcadeDrive(0, 0);
      highShoot();
    }
  }

  public void timedLeftSideHighShoot(){
    if(time() < 3){
      highShoot();
      drive.arcadeDrive(0, 0);
    }
    else if(time() < 6){
      drive.arcadeDrive(0, -.8);
    } else if(time() < 7){
      shoot.set(0);
      drive.arcadeDrive(-.4, 0);  
      intake();
    } else if(time() < 11){
      intake();
      drive.arcadeDrive(.4,0);
    } else if(time() < 13){
      drive.arcadeDrive(0, 0);
      highShoot();
    }
  }

  //Helper Methods (I don't feel like remembering the speeds for everything)
  public double time(){
    return timer.get();
  }
  public void highShoot(){
    shoot.set(.7);
    conveyor.set(.2);
  }
  public void intake(){
    if(conveyor.isLimit()){
      intake.set(0);
      conveyor.set(0);
    }else{
      intake.set(.3);
      conveyor.set(.3);
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.set(0);
    shoot.set(0);
    drive.arcadeDrive(0, 0);
    intake.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time() > 13;
  }
}
