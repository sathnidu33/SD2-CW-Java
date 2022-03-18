public class patient {

        private String firstName;
        private String lastName;
        private String age;
        private String city;
        private String idNum;
        private int boothNumber;

//Constructor
        public patient(String firstName, String lastName, String age, String city, String idNum){
            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.city=city;
            this.idNum = idNum;


        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }
}


