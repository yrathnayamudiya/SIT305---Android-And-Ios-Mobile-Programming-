package com.example.lastonetest;

public class productsModal {
    String router_imi;
    String sim_imi;
    String date;

    private productsModal() {
    }


    private productsModal(String router_imi ,String sim_imi,String date) {
        this.router_imi = router_imi;
        this.sim_imi = sim_imi;
        this.date = date;
    }

    public String getRouter_imi() {
        return router_imi;
    }

    public void setRouter_imi(String router_imi) {
        this.router_imi = router_imi;
    }

    public String getSim_imi() {
        return sim_imi;
    }

    public void setSim_imi(String sim_imi) {
        this.sim_imi = sim_imi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
