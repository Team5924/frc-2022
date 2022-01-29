package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

    // private final WPI_TalonSRX intakeTalon = new WPI_TalonSRX(IntakeConstants.INTAKE_TALON); // Talon 5
    private final DoubleSolenoid leftDoubleSolenoid;
    private final DoubleSolenoid rightDoubleSolenoid;

    public IntakeSubsystem() {
        leftDoubleSolenoid = new DoubleSolenoid(IntakeConstants.CTRE_PCM, PneumaticsModuleType.CTREPCM, IntakeConstants.LEFT_PNEUMATIC_FORWARD, IntakeConstants.LEFT_PNEUMATIC_REVERSE);
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
        rightDoubleSolenoid = new DoubleSolenoid(IntakeConstants.CTRE_PCM, PneumaticsModuleType.CTREPCM, IntakeConstants.RIGHT_PNEUMATIC_FORWARD, IntakeConstants.RIGHT_PNEUMATIC_REVERSE);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("Left Pneumatic State", solenoidStatus(leftDoubleSolenoid));
        SmartDashboard.putString("Left Pneumatic State", solenoidStatus(rightDoubleSolenoid));
    }

    private String solenoidStatus(DoubleSolenoid solenoid) {
        DoubleSolenoid.Value solenoidState = solenoid.get();
        if (solenoidState.equals(DoubleSolenoid.Value.kForward)) {
            return "Forward";
        } else if (solenoidState.equals(DoubleSolenoid.Value.kReverse)) {
            return "Reverse";
        } else if (solenoidState.equals(DoubleSolenoid.Value.kOff)) {
            return "Off";
        } else {
            return "Error";
        }
    }
    
    public void intake() {
        // moves the motors
        // intakeTalon.set(-1);

    }

    public void extend() {
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void retract() {
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

    