// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.SpinMotorSquareWave;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TestMotor extends SubsystemBase {

  public final WPI_TalonSRX m_Motor1 = new WPI_TalonSRX(3);
  
  public TestMotor() {
    // reset the controller for good measure 
    m_Motor1.configFactoryDefault();
    m_Motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);

    //set the PID values 
    m_Motor1.config_kP(0,0);
		m_Motor1.config_kI(0,0);
    m_Motor1.config_kD(0,0);
		m_Motor1.config_kF(0,0);
  }

  public void runMotorVelocity(int velocity){
    m_Motor1.set(ControlMode.Velocity, velocity);
  }

  public void runMotorVbus(int vbus){
    m_Motor1.set(ControlMode.PercentOutput, vbus);
  }

  public void stopMotor(){
    m_Motor1.set(ControlMode.PercentOutput, 0);
  }

}
