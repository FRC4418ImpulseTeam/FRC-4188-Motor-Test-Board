package frc.robot.util;

public class Units{

    public static double rpmToTicksPer100ms(double rpm){

        // rev/min * 4096ticks/1rev * 1min/60 sec * 1sec/10 100ms
        return (rpm * (4096 / (60 * 10)) );
    }

    public static double gearReduction(double rpm, double reduction){
        return rpm * reduction;
    }

}