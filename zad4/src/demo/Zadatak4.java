package demo;

import alghoritm.BinAlghoritm;
import crossing.UniformCrossover;
import functions.Function6;
import mutation.BitMutation;
import selection.TournamentSelection;

public class Zadatak4 {

    public static void main(String[] args) {
        int lowerBound = -50;
        int upperBound = 50;
        int populationSize = 100;
        int vectorSize = 6;
        int numberOfIterations = 6000;
        double delta = 1e-4;

        Function6 f6 = new Function6(vectorSize);
        TournamentSelection ts = new TournamentSelection(3);
        UniformCrossover uc = new UniformCrossover();
        BitMutation bm = new BitMutation(0.1);
        BinAlghoritm ba = new BinAlghoritm(vectorSize, lowerBound, upperBound, populationSize, numberOfIterations, delta, f6, ts, uc, bm);
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();
        ba.execute();

    }
}
