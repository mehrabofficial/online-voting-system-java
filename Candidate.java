public class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getVotes() {
        return this.votes;
    }

    public void addVote() {
        this.votes++;
    }
}
