package com.bl.cricketleagueanalysis.model;

import com.opencsv.bean.CsvBindByName;

public class BallerCSV {
    @CsvBindByName(column = "POS",required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER",required = true)
    public String player;

    @CsvBindByName(column = "Mat",required = true)
    public int match;

    @CsvBindByName(column = "Inns",required = true)
    public int inns;

    @CsvBindByName(column = "Ov",required = true)
    public double over;

    @CsvBindByName(column = "Runs",required = true)
    public int runs;

    @CsvBindByName(column = "Wkts",required = true)
    public int wkts;

    @CsvBindByName(column = "BBI",required = true)
    public int bbi;

    @CsvBindByName(column = "Avg",required = true)
    public double avg;

    @CsvBindByName(column = "Econ",required = true)
    public double econ;

    @CsvBindByName(column = "SR",required = true)
    public double sr;

    @CsvBindByName(column = "4w",required = true)
    public int fourW;

    @CsvBindByName(column = "5w",required = true)
    public int fiveW;



    public BallerCSV(){}

    public BallerCSV(int pos, String player, int match, int inns, double over, int runs, int wkts, int bbi, double avg, double econ, double sr, int fourW, int fiveW) {
        this.pos=pos;
        this.player=player;
        this.match=match;
        this.inns=inns;
        this.over=over;
        this.runs=runs;
        this.wkts=wkts;
        this.bbi=bbi;
        this.avg=avg;
        this.econ=econ;
        this.sr=sr;
        this.fourW=fourW;
        this.fiveW=fiveW;
    }
}

