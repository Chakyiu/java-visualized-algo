package com.lcy.data;

public class Data {

    private Integer number;
    private State state;

    public Data(Integer number, State state) {
        this.number = number;
        this.state = state;
    }

    public void setData(Data data) {
        this.number = data.getNumber();
        this.state = data.getState();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
