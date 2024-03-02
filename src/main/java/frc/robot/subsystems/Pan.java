// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.PneumaticsConstants.*;

public class Pan extends SubsystemBase {
  /** Creates a new Pan. */
  private final Solenoid panSolenoid = new Solenoid(PneumaticsModuleType.REVPH, PAN);

  public Pan() {
    panSolenoid.set(false);
  }
  public void set(boolean setting){
    panSolenoid.set(setting);
  }
  public boolean get(){
    return panSolenoid.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
