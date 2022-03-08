package frc.team2097.utility;

public class PIDValues {
    private double P;
    private double I;
    private double D;
    private double FF;

    public PIDValues(double P, double I, double D, double FF) {
        this.P = P;
        this.I = I;
        this.D = D;
        this.FF = FF;
    }

    public double getP() {
        return P;
    }

    public double getI() {
        return I;
    }

    public double getD() {
        return D;
    }

    public double getFF() {
        return FF;
    }
}