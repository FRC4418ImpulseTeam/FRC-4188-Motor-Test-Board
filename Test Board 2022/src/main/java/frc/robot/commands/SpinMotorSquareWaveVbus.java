// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TestMotor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class SpinMotorSquareWaveVbus extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TestMotor m_TestMotor;
  public double startTime;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinMotorSquareWaveVbus(TestMotor subsystem) {
    m_TestMotor = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    m_TestMotor.runMotorVbus(0.1);
    // System.out.println(startTime + 1);
    // System.out.println(Timer.getFPGATimestamp());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(startTime + 1 < Timer.getFPGATimestamp()){
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
    if(startTime + 2 < Timer.getFPGATimestamp()){
      return true;
    }
    else{
      return false;
    }
  }
  
}
