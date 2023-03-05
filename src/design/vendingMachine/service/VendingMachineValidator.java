package design.vendingMachine.service;

import design.vendingMachine.dto.MachineRequest;
import design.vendingMachine.dto.Coin;
import design.vendingMachine.dto.Product;
import java.util.Set;

public class VendingMachineValidator {

  private static final String PRODUCT_DOESNT_EXISTS_ERROR_MSG = "Sorry, product %s doesn't exists";
  private static final String NOT_ENOUGH_MONEY_ERROR_MSG =
      "Don't enough money to buy all selected products";

  private final VendingMachineProcessor processor;

  public VendingMachineValidator(VendingMachineProcessor processor) {
    this.processor = processor;
  }

  public void validate(MachineRequest request) {
    Set<Product> availableProducts = processor.getAvailableProducts();

    for (Product product : request.getProducts()) {
      if (!availableProducts.contains(product)) {
        throw new RuntimeException(
            String.format(PRODUCT_DOESNT_EXISTS_ERROR_MSG, product.getName()));
      }
      int insertedCoins = request.getCoins().stream()
          .map(Coin::getNominal)
          .mapToInt(Integer::intValue).sum();
      int requiredCoins = request.getProducts().stream().map(Product::getPrice)
          .mapToInt(Integer::intValue).sum();

      if (insertedCoins < requiredCoins) {
        throw new RuntimeException(NOT_ENOUGH_MONEY_ERROR_MSG);
      }
    }
  }
}
