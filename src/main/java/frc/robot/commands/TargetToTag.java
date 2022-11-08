package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

import static java.lang.Math.abs;

public class TargetToTag extends CommandBase {

    Chassis m_chassis;

    public TargetToTag(Chassis chassis) {

        m_chassis = chassis;
        addRequirements(m_chassis);

    }

    @Override
    public void execute() {
        double tx = m_chassis.photonTable.getEntry("targetYaw").getDouble(0.0);

        m_chassis.curvatureDrive(0, 0.0055*tx + (tx/(abs(tx))*0.05));
    }

    @Override
    public void end(boolean isFinished) {
        m_chassis.curvatureDrive(0, 0);
    }

}
