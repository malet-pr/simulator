package org.acme.simulator.simulations;

import org.acme.simulator.simulations.internal.WorkOrder;
import org.acme.simulator.simulations.internal.WorkOrderSimulator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Simulations {

    private final WorkOrderSimulator simu;

    public Simulations(WorkOrderSimulator simu) {
        this.simu = simu;
    }

    public List<WorkOrder> simulateWorkOrders(int quantity){
        List<WorkOrder> woList = new ArrayList<>();
        while(quantity > 0){
            woList.add(simu.simulate());
            quantity--;
        }
        return woList;
    }

}
