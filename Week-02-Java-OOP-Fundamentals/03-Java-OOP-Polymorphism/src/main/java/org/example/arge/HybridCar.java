package org.example.arge;

public class HybridCar extends CarSkeleton {
    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String name, String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(name, description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLitre() { return avgKmPerLitre; }
    public Integer getBatterySize()  { return batterySize; }
    public Integer getCylinders()    { return cylinders; }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + ": hybrid engine starting");
    }

    @Override
    public void drive() {
        runEngine();
        System.out.println(getClass().getSimpleName() + ": driving on hybrid power");
    }

    @Override
    protected void runEngine() {
        System.out.println(getClass().getSimpleName() + ": hybrid engine running");
    }
}