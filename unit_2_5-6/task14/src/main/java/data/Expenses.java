package data;

import java.io.Serializable;
import java.sql.Date;

public class Expenses implements Serializable {

    private int num;
    private Date paydate;
    private int receiver;
    private Double value;

    public Expenses() {
    }

    public int getNum() {
        return num;
    }

    public Date getPaydate() {
        return paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public Double getValue() {
        return value;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenses)) return false;

        Expenses expenses = (Expenses) o;

        if (getNum() != expenses.getNum()) return false;
        if (getReceiver() != expenses.getReceiver()) return false;
        if (getPaydate() != null ? !getPaydate().equals(expenses.getPaydate()) : expenses.getPaydate() != null)
            return false;
        return getValue() != null ? getValue().equals(expenses.getValue()) : expenses.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getNum();
        result = 31 * result + (getPaydate() != null ? getPaydate().hashCode() : 0);
        result = 31 * result + getReceiver();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "num=" + num +
                ", paydate=" + paydate +
                ", receiver=" + receiver +
                ", value=" + value +
                '}';
    }
}
