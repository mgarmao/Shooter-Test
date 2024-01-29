// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private static CANSparkMax motor;
    private CANSparkMax motor2;

    DoubleSolenoid intakeSolenoid;
    public Shooter() {
        /** Create a new object to control the SPARK MAX motor controllers. */
        motor = new CANSparkMax(9, MotorType.kBrushless);
        motor2 = new CANSparkMax(10, MotorType.kBrushless);
        /**
         * Restore motor controller parameters to factory default until the next controller 
         * reboot.
         */
        motor.restoreFactoryDefaults();
        motor2.restoreFactoryDefaults();
        motor.setSmartCurrentLimit(40);
        motor2.setSmartCurrentLimit(40);

        /**
         * When the SPARK MAX is receiving a neutral command, the idle behavior of the motor 
         * will effectively disconnect all motor wires. This allows the motor to spin down at 
         * its own rate. 
         */
        motor.setIdleMode(IdleMode.kCoast);
        motor2.setIdleMode(IdleMode.kCoast);
        
        motor2.follow(motor);
    }

    /** Retrieve cargo for transportation. */
    public static void fire() {
        motor.set(1);
    }

    /** Eject cargo from the robot. */
    public static void stop() {
        motor.set(0);
    }
    

    /** This method will be called once per scheduler run. */
    @Override
    public void periodic() {
        
    }

}