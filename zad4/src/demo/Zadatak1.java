package demo;

import alghoritm.BinAlghoritm;
import alghoritm.EliminationAlghoritm;
import crossing.ArithmeticalCrossover;
import crossing.BlendCrossover;
import crossing.UniformCrossover;
import functions.Function1;
import functions.Function3;
import functions.Function6;
import functions.Function7;
import mutation.BitMutation;
import mutation.Mutation;
import selection.TournamentSelection;


public class Zadatak1 {

    public static void main(String[] args) {

        int lowerBound = -50;
        int upperBound = 150;
        int populationSize = 100;
        int vectorSize = 2;
        int numberOfIterations = 500000;
        double delta = 1e-4;

        Function1 f1 = new Function1();
        Function3 f3 = new Function3(vectorSize);
        Function6 f6 = new Function6(vectorSize);
        Function7 f7 = new Function7(vectorSize);



        Mutation mutation = new Mutation(0.05, 0.1, -50, 150);
        TournamentSelection ts = new TournamentSelection(5);
        BlendCrossover crss = new BlendCrossover(0.5);
        EliminationAlghoritm ea = new EliminationAlghoritm(5,-50,150,100,500000, f6,ts,crss,mutation);
        //ea.execute();
        UniformCrossover uc = new UniformCrossover();
        BitMutation bm = new BitMutation(0.1);



        BinAlghoritm ba = new BinAlghoritm(vectorSize, lowerBound,upperBound, populationSize, numberOfIterations, delta, f1, ts, uc, bm );
        ba.execute();


    }
}
