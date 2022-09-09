package nl.belastingdienst.douane.inleidingprogrammeren;

public class Submarine {
    private final Position m_position;

    public Submarine()
    {
        m_position = new Position(0, 0);
    }

    public static int countIncrements(int[] depthReport)
    {
        if (depthReport.length <= 1)
            return 0;

        int currentDepth = depthReport[0];
        int numIncrements = 0;

        for (int i = 1; i < depthReport.length; ++i) {
            if (depthReport[i] > currentDepth)
                ++numIncrements;
            currentDepth = depthReport[i];
        }

        return numIncrements;
    }

    public Position position() { return m_position; }

    public void updatePosition(String command)
    {
        String[] parts = command.split(" ");
        String direction = parts[0];
        int distance = Integer.parseInt(parts[1]);

        if (direction.equals("up") || direction.equals("backward"))
            distance *= -1;

        if (direction.equals("forward") || direction.equals("backward"))
            m_position.x += distance;
        else
            m_position.y += distance;
    }

    public static int calculatePower(String[] diagnosticReport)
            throws StringIndexOutOfBoundsException
    {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int i = 0; i < 5; ++i) {
            int numOnes = 0;
            for (String message : diagnosticReport) {
                if (message.charAt(i) == '1')
                    ++numOnes;
            }
            boolean moreOnesThanZeros = numOnes > diagnosticReport.length - numOnes;
            gamma.append(moreOnesThanZeros ? "1" : "0");
            epsilon.append(moreOnesThanZeros ? "0" : "1");
        }

        return toInt(gamma) * toInt(epsilon);
    }

    private static int toInt(StringBuilder rate)
    {
        return Integer.parseInt(rate.toString(), 2);
    }
}
