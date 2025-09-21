public abstract class User {
    protected String name;
    protected String rollNumber;
    protected LeaveService service = new LeaveService();

    public User(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public abstract void showMenu();
}