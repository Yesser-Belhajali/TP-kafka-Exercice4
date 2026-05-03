package tn.utm.kafka;

import java.util.List;

public class Commande {

    private int id;
    private String date;
    private List<String> articles;
    private double total;

    public Commande() {}

    public Commande(int id, String date, List<String> articles, double total) {
        this.id = id;
        this.date = date;
        this.articles = articles;
        this.total = total;
    }

    public int getId() { return id; }
    public String getDate() { return date; }
    public List<String> getArticles() { return articles; }
    public double getTotal() { return total; }

    public void setId(int id) { this.id = id; }
    public void setDate(String date) { this.date = date; }
    public void setArticles(List<String> articles) { this.articles = articles; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", articles=" + articles +
                ", total=" + total +
                '}';
    }
}