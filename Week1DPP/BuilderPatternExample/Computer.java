package Week1DPP.BuilderPatternExample;

public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        // build() method returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    // Getters for attributes
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }
}