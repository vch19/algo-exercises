package design.vendingMachine;

import design.vendingMachine.dto.MachineRequest;
import design.vendingMachine.dto.MachineResponse;
import design.vendingMachine.service.VendingMachineProcessor;
import design.vendingMachine.service.VendingMachineValidator;

public class VendingMachine {

  private final VendingMachineProcessor vendingMachineProcessor;
  private final VendingMachineValidator vendingMachineValidator;

  public VendingMachine(VendingMachineValidator vendingMachineValidator,
      VendingMachineProcessor vendingMachineProcessor) {
    this.vendingMachineProcessor = vendingMachineProcessor;
    this.vendingMachineValidator = vendingMachineValidator;
  }

  public MachineResponse get(MachineRequest machineRequest) {
    vendingMachineValidator.validate(machineRequest);
    return vendingMachineProcessor.get(machineRequest);
  }
}
