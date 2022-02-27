// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        // Motor IDs
        public static final int LEFT_FRONT_TALON = 4;
        public static final int RIGHT_FRONT_TALON = 2;
        public static final int LEFT_BACK_TALON = 3;
        public static final int RIGHT_BACK_TALON = 1;

        //Max velocity in sensor units per 100ms
        public static final double MAX_VELOCITY = 17421;

        public static final int TIMEOUT_MS = 30;
        public static final int PID_LOOP_IDX = 0;
        public static final int SLOT_IDX = 0;
        public static final double F = 0.8 * 1023 / 17421;
        public static final double P = 0.2;
        public static final double I = 0;
        public static final double D = 0;

        // Current limit for motors in amps
        public static final double CURRENT_LIMIT = 40;
        // Amps at which to trigger current limit
        public static final double TRIGGER_THRESHOLD_CURRENT = 45;
        // Trigger threshold must be attained for this amount of time to trigger current limit
        public static final double TRIGGER_THRESHOLD_TIME = 1;
    }

    public static final class TurretConstants {
        public static final int TURRET_TALON = 4;
        public static final int MAX_VELOCITY = 375;
        public static final int MAX_ACCELERATION = 375;

        // Degrees of Freedom
        public static double DEGREE = 1024;

        // PID CONTROL SPECIFIC CONSTANTS
        public static final int TIMEOUT_MS = 30;
        public static final int SLOT_IDX= 0;
        public static final int PIDLOOP_ID= 0;
        public static double KF = .55;
        public static final double KP= .45;
        public static final double KI= 0;
        public static final double KD= 4.5;
        public static final double ALLOWABLE_ERROR= 1;
        public static final double I_ZONE= 0;
        public static final double MAX_INTEGRAL_ACCUMULATOR= 0;
        public static final double PEAK_OUTPUT= 12;
        public static final int SMOOTHING= 3;

        // LIMELIGHT ANGLE | Reference: https://docs.limelightvision.io/en/latest/cs_estimating_distance.html#using-area
        public static final double ANGLE_1 = (Math.PI/5); // 36 degrees
        public static final double HEIGHT_1 = 0.686; // Unit: meters | 27 inches
        public static final double HEIGHT_2 = 2.438; // Unit: meters | 8 feet
    }

    public static final class ShooterConstants {
        /*
            Max Motor RPM = 5676
            Wheel Diameter = 4 in.
            1:1.25 ratio
            Max Wheel RPM = 7095
            Distance = 6ft - 30ft
        */
        public static final int MASTER_SPARK = 1;
        public static final int SLAVE_MASTER = 2;
        
        public static final double MAX_VELOCITY = 2000;

        public static final int TIMEOUT_MS = 30;
        public static final int kPIDLoopIdx = 0;
        public static final int kF = 0;
        public static final int kP = 0;
        public static final int kI = 0;
        public static final int kD = 0;
    }

    public static final class OIConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final double DRIVER_CONTROLLER_DEADBAND = 0.05;
    }
}
