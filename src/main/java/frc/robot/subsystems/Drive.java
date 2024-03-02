// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.PneumaticsConstants.*;
import static frc.robot.Constants.AutoConstants.*;



public class Drive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final CANSparkMax leftLead = new CANSparkMax(LEFTLEAD, MotorType.kBrushless);
  private final CANSparkMax leftFollow = new CANSparkMax(LEFTFOLLOW, MotorType.kBrushless);
  private final CANSparkMax rightLead = new CANSparkMax(RIGHTLEAD, MotorType.kBrushless);
  private final CANSparkMax rightFollow = new CANSparkMax(RIGHTFOLLOW, MotorType.kBrushless);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftLead, rightLead);
  private final Solenoid gearShift = new Solenoid(PneumaticsModuleType.REVPH, GEARSHIFT);
  
  // private final DifferentialDriveKinematics diffDriveKin = new DifferentialDriveKinematics(Units.inchesToMeters(TRACKWIDTH));

  // private final ChassisSpeeds chassisSpeeds = new ChassisSpeeds(VX, VY, ANGSPEED);

  // private final DifferentialDriveWheelSpeeds wheelSpeeds = diffDriveKin.toWheelSpeeds(chassisSpeeds);

  // private final double leftVelocity = wheelSpeeds.leftMetersPerSecond;

  // private final double rightVelocity = wheelSpeeds.rightMetersPerSecond;
  public Drive() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
    
    configure();
  }
  public void configure(){
    leftLead.setIdleMode(IdleMode.kBrake);
    rightLead.setIdleMode(IdleMode.kBrake);
      
    rightLead.setInverted(true);

    gearShift.set(false);

    leftLead.setSmartCurrentLimit(50);
    leftFollow.setSmartCurrentLimit(50);
    rightFollow.setSmartCurrentLimit(50);
    rightLead.setSmartCurrentLimit(50);

    leftLead.burnFlash();
    leftFollow.burnFlash();
    rightLead.burnFlash();
    rightFollow.burnFlash();
  }
  public void arcadeDrive(double speed, double rotation){
    diffDrive.arcadeDrive(speed, rotation);
    if(gearShift.get() == false)
			diffDrive.arcadeDrive(speed,rotation);
		else
			diffDrive.arcadeDrive(.75* speed,.75* rotation);
  }

  public void shiftGear(){
    gearShift.set(!gearShift.get());
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
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
