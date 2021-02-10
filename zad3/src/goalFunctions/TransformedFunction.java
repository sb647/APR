package goalFunctions;

import constraints.Constraint;
import constraints.Equality;
import constraints.Inequality;
import vector.Vector;

import java.util.List;

public class TransformedFunction extends GoalFunction {
    private GoalFunction f;
    private List<Constraint> implicitConstraints;
    private double t;

    public TransformedFunction(GoalFunction f, List<Constraint> implicitConstraints, double t) {
        this.f = f;
        this.implicitConstraints = implicitConstraints;
        this.t = t;
    }

    @Override
    public double calculate(Vector v) {
        double result = f.calculate(v);

        for(Constraint i : implicitConstraints) {
            if(i instanceof Equality) {
                double l = i.calculateLeftSide(v);
                if(! i.check(v)) result +=  t * l * l;
            } else if(i instanceof Inequality) {
                double l = i.calculateLeftSide(v);
                if(l > 0) result -= (double) (1 / t) * Math.log(l);
                if(l < 0){
                    result = Double.POSITIVE_INFINITY;
                    break;
                }
            }
        }
        return result;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getT() {
        return t;
    }
}
