package za.ac.cput.domain;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
public class Protection implements Serializable {

    @Id
    private String insuranceId;
    private String truckId;
    private String policyType;
    private String startDate;
    private String endDate;

    protected Protection(){}

    public Protection(Builder builder){
        this.insuranceId= builder.insuranceId;
        this.truckId= builder.truckId;
        this.policyType= builder.policyType;
        this.startDate = builder.startDate;
        this.endDate= builder.endDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "Protection{" +
                "insuranceId='" + insuranceId + '\'' +
                ", truckId='" + truckId + '\'' +
                ", policyType='" + policyType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{

        private String insuranceId;
        private String truckId;
        private String policyType;
        private String startDate;
        private String endDate;

        public Builder setInsuranceId(String insuranceId) {
            this.insuranceId = insuranceId;
            return this;
        }

        public Builder setTruckId(String truckId) {
            this.truckId = truckId;
            return this;
        }

        public Builder setPolicyType(String policyType) {
            this.policyType = policyType;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Protection protection){
            this.insuranceId = protection.insuranceId;
            this.truckId= protection.truckId;
            this.policyType= protection.policyType;
            this.startDate = protection.startDate;
            this.endDate= protection.endDate;
            return this;

        }

        public Protection build(){
            return new Protection(this);
        }
    }
}
