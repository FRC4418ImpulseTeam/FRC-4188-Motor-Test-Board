// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TestMotor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class SpinMotorSquareWave extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TestMotor m_TestMotor;
  public double startTime;
  public double period = 20;
  public double dutycycle = 0.5;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinMotorSquareWave(TestMotor subsystem) {
    m_TestMotor = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    m_TestMotor.runMotorVelocity(100);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(startTime + (period * dutycycle) < Timer.getFPGATimestamp()){
      m_TestMotor.stopMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TestMotor.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(startTime + (period - (period * dutycycle)) < Timer.getFPGATimestamp()){
      return true;
    }
    else{
      return false;
    }
  }
}
