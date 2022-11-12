package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class AutonEncoder extends CommandBase {

    Chassis m_chassis;

    double target;
    double offset;
    double left_power;
    double right_power;

    public AutonEncoder(Chassis chassis, double left, double right, double distance) {
        m_chassis = chassis;
        addRequirements(m_chassis);

        left_power = left;
        right_power = right;

        target = distance;

        offset = m_chassis.getLeftEncoder();
    }

    @Override
    public void initialize() {
        offset = m_chassis.getLeftEncoder();
    }

    @Override
    public void execute() {
        m_chassis.setVoltages(left_power, right_power);
    }

    @Override
    public boolean isFinished() {
        return (m_chassis.getLeftEncoder() - offset) > target;
    }

    @Override
    public void end(boolean isFinished) {
        // m_chassis.setVoltages(0, 0);
        System.out.println("finished" + offset);
    }

}
