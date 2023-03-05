package design.vendingMachine.dto;

import java.util.List;

public class MachineRequest {
  private final List<Coin> coins;
  private final List<Product> products;

  public MachineRequest(List<Coin> coins, List<Product> products) {
    this.coins = coins;
    this.products = products;
  }

  public List<Coin> getCoins() {
    return coins;
  }

  public List<Product> getProducts() {
    return products;
  }
}
