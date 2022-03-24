// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Units;
import frc.robot.commands.SpinMotorSquareWave;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TestMotor extends SubsystemBase {

  public final static TalonSRX m_Motor1 = new TalonSRX(3);
  public static double MotorPositionSetpoint = 0;
  
  public TestMotor() {
    // reset the controller for good measure 
    m_Motor1.configFactoryDefault();
    m_Motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
    m_Motor1.configVoltageCompSaturation(12); // "full output" will now scale to 12 Volts for all control modes when enabled.
    m_Motor1.enableVoltageCompensation(true); // turn on/off feature

    //set the PID values 
    m_Motor1.config_kP(0, 0.015);
		m_Motor1.config_kI(0, 0.00005);
    m_Motor1.config_kD(0, 0);
		m_Motor1.config_kF(0, 0);
  }

  public void runMotorVelocity(int rpm){
    double speed = Units.rpmToTicksPer100ms(Units.gearReduction(rpm, 4));
    m_Motor1.set(ControlMode.Velocity, speed);
    System.out.println(speed);
  }

  public void runMotorVbus(double vbus){
    m_Motor1.set(ControlMode.PercentOutput, vbus);
  }

  public static void stopMotor(){
    m_Motor1.set(ControlMode.PercentOutput, 0);
  }

  public void resetEncoderPosition(){
    m_Motor1.setSelectedSensorPosition(0.);
  }

  public static void setMotorPosition(){
    if(Math.abs(m_Motor1.getSelectedSensorPosition() - MotorPositionSetpoint) < (4096*4*5)){ //4096 ticks/rev * 4/1reduction * 5 rev
      m_Motor1.set(ControlMode.Position, MotorPositionSetpoint);
    }
    else{
      System.out.println("Error: selected position really far away, try a different one");
      stopMotor();
    }
  }

  public static void updateMotorPosition(double setpoint){
    MotorPositionSetpoint = setpoint;
  }
}
