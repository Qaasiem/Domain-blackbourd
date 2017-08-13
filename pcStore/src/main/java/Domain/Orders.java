package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-04.
 */

public class Orders implements Serializable{

    private Long id;
    private String date;
    private double totalPrice = 0;

    public Orders() {
    }

    public Long getID() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Orders(Builder builder)
    {
        this.id = builder.id;
        this.date = builder.date;
        this.totalPrice = builder.totalPrice;
    }

    public static class Builder
    {
        private Long id;
        private String date;
        private double totalPrice = 0;

        public Builder date(String date)
        {
            this.date = date;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder totalPrice(double totalPrice)
        {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder copy(Orders orders)
        {
            this.date = orders.date;
            this.id = orders.id;
            this.totalPrice = orders.totalPrice;

            return this;
        }

        public Orders build()
        {
            return new Orders(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        return id.equals(orders.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Date: " + date + "" + "Total Price: R" + totalPrice;
    }
}


