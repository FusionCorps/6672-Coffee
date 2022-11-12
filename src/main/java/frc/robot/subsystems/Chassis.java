package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {

    WPI_TalonFX drive_fl;
    WPI_TalonFX drive_bl;
    WPI_TalonFX drive_fr;
    WPI_TalonFX drive_br;

    DifferentialDrive m_drive;

    public NetworkTable photonTable = NetworkTableInstance.getDefault().getTable("photonvision").getSubTable("gloworm");

    public Chassis() {
        drive_fl = new WPI_TalonFX(Constants.DRIVE_FL_ID);
        drive_bl = new WPI_TalonFX(Constants.DRIVE_BL_ID);
        drive_fr = new WPI_TalonFX(Constants.DRIVE_FR_ID);
        drive_br = new WPI_TalonFX(Constants.DRIVE_BR_ID);

        drive_fr.setInverted(true);
        drive_br.setInverted(true);

        MotorControllerGroup l_motors = new MotorControllerGroup(drive_fl, drive_bl);
        MotorControllerGroup r_motors = new MotorControllerGroup(drive_fr, drive_br);

        m_drive = new DifferentialDrive(l_motors, r_motors);

    }

    @Override
    public void periodic() {
        m_drive.feed();
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public void curvatureDrive(double fwd, double rot) {
        m_drive.curvatureDrive(fwd, rot, true);
    }

    public void setVoltages(double left_v, double right_v) {
        drive_fl.setVoltage(left_v);
        drive_bl.setVoltage(left_v);

        drive_fr.setVoltage(right_v);
        drive_br.setVoltage(right_v);
    }

    public double getLeftEncoder() {
        return (drive_fl.getSelectedSensorPosition()+ drive_bl.getSelectedSensorPosition())/2;
    }

}
