package methods;

import goalFunctions.GoalFunction;
import vector.Vector;


public class HookeJeeves {

    private static double e = 10E-6;
    private static double dx = 0.5;


    public static Vector hookeJeeves(Vector x0, GoalFunction f) {
        Vector xP = x0.copy();
        Vector xB = x0.copy();
        Vector xN;
        do {
            xN = exploreMethod(xP, f);   // definiran je potprogram
            if(f.calculate(xN) < f.calculate(xB) )   // prihvacamo baznu tocku
            {
                xP = xN.scalarMultiply(2).sub(xB);  // definiramo novu tocku pretrazivanja
                xB = xN;
            }
            else
            {
                dx *= 0.5;
                xP = xB;        // vracamo se na zadnju baznu tocku
            }

        } while (e < dx);
        return xB;
    }

    private static Vector exploreMethod(Vector xP, GoalFunction f) {

        Vector x = xP.copy();

        //trazimo tocku u kojoj je manji iznos fje
        for(int i=0 ; i < x.size(); i++)
        {
            double P = f.calculate(x);

            x.setValue(i, (x.getValueAt(i) + dx));      // povecamo za Dx
            double N = f.calculate(x);
            if (N > P)            // ne valja pozitivni pomak
            {
               x.setValue(i, (x.getValueAt(i) - 2* dx));  // smanjimo za Dx
                N = f.calculate(x);
                if( N > P)        // ne valja ni negativni
                    x.setValue(i, (x.getValueAt(i) + dx));  // vratimo na staro
            }
        }
        return x;
    }
}
