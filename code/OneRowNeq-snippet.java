for (int a = 0 ; a < xs.length ; ++a)
    for (int b = a + 1 ; b < xs.length ; ++b)
        model.arithm(xs[a], "!=", xs[b]).post();
