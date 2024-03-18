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
  private final Limit limit;
  private final Timer timer = new Timer();
  private boolean NOTE = false;

  public AutoJank(Drive drive, Intake intake, Conveyor conveyor, Shoot shoot, Limit limit) {
    this.conveyor = conveyor;
    this.drive = drive;
    this.shoot = shoot;
    this.intake = intake;
    this.limit = limit;
    addRequirements(limit);
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
  //change auto here
  
  timedRightSideHighShoot();
  }


  public void straightTest(){
    if(time() < .5){
      drive.arcadeDrive(0, -.75);
    } else{
      drive.arcadeDrive(0,0);
    }
  }


  public void timedStraightHighShoot(){
    //first shot
    if(time() < 1){
      intake();
      drive.arcadeDrive(0, 0);
    } else if(time() < 3){
      highShoot();
      NOTE = false;
      drive.arcadeDrive(0, 0);
    }
    //backwards 
    else if(time() < 5.5){
      shoot.set(0);
      drive.arcadeDrive(-.7, 0);
      intake();
    }
    //forwards 
    else if(time() < 8.5){
      intake();
      drive.arcadeDrive(.7,0);
    } 
    //second shot
    else if(time() < 10.5){
      drive.arcadeDrive(0, 0);
      highShoot();
    } else{
      drive.arcadeDrive(-.4, 0);
    } 
  }



  //right is + then -
  //DONT TRY THIS UNLESS WE HAVE FINALIZED IT AN THE OTHER ONE
  public void timedRightSideHighShoot(){
    //first shot
    if(time() < 1){
      shoot.set(0);
      intake();
      drive.arcadeDrive(0, 0);
    }
    else if(time() < 3){
      highShoot();
      drive.arcadeDrive(0, 0);
    }
    //first back .5
    else if(time() <3.5){
      shoot.set(0);
      NOTE = false;
      drive.arcadeDrive(-.7, 0);
    }
    //turn
    else if(time() < 3.9){
      shoot.set(0);
      drive.arcadeDrive(0, -.75);  
      //gyroDrive(75);
    } 
    //second backward
    else if(time() < 6.8){
      intake();
      drive.arcadeDrive(-.7,0);
    }
    //forward
    else if(time() < 9.3){
      intake();
      drive.arcadeDrive(.7,0);
    } //turn back
    else if(time() < 9.7){
      drive.arcadeDrive(0, .75);
      //gyroDrive(-75);
    } 
    else if(time() < 10.5){
      drive.arcadeDrive(.7, 0);
    }else if(time() < 11.5){
      drive.arcadeDrive(0, 0);
    }
    //second shot
    else{
      highShoot();
      drive.arcadeDrive(0, 0);
    }
  }
  public void timedRightSideTaxi(){
    //first shot
    if(time() < 1){
      shoot.set(0);
      intake();
      drive.arcadeDrive(0, 0);
    }
    else if(time() < 3){
      highShoot();
      drive.arcadeDrive(0, 0);
    } else if(time() < 8){
      NOTE = false;
      drive.arcadeDrive(-.7, 0);
    } else{
      drive.arcadeDrive(0, 0);
    }
  }

  //Helper Methods (I don't feel like remembering the speeds for everything)
  public double time(){
    return timer.get();
  }

  public void highShoot(){
    shoot.set(.55);
    conveyor.set(.25);
  }
  public void intake(){
    if(limit.isLimit() || NOTE){
      intake.set(0);
      conveyor.set(0);
      NOTE = true;
    }else{
      intake.set(.3);
      conveyor.set(.2);
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
