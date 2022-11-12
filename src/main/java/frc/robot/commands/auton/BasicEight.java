package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonEncoder;
import frc.robot.commands.AutonTransition;
import frc.robot.subsystems.Chassis;

public class BasicEight extends SequentialCommandGroup {

    Chassis m_chassis;

    public BasicEight(Chassis chassis) {
        m_chassis = chassis;

        addRequirements(m_chassis);

        addCommands(
                new AutonTransition(m_chassis, 0, 0, 6.0, 6.0, 1.0),
                new AutonEncoder(m_chassis, 6.0, 6.0, 70000),
                new AutonEncoder(m_chassis, 3.5, 6.0, 40000),
                new AutonEncoder(m_chassis, 6.0, 6.0, 50000),
                new AutonEncoder(m_chassis, 6.0, 3.5, 60000),
                new AutonEncoder(m_chassis, 6.0, 6.0, 45000),
                new AutonEncoder(m_chassis, 4.0, 1.0, 170000),
                new AutonEncoder(m_chassis, 6.0, 6.0, 45000),
                new AutonEncoder(m_chassis, 6.0, 3.5, 60000),
                new AutonEncoder(m_chassis, 6.0, 6.0, 50000),
                new AutonEncoder(m_chassis, 3.5, 6.0, 60000),
                new AutonEncoder(m_chassis, 6.0, 6.0, 30000)

        );
    }

}
