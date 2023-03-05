package design.vendingMachine.dto;

import java.util.List;

public class MachineResponse {

  private final List<Coin> residue;
  private final List<Product> products;

  public MachineResponse(List<Coin> residue, List<Product> products) {
    this.residue = residue;
    this.products = products;
  }

  public List<Coin> getResidue() {
    return residue;
  }

  public List<Product> getProducts() {
    return products;
  }
}
