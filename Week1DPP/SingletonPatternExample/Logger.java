package Week1DPP.SingletonPatternExample;

// Logger.java (updated)
public class Logger {
    // Private static instance of Logger
    private static volatile Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Add logging methods as needed
    public void log(String message) {
        System.out.println(message);
    }
}