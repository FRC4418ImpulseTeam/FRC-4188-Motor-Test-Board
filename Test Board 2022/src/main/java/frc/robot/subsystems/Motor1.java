// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Motor1 extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  public final WPI_TalonSRX Motor1 = new WPI_TalonSRX(3);
  

  public Motor1() {
    // reset the controller for good measure 
    Motor1.configFactoryDefault();
    Motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);

    //set the PID values 
    Motor1.config_kP(0,0);
		Motor1.config_kI(0,0);
    Motor1.config_kD(0,0);
		Motor1.config_kF(0,0);

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
