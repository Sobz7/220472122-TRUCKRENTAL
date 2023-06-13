package za.ac.cput.domain;
/*Brand Entity
Author Ayanda Phumzile Khoza
Student Number 218057172
 */

public class Brand {

    private int brandId;

    private String brandName;

    private String model;

    private String color;
    private String locationId;

    private Brand(){}

    private Brand(Builder builder)
    {

        this.brandId = builder.brandId;
        this.brandName = builder.brandName;
        this.model = builder.model;
        this.color = builder.color;

    }

    public int getBrandId()
    {
        return brandId;
    }

    public void setBrandId(int brandId)
    {
        this.brandId = brandId;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationId() {
        return locationId;
    }


    public static class Builder{

        private int brandId;
        private String brandName;
        private String model;
        private String color;


        public Builder setBrandId(int brandId){
            this.brandId = brandId;
            return this;
        }

        public Builder setBrandName(String brandName){
            this.brandName = brandName;
            return this;
        }

        public Builder setModel(String model){
            this.model = model;
            return this;
        }
        public Builder setColor(String color){
            this.color = color;
            return this;
        }
        public Builder copy(Brand brand){
            this.brandId = brand.brandId;
            this.brandName = brand.brandName;
            this.model = brand.model;
            this.color = brand.color;
            return this;
        }
        public Brand build(){
            return new Brand(this);
        }
    }

    public Builder copy() {
        return null;
    }
}
