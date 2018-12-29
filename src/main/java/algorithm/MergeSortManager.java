package algorithm;

import fun3mergesortfx.FUN3MergeSortFX;
import timeutil.TimeStamp;

import java.util.List;

public class MergeSortManager {
    private MergeSortLogic logic;
    private TimeStamp tsCalc;
    private FUN3MergeSortFX application;

    public MergeSortManager(FUN3MergeSortFX application) {
        this.application = application;
        this.logic = new MergeSortLogic();
        this.tsCalc = new TimeStamp();
    }

    public List<Offer> sort(String compareMethodName, String getMethodName){
        tsCalc.init();
        tsCalc.setBegin("Begin calculating");
        List<Offer> offers = logic.TopDownMergeSort(OfferList.offerList, compareMethodName, getMethodName);
        tsCalc.setEnd("End Calculating");
        application.setSortingTimeText(tsCalc.toString());
        return offers;
    }
}
