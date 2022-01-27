package frc.robot.commands;

import java.util.ResourceBundle.Control;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.TurretSubsystem;

public class TurretTrack extends CommandBase{
    private TurretSubsystem m_turret;
    private LimelightSubsystem m_limelight;
    private XboxController m_controller;

    public TurretTrack(TurretSubsystem subsystem, LimelightSubsystem ls, XboxController controller) {
        m_turret= subsystem;
        m_limelight= ls;
        m_controller= controller;
        addRequirements(m_turret, m_limelight);
    }

    @Override
    public void initialize(){
        m_turret.configureTurret(); //Configures the turret to run at max velocity + acceleration
    }

    double error;
    double currentPOS;
    @Override
    public void execute() {
        error = m_limelight.getHorizontalOffset(true); //Gets the x angle from the limelight
        SmartDashboard.putBoolean("PID Running", false);
        SmartDashboard.putNumber("Error", error);
        SmartDashboard.putNumber("Current POS", m_turret.getPOS());
        
        error = -error + m_turret.getPOS();
        SmartDashboard.putNumber("INPUT ERROR", error);
        m_turret.PIDmove(error);
      }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interupted){
    } 

    

    
}
