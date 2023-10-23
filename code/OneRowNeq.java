import java.util.Arrays;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.exception.ContradictionException;

class OneRowNeq
{
    public static void main(String[] args) throws ContradictionException
    {
        Model model = new Model();
        IntVar x1 = model.intVar("x1", new int[]{1,8});
        IntVar x2 = model.intVar("x2", new int[]{2,3});
        IntVar x3 = model.intVar("x3", new int[]{2,3});
        IntVar x4 = model.intVar("x4", new int[]{2,4,5});
        IntVar x5 = model.intVar("x5", new int[]{4,5,6});
        IntVar x6 = model.intVar("x6", new int[]{4,5,6});
        IntVar x7 = model.intVar("x7", new int[]{2,7,9});
        IntVar x8 = model.intVar("x8", new int[]{3,7,8});
        IntVar x9 = model.intVar("x9", new int[]{2,3,5,8,9});
        IntVar[] xs = new IntVar[]{x1,x2,x3,x4,x5,x6,x7,x8,x9};
        for (int a = 0 ; a < xs.length ; ++a)
            for (int b = a + 1 ; b < xs.length ; ++b)
                model.arithm(xs[a], "!=", xs[b]).post();

        System.out.println("Before: " + Arrays.toString(xs));
        Solver solver = model.getSolver();
        solver.propagate();
        System.out.println("After: " + Arrays.toString(xs));
    }
}

