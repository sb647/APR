package demo;

import alghoritm.BinAlghoritm;
import crossing.UniformCrossover;
import functions.Function6;
import functions.Function7;
import mutation.BitMutation;
import selection.TournamentSelection;

public class Zadatak2 {

    public static void main(String[] args) {


        int lowerBound = -10;
        int upperBound = 10;
        int populationSize = 50;
        int vectorSize = 3;
        int numberOfIterations = 3000000;
        double delta = 1e-4;

        Function6 f6 = new Function6(vectorSize);
        Function7 f7 = new Function7(vectorSize);

        TournamentSelection ts = new TournamentSelection(3);
        UniformCrossover uc = new UniformCrossover();
        BitMutation bm = new BitMutation(0.1);

        BinAlghoritm ba = new BinAlghoritm(vectorSize, lowerBound, upperBound, populationSize, numberOfIterations, delta, f7, ts, uc, bm);
        ba.execute();


    }
}
