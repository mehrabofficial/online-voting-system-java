import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList<Candidate> candidates;
    private ArrayList<Voter> voters;

    public Admin() {
        this.candidates = new ArrayList<Candidate>();
        this.voters = new ArrayList<Voter>();
    }


    public ArrayList<Candidate> getCandidates() {
        return this.candidates;
    }

    public ArrayList<Voter> getVoters() {
        return this.voters;
    }

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
    }

    public void removeCandidate(Candidate candidate) {
        this.candidates.remove(candidate);
    }

    public void addVoter(Voter voter) {
        this.voters.add(voter);
    }

    public void removeVoter(Voter voter) {
        this.voters.remove(voter);
    }



    public void collectVotes() {
        Scanner scanner = new Scanner(System.in);
        for (Voter voter : this.voters) {
            if (!voter.hasVoted()) {
                System.out.println("Please select a candidate to vote for:");
                for (int i = 0; i < this.candidates.size(); i++) {
                    Candidate candidate = this.candidates.get(i);
                    System.out.println((i+1) + ") " + candidate.getName());
                }
                int choice = scanner.nextInt();
                Candidate candidate = this.candidates.get(choice-1);
                candidate.addVote();
                voter.vote();
            }
        }
    }

    public void showResults() {
        System.out.println("Voting Results:");
        for (Candidate candidate : this.candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes());
        }
    }
}
