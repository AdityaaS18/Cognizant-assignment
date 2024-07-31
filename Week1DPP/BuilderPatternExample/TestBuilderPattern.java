package Week1DPP.BuilderPatternExample;

public class TestBuilderPattern {
    public static void main(String[] args) {
        // Create a Computer with default configuration
        Computer defaultComputer = new Computer.Builder()
                .withCpu("Intel Core i5")
                .withRam(8)
                .withStorage(256)
                .build();

        System.out.println("Default Computer Configuration:");
        System.out.println("CPU: " + defaultComputer.getCpu());
        System.out.println("RAM: " + defaultComputer.getRam() + " GB");
        System.out.println("Storage: " + defaultComputer.getStorage() + " GB");

        // Create a Computer with custom configuration
        Computer customComputer = new Computer.Builder()
                .withCpu("AMD Ryzen 9")
                .withRam(16)
                .withStorage(512)
                .build();

        System.out.println("\nCustom Computer Configuration:");
        System.out.println("CPU: " + customComputer.getCpu());
        System.out.println("RAM: " + customComputer.getRam() + " GB");
        System.out.println("Storage: " + customComputer.getStorage() + " GB");
    }
}
