package design.vendingMachine.dto;

public enum Coin {

  PENNY(1),
  NICKEL(5),
  DIME(10),
  QUARTER(25),
  HALF(50),
  ONE_DOLLAR(100),
  TWO_DOLLAR(200);

  private final int nominal;

  Coin(int nominal) {
    this.nominal = nominal;
  }

  public int getNominal() {
    return nominal;
  }
}
