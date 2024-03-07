// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.LEDContstants.*;
public class LED extends SubsystemBase {
  // /** Creates a new LED. */
  // private AddressableLED led = new AddressableLED(0);
  // private AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(60);
  private Spark led = new Spark(0);
  public LED() {
    confetti();
  }

  public void decideColor(){
    if(SHOOTLIGHT){
      red();
    }
    else if(INTAKELIGHT){
      green2();
    }
    else if(CLIMBLIGHT){
      lightGreen();
    }else if(SHIFTLIGHT){
      white();
    } else{
      confetti();
    }
  }
  //
  public void red(){
    set(.59);
  }
  public void set(double speed){
    led.set(speed);
  }
  public void white(){
    set(.93);
  }
  public void blueBreath(){
    set(.75);
  }
  public void darkGreen(){
    set(-.15);
  }
  public void whiteStrobe(){
    set(-.05);
  }
  public void ocean(){
    set(-.41);
  }
  public void lava(){
    set(-.49);
  }
  public void party(){
    set(-.43);
  }
  public void lavaSinelon(){
    set(-.73);
  }
  public void redLarsonScanner(){
    set(-.35);
  }
  public void green2(){
    set(-.29);
  }
  public void whiteHeartBeat(){
    set(-.21);
  }
  public void color1BreathSlow(){
    set(.09);
  }
  public void rainbowGlitter(){
    set(-.89);
  }
  public void rainbowParty(){
    set(-.97);
  }
  public void confetti(){
    set(-.87);
  }
  public void orange(){
    set(.625);
  }
  public void lightGreen(){
    set(.67);
  }
  public void yellow(){
    set(.69);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
