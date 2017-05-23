package com.prover.prover.wrappers;

import com.prover.prover.models.Stand;

import java.util.List;

/**
 * Created by Admin on 23.05.2017.
 */
public class StandListWrapper {

    private List<Stand> standList;

    private long size;

    public List<Stand> getStandList() {
        return standList;
    }

    public void setStandList(List<Stand> standList) {
        this.standList = standList;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
