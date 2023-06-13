//ReturnTruck Class
//Author: Chenique Jacobs (220388172)
//Date: 07/04/2023

package za.ac.cput.domain;

import java.time.LocalDate;

public class ReturnTruck {
    private int returnId;
    private int rentalId;
    private double overdueCharge;
    private LocalDate returnDate;

    private ReturnTruck(int returnId,int rentalId,double overdueCharge,LocalDate returnDate){};


    public ReturnTruck(Builder builder){
        this.returnId = builder.returnId;
        this.rentalId = builder.rentalId;
        this.overdueCharge = builder.overdueCharge;
        this.returnDate = builder.returnDate;
    }

    public int getReturnId() {
        return returnId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public double getOverdueCharge() {
        return overdueCharge;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "ReturnTruck{" +
                "returnId=" + returnId +
                ", rentalId=" + rentalId +
                ", overdueCharge=" + overdueCharge +
                ", returnDate=" + returnDate +
                '}';
    }

    public static class Builder{
        private int returnId;
        private int rentalId;
        private double overdueCharge;
        private LocalDate returnDate;

        public Builder setReturnId(int returnId){
            this.returnId = returnId;
            return this;
        }

        public Builder setRentalId(int rentalId){
            this.rentalId= rentalId;
            return this;
        }

        public Builder setOverdueCharge(double overdueCharge){
            this.overdueCharge = overdueCharge;
            return this;
        }

        public Builder setReturnDate(LocalDate returnDate){
            this.returnDate = returnDate;
            return this;
        }

        public Builder copy(ReturnTruck returnTruck){
            this.returnId = returnTruck.returnId;
            this.rentalId = returnTruck.rentalId;
            this.overdueCharge = returnTruck.overdueCharge;
            this.returnDate = returnTruck.returnDate;
            return this;
        }

        public ReturnTruck build(){
            return new ReturnTruck(this);
        }

    }

}
