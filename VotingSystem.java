import java.util.Scanner;

public class VotingSystem {
    private Admin admin;
    private Voter currentVoter;

    public VotingSystem() {
        this.admin = new Admin();
        this.currentVoter = null;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Welcome to the Online Voting System!");
            System.out.println("Please select an option:");
            System.out.println("1. Register as a voter");
            System.out.println("2. Login");
            System.out.println("3. Vote");
            System.out.println("4. Quit/Show Result");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerVoter(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    vote(scanner);
                    break;
                case 4:
                    quit = true;
                    this.admin.showResults();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void registerVoter(Scanner scanner) {
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter a username:");
        String username = scanner.nextLine();
        System.out.println("Please enter a password:");
        String password = scanner.nextLine();

        Voter voter = new Voter(name, username, password);
        this.admin.addVoter(voter);
        System.out.println("You have successfully registered as a voter.");
    }

    private void login(Scanner scanner) {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        for (Voter voter : this.admin.getVoters()) {
            if (voter.getUsername().equals(username) && voter.getPassword().equals(password)) {
                this.currentVoter = voter;
                System.out.println("You have successfully logged in.");
                return;
            }
        }

        System.out.println("Invalid username or password.");
    }

    private void vote(Scanner scanner) {
        if (this.currentVoter == null) {
            System.out.println("You must login first.");
            return;
        }

        if (this.currentVoter.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }

        System.out.println("Please select a candidate to vote for:");
        for (int i = 0; i < this.admin.getCandidates().size(); i++) {
            Candidate candidate = this.admin.getCandidates().get(i);
            System.out.println((i+1) + ") " + candidate.getName());
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice < 1 || choice > this.admin.getCandidates().size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Candidate candidate = this.admin.getCandidates().get(choice-1);
        candidate.addVote();
        this.currentVoter.vote();
        System.out.println("Thank you for voting.");
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.admin.addCandidate(new Candidate("Vote CSE"));
        votingSystem.admin.addCandidate(new Candidate("Vote EEE"));

        votingSystem.run();
    }
}
