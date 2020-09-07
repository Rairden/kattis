package election2;

import lib.io.FastReader;

import java.util.*;

// https://open.kattis.com/problems/election2

public class Election2 {

    public static void main(String[] args) {

        String in = """
                3
                Marilyn Manson
                Rhinoceros
                Jane Doe
                Family Coalition
                John Smith
                independent
                6
                John Smith
                Marilyn Manson
                Marilyn Manson
                Jane Doe
                John Smith
                Marilyn Manson
                """;

        FastReader io = new FastReader(in);
        int numberOfCandidates = io.nextInt();

        Map<String, Ballot> candidates = new HashMap<>();

        for (int i = 0; i < numberOfCandidates; i++) {
            candidates.put(io.nextLine(), new Ballot(io.nextLine()));
        }

        int numberOfBallots = io.nextInt();

        List<Ballot> ballots = new ArrayList<>();
        Set<String> voteNames = new HashSet<>();

        for (int i = 0; i < numberOfBallots; i++) {
            String vote = io.nextLine();
            Ballot ballot = candidates.get(vote);

            if (ballot == null) continue;

            if (voteNames.add(vote)) {
                ballots.add(ballot);
            }
            ballot.votes++;
        }

        Collections.sort(ballots);

        if (ballots.size() == 0) {
            System.out.println("tie");
        } else if (ballots.size() == 1) {
            if (ballots.get(0).votes == 0) {
                System.out.println("tie");
            } else {
                System.out.println(ballots.get(0).party);
            }
        } else if (ballots.get(0).votes == ballots.get(1).votes) {
            System.out.println("tie");
        } else {
            System.out.println((ballots.get(0).party));
        }
    }
}

class Ballot implements Comparable<Ballot> {
    String party;
    short votes;

    public Ballot(String party) {
        this.party = party;
    }

    @Override
    public int compareTo(Ballot o) {
        return Short.compare(o.votes, this.votes);
    }
}
