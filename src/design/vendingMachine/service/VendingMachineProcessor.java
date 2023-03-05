package design.vendingMachine.service;

import design.vendingMachine.dto.Coin;
import design.vendingMachine.dto.MachineRequest;
import design.vendingMachine.dto.MachineResponse;
import design.vendingMachine.dto.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VendingMachineProcessor {

  public Map<Product, Integer> products;

  public VendingMachineProcessor(List<Product> initialProducts) {
    for (Product product : initialProducts) {
      products.put(product, products.getOrDefault(product, 0) + 1);
    }
  }

  public MachineResponse get(MachineRequest machineRequest) {
    return null;
  }

  public Set<Product> getAvailableProducts() {
    return products.keySet();
  }

  public MachineResponse cancel(MachineRequest request) {
    return new MachineResponse(request.getCoins(), List.of());
  }

  private List<Coin> calculateResidue(int total, int inserted) {
    int residue = inserted - total;
    //todo
    return null;
  }
}
