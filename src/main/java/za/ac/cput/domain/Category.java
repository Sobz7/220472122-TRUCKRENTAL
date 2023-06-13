package za.ac.cput.domain;

public class Category {

    private String categoryId;
    private String description;
    private int truckSize;
    private String truckType;


    private Category() {
    }

    public Category(Builder builder){
        this.categoryId = builder.categoryId;
        this.description = builder.description;
        this.truckSize = builder.truckSize;
        this.truckType  = builder.truckType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTruckSize() {
        return truckSize;
    }

    public void setTruckSize(int truckSize) {
        this.truckSize = truckSize;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", truckSize=" + truckSize +
                ", truckType='" + truckType + '\'' +
                '}';
    }

    public static class Builder {
        private String categoryId;
        private String description;
        private int truckSize;
        private String truckType;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setTruckSize(int truckSize) {
            this.truckSize = truckSize;
            return this;
        }

        public Builder setTruckType(String truckType) {
            this.truckType = truckType;
            return this;

        }
        public Builder copy (Category category){
            this. categoryId = category.categoryId;
            this.description = category.description;
            this.truckSize = category.truckSize;
            this.truckType = category.truckType;
            return this;
        }

        public Category build() {
            return new Category(this);
        }


    }
}
