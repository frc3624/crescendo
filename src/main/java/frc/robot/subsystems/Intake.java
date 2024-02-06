// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Intake extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final TalonFX rightIntake = new TalonFX(DriveConstants.RIGHTINTAKE);
  private final TalonFX leftIntake = new TalonFX(DriveConstants.LEFTINTAKE);

  public Intake() {
    configure();
  }
  public void configure(){
    rightIntake.setNeutralMode(NeutralModeValue.Brake);
    leftIntake.setNeutralMode(NeutralModeValue.Brake);
  }
  public void set(double speed){
    rightIntake.set(speed);
    leftIntake.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
