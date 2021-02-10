package demo;

import alghoritm.BinAlghoritm;
import alghoritm.EliminationAlghoritm;
import crossing.ArithmeticalCrossover;
import crossing.BlendCrossover;
import crossing.MeanCrossover;
import crossing.UniformCrossover;
import functions.Function6;
import functions.Function7;
import mutation.BitMutation;
import mutation.Mutation;
import selection.TournamentSelection;

public class Zadatak3 {

    public static void main(String[] args) {
        int lowerBound = -50;
        int upperBound = 50;
        int populationSize = 50;
        int vectorSize = 6;
        int numberOfIterations = 500000;
        double delta = 1e-4;

        Function6 f6 = new Function6(vectorSize);
        Function7 f7 = new Function7(vectorSize);

        TournamentSelection ts = new TournamentSelection(3);
        UniformCrossover uc = new UniformCrossover();
        BitMutation bm = new BitMutation(0.1);

        Mutation mutation = new Mutation(0.05, 0.1, lowerBound, upperBound);
        BlendCrossover crss = new BlendCrossover(0.5);
       // EliminationAlghoritm ea = new EliminationAlghoritm(vectorSize,lowerBound,upperBound,populationSize,numberOfIterations, f7,ts,crss,mutation);
        //ea.execute();

        BinAlghoritm ba = new BinAlghoritm(vectorSize, lowerBound, upperBound, populationSize, numberOfIterations, delta, f7, ts, uc, bm);
        ba.execute();
    }
}
