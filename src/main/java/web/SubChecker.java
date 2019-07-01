package web;

public class SubChecker implements OperationPossibilityChecker{

    @Override
    public boolean isPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows) {
        return (aCols != null) && (bCols != null) && (aRows != null) && (bRows != null) &&
                ((aCols.equals(bCols) && aRows.equals(bRows)));
    }
}
