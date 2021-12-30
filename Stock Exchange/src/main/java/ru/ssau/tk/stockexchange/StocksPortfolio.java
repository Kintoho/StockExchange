package ru.ssau.tk.stockexchange;

public class StocksPortfolio {

    private int idstocks_portfolio;
    private String stockName;
    private int BuyPrice;
    private int number;
    private int PriceChange;

    public int getPriceChange() {
        return PriceChange;
    }

    public void setPriceChange(int priceChange) {
        PriceChange = priceChange;
    }

    public StocksPortfolio(int idstocks_portfolio,String stockName, int buyPrice, int number, int priceChange) {
        this.idstocks_portfolio = idstocks_portfolio;
        this.stockName = this.stockName;
        this.BuyPrice= BuyPrice;
        this.number = this.number;
        this.PriceChange = PriceChange;

    }


    public StocksPortfolio(String stockName, int buyPrice, int number, int priceChange) {
        this.stockName = this.stockName;
        this.BuyPrice= BuyPrice;
        this.number = this.number;
        this.PriceChange = PriceChange;

    }


    public int getIdstocks_portfolio() {
        return idstocks_portfolio;
    }

    public void setIdstocks_portfolio(int idstocks_portfolio) {
        this.idstocks_portfolio = idstocks_portfolio;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
