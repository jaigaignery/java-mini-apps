
public abstract class Computer extends Product {
    private double cpuSpeed;
    private int ram;
    private int storage;
    private boolean ssd;

    //getters for toString functions
    public double getCpuSpeed() {
        return cpuSpeed;
    }
    public int getRam() {
        return ram;
    }
    public int getStorage() {
        return storage;
    }
    public boolean isSsd() {
        return ssd;
    }

    public Computer(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage) {
        super(price, stockQuantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
    }
}
