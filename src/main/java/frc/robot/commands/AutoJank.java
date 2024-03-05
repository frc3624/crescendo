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
   
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timedLeftSideHighShoot();
  }
  public void timedStraightHighShoot(){
    //first shot
    if(time() < 3){
      highShoot();
      drive.arcadeDrive(0, 0);
    }
    //backwards 
    else if(time() < 7){
      shoot.set(0);
      drive.arcadeDrive(-.7, 0);
      intake();
    }
    //forwards 
    else if(time() < 11){
      intake();
      drive.arcadeDrive(.7,0);
    } 
    //second shot
    else if(time() < 15){
      drive.arcadeDrive(0, 0);
      highShoot();
    }
  }




  //DONT TRY THIS UNLESS WE HAVE FINALIZED IT AN THE OTHER ONE
  public void timedLeftSideHighShoot(){
    //first shot
    if(time() < 2){
      highShoot();
      drive.arcadeDrive(0, 0);
    }
    //first back .5
    else if(time() <2.5){
      shoot.set(0);
      drive.arcadeDrive(-.7, 0);
    }
    //turn
    else if(time() < 2.9){
      shoot.set(0);
      drive.arcadeDrive(0, -.75);  
    } 
    //second backward
    else if(time() < 5.8){
      intake();
      drive.arcadeDrive(-.7,0);
    } 
    //forward
    else if(time() < 8.7){
      intake();
      drive.arcadeDrive(.7,0);
    } //turn back
    else if(time() < 9.1){
      drive.arcadeDrive(0, .75);
    } 
    else if(time() < 9.6){
      drive.arcadeDrive(.7, 0);
    }
    //second shot
    else{
      highShoot();
      drive.arcadeDrive(0, 0);
    }
  }

  //Helper Methods (I don't feel like remembering the speeds for everything)
  public double time(){
    return timer.get();
  }
  public void highShoot(){
    shoot.set(.45);
    conveyor.set(.3);
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
    timer.stop();
    timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time() > 15;
  }
}
