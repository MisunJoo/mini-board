package my.examples.miniboard.servlet;

public class User {
    /*
    id int not null, auto_increment,
	user_id varchar(20),
	password varchar(20),
	primary key(id)
     */
    private long id; //**왜 long일까?
    private String user_name;
    private String password;

    public User(){

    }

    public User(String userId, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
