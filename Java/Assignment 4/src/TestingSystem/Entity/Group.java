package TestingSystem.Entity;

import java.time.LocalDate;

public class Group {
    private int id;
    private String name;
    private int creatorid;
    private LocalDate createdate;
    Account[] accounts;
    String[] usernames;
    public Group(int id, String name, int creatorid, LocalDate createdate) {
        this.id = id;
        this.name = name;
        this.creatorid = creatorid;
        this.createdate = createdate;
    }

    public Group(String name, LocalDate createdate, Account[] accounts) {
        this.name = name;
        this.createdate = createdate;
        this.accounts = accounts;

    }



    public Group(String name, LocalDate createdate, String[] usernames) {
        this.name = name;
        this.createdate = createdate;
        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            Account account = new Account(usernames[i]);
            account = accounts[i];
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }
}
