package web;

public class SingleChecker implements OperationPossibilityChecker {
    boolean itsA = false;
    boolean itsB = false;
    SingleChecker(String Name){
        if(Name.equals("A")){
            itsA=true;
        }
        else{
            itsB =true;
        }
    }

    @Override
    public boolean isPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows) {
        if(itsA)
            return ((aCols != null)  && (aRows != null));
        else
            return ((bCols != null)  && (bRows != null));
    }
}
