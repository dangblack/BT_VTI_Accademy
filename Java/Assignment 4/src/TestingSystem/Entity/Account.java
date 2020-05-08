package TestingSystem.Entity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class Account {


    private int id;
    private String email;
    private String username;
    private Group[] groups;
    private String fullname;
    private LocalDate createDate;
    private Gender gender;
    private Department department;
    private Date createdate;
    private Position position;

    public Account(int id, String email, String username, Group[] groups, String fullname, LocalDate createDate, Gender gender, Department department, Date createdate, Position position) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.groups = groups;
        this.fullname = fullname;
        this.createDate = createDate;
        this.gender = gender;
        this.department = department;
        this.createdate = createdate;
        this.position = position;
    }

    public Account() {

    }
    public Account(int id, String email, String username, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.fullname = firstname + lastname;
    }

    public Account(int id, String email, String username, String firstname, String lastname, Position position, Date createDate) {
        this.fullname = firstname + lastname;
        this.createDate = java.time.LocalDate.now();
    }

    public Account(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static Comparator<Account> getCompare() {
        return compare;
    }

    public static void setCompare(Comparator<Account> compare) {
        Account.compare = compare;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public static Comparator<Account> compare = new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1.email.compareTo(o2.email);
        }
    };
}
