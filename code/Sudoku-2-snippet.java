// Rows
for (int i = 0 ; i < nn ; ++i)
    model.allDifferent(grid[i]).post();

// Columns
for (int i = 0 ; i < nn ; ++i) {
    IntVar[] column = new IntVar[nn];
    for (int j = 0 ; j < nn ; ++j)
        column[j] = grid[j][i];
    model.allDifferent(column).post();
}

