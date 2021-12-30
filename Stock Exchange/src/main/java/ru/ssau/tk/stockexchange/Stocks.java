package ru.ssau.tk.stockexchange;

public class Stocks {

    private int Id;
    private String Name;
    private int PriceNow;

    public Stocks(int Id, String Name, int PriceNow) {
        this.Id = Id;
        this.Name = Name;
        this.PriceNow = PriceNow;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPriceNow() {
        return PriceNow;
    }

    public void setPriceNow(int priceNow) {
        PriceNow = priceNow;
    }
}
