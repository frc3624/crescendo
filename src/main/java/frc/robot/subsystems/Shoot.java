// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Shoot extends SubsystemBase {
  /** Creates a new Shoot. */
  private final TalonFX leftShoot = new TalonFX(DriveConstants.LEFTSHOOT);
  private final TalonFX rightShoot = new TalonFX(DriveConstants.RIGHTSHOOT);
  public Shoot() {
    configure();
  }
  public void configure(){
    rightShoot.setInverted(true);
    leftShoot.setNeutralMode(NeutralModeValue.Brake);
    rightShoot.setNeutralMode(NeutralModeValue.Brake);
  }

  public void set(double speed){
    leftShoot.set(speed);
    rightShoot.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
