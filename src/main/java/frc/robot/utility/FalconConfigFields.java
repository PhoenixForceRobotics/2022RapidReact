package frc.robot.utility;

public class FalconConfigFields {
    private PIDValues[] falconPIDs;
    private double maxOutput;
    private int timeout;

    public FalconConfigFields(PIDValues[] falconPIDs, double maxOutput, int timeout)
    {
        this.falconPIDs = falconPIDs;
        this.maxOutput = maxOutput;
        this.timeout = timeout;
    }

    public PIDValues[] getFalconPIDs() {
        return falconPIDs;
    }

    public double getMaxOutput() {
        return maxOutput;
    }

    public int getTimeout() {
        return timeout;
    }
}
