//Admin Class
//Author: Chenique Jacobs (220388172)
//Date: 07/04/2023

package za.ac.cput.domain;

public class Admin {
    private int adminId;
    private String name;
    private String surname;
    private String email;

    private Admin(int adminId, String name, String surname, String email){}

    public Admin(Builder builder){
        this.adminId = builder.adminId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + adminId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private int adminId;
        private String name;
        private String surname;
        private String email;

        public Builder setAdminId(int adminId){
            this.adminId = adminId;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email)
        {
            this.email = email;
            return this;
        }

        public Builder copy(Admin admin){
            this.adminId = admin.adminId;
            this.name = admin.name;
            this.surname = admin.surname;
            this.email = admin.email;
            return this;
        }

        public Admin build()
        {
            return new Admin(this);

        }

    }

}
