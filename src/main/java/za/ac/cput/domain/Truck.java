package za.ac.cput.domain;

public class Truck {
    private String truckId;
    private String model;
    private int year;
    private boolean availability;
    private String licensePlate;
    private double currentMileage;
    private int brandId;

    public Truck() {

    }
    private Truck(Builder builder) {
        this.truckId = builder.truckId;
        this.model = builder.model;
        this.year = builder.year;
        this.availability = builder.availability;
        this.licensePlate = builder.licensePlate;
        this.currentMileage = builder.currentMileage;
        this.brandId = builder.brandId;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(double currentMileage) {
        this.currentMileage = currentMileage;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", availability=" + availability +
                ", licensePlate='" + licensePlate + '\'' +
                ", currentMileage=" + currentMileage +
                ", brandId=" + brandId +
                '}';
    }

    public static class Builder {
        private String truckId;
        private String model;
        private int year;
        private boolean availability;
        private String licensePlate;
        private double currentMileage;
        private int brandId;


        public Builder setTruckId(String truckId) {
            this.truckId = truckId;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setCurrentMileage(double currentMileage) {
            this.currentMileage = currentMileage;
            return this;
        }

        public Builder setBrandId(int brandId) {
            this.brandId = brandId;
            return this;
        }
        public Builder copy (Truck truck){
            this.truckId = truck.truckId;
            this.model = truck.model;
            this.year = truck.year;
            this.availability = truck.availability;
            this.licensePlate = truck.licensePlate;
            this.currentMileage = truck.currentMileage;
            this.brandId = truck.brandId;
            return this;
        }

        public Truck build() {
            return new Truck(this);
        }
    }

}
