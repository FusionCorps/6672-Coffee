package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class AutonTransition extends CommandBase {

    Chassis m_chassis;

    double left1;
    double right1;

    double left2;
    double right2;

    double left_rate;
    double right_rate;

    double mTime;

    private Timer timer = new Timer();

    public AutonTransition(Chassis chassis, double forward1, double rotation1,
                           double forward2, double rotation2, double time) {

        m_chassis = chassis;
        addRequirements(m_chassis);

        left1 = forward1;
        right1 = rotation1;

        left2 = forward2;
        right2 = rotation2;

        mTime = time;

        left_rate = (left2 - left1)/mTime;
        right_rate = (right2 - right1)/mTime;

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();

    }

    @Override
    public void execute() {
        m_chassis.setVoltages((left1 + left_rate *timer.get()), right1 + right_rate *timer.get());
    }

    @Override
    public boolean isFinished() {
        return  timer.hasElapsed(mTime);
    }

    @Override
    public void end(boolean interrupted) {
        m_chassis.curvatureDrive(0, 0);
    }


}
