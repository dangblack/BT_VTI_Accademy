package Model;

import java.util.Comparator;
import java.util.Date;

public class Account {


    public int id;
    public String email;
    public Department department;
    public Group[] groups;
    public Date createDate;
    public Gender gender;

    public Account(int id, String email, Department department, Group[] groups, Date createDate, Gender gender) {
        this.id = id;
        this.email = email;
        this.department = department;
        this.groups = groups;
        this.createDate = createDate;
        this.gender = gender;
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail(String s) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Gender getGender() {
        return gender;
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
