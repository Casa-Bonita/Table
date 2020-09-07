public class Staff {
    int id;
    private String name;
    private String surname;
    private String position;
    private String phoneNumber;
    int age;

    public Staff() {
    }

    public Staff(int id, String name, String surname, String position, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
