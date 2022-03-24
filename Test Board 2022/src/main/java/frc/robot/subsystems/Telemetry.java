package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.EnableMotorHoldPosition;
import frc.robot.commands.ResetEncoderPosition;

public class Telemetry extends SubsystemBase {
  /** Creates a new Telemetry. */

  final ShuffleboardTab MotorTab = Shuffleboard.getTab("Drive");
// todo change this to use position and set it for a 4:1 reduciton 
  NetworkTableEntry motorPositionEntry = MotorTab.add("Motor angle", 1)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("min", 0, "max", 2000))
    .getEntry();

  

  public Telemetry(TestMotor k_TestMotor) {
  TestMotor m_TestMotor = k_TestMotor;
  Shuffleboard.selectTab("Drive");
  SmartDashboard.putData("Reset Encoder", new ResetEncoderPosition(m_TestMotor));
  SmartDashboard.putData("Set Motor Position", new EnableMotorHoldPosition());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double position = motorPositionEntry.getDouble(0);
    //4096counts/rev * 4/1 * 1rev/360deg
    TestMotor.updateMotorPosition(position * (4 * 4096 / 360));
  }
}
