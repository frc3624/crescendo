// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import static frc.robot.Constants.PneumaticsConstants.*;

public class Climb extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  // private final Orchestra bondMusic = new Orchestra();
  // private final TalonFX leftShoot = new TalonFX(DriveConstants.LEFTSHOOT);
  // private final TalonFX rightShoot = new TalonFX(DriveConstants.RIGHTSHOOT);
  // private final TalonFX rightIntake = new TalonFX(DriveConstants.RIGHTINTAKE);
  // private final TalonFX leftIntake = new TalonFX(DriveConstants.LEFTINTAKE);
  private final Solenoid climbSolenoid = new Solenoid(PneumaticsModuleType.REVPH, CLIMB);
  
  public Climb() {
    climbSolenoid.set(false);
  }

  public void toggle(){
    climbSolenoid.set(!climbSolenoid.get());
  }
  // public void playMusic(){
  //   bondMusic.addInstrument(leftShoot);
  //   bondMusic.addInstrument(rightShoot);
  //   bondMusic.addInstrument(leftIntake);
  //   bondMusic.addInstrument(rightIntake);
  //   bondMusic.loadMusic("crescendo\\output.chrp");
  //   bondMusic.play();
  // }
  // public void stopMusic(){
  //   bondMusic.stop();
  // }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
