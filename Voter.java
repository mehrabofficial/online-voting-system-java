public class Voter {
    private String name;
    private String username;
    private String password;
    private boolean hasVoted;

    public Voter(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.hasVoted = false;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean hasVoted() {
        return this.hasVoted;
    }

    public void vote() {
        this.hasVoted = true;
    }
}
