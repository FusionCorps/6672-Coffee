package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

import static frc.robot.RobotContainer.m_controller;

public class DriveChassis extends CommandBase {

    Chassis m_chassis;

    public DriveChassis(Chassis chassis) {
        m_chassis = chassis;
        addRequirements(m_chassis);
    }

    @Override
    public void execute() {
        m_chassis.curvatureDrive(m_controller.getRawAxis(1), m_controller.getRawAxis(4));
        System.out.println(m_chassis.photonTable.getEntry("targetYaw").getDouble(0.0));
    }

}
