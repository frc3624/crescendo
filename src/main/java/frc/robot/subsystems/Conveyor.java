// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import static frc.robot.Constants.DriveConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final CANSparkMax beltMotor = new CANSparkMax(BELT, MotorType.kBrushless);
  private final DigitalInput limit = new DigitalInput(LIMIT);
  public Conveyor() {
    configure();
  }
  public void configure(){
    beltMotor.setIdleMode(IdleMode.kBrake);
    beltMotor.setSmartCurrentLimit(80);
    beltMotor.setInverted(true);
    beltMotor.burnFlash();
  }
  public void set(double speed){
    beltMotor.set(speed);
  }
  public boolean isLimit(){
    return limit.get();
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
