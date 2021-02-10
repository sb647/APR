package methods;


import goalFunctions.GoalFunction;
import interval.Interval;


public class GoldenRatio {


    private static double k = 0.5 *( Math.sqrt(5) - 1);


    public static Interval goldenRatio(GoalFunction f, Interval interval, boolean print, double e ) {
        double a = interval.getStart();
        double b = interval.getEnd();

        double c = b - k * (b - a);
        double d = a + k * (b - a);

        double fc = f.calculate(c);
        double fd = f.calculate(d);

        StringBuilder sb = new StringBuilder();

        while((b - a) > e) {

            sb.append(" a = " +a + ", f(a) = "+f.calculate(a));
            sb.append(" b = " +b + ", f(b) = "+f.calculate(b));
            sb.append(" c = " +c + ", f(c) = "+f.calculate(c));
            sb.append(" d = " +d + ", f(d) = "+f.calculate(d));
            f.setNumberOfCalls(f.getNumberOfCalls()-4);
            sb.append(System.lineSeparator());


            if(fc < fd) {
                b = d;
                d = c;
                c = b - k * (b - a);
                fd = fc;
                fc = f.calculate(c);


            }else {
                a = c;
                c = d;
                d = a + k * (b - a);
                fc = fd;
                fd = f.calculate(d);
            }

        }
        if(print) System.out.println(sb.toString());

        return new Interval(a,b);
    }

    public static Interval unimodal (double h, double x0, GoalFunction f ) {
        double l = x0 - h ;
        double r = x0 + h;
        double m = x0;
        double fl, fm, fr;
        int step = 1;

        fm = f.calculate(x0);
        fl = f.calculate(l);
        fr = f.calculate(r);


        if(fm < fr && fm < fl)
            return new Interval(l,r);

        else if(fm > fr)
            do
            {	l = m;
                m = r;
                fm = fr;
                r = x0 + h * (step*= 2);
                fr = f.calculate(r);
            } while(fm > fr);
        else
            do
            {	r = m;
                m = l;
                fm = fl;
                l = x0 - h * (step *= 2);
                fl = f.calculate(l);
            } while(fm > fl);

            return new Interval(l,r);
    }

    public static Interval goldenRatio(GoalFunction f, double h, double x0, boolean print, double e) {
        Interval interval = unimodal( h, x0, f);

        return goldenRatio(f, interval, print, e);
    }

}
