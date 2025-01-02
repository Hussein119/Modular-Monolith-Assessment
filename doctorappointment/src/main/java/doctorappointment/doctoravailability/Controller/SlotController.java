package doctorappointment.doctoravailability.Controller;

import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.doctoravailability.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {
    @Autowired
    private SlotService slotService;

    @GetMapping("/Available")
    public List<Slot> getSlots() {
        return slotService.getAvailableSlots();
    }

    @GetMapping("")
    public List<Slot> getAllSlots() {
        return slotService.getSlots();
    }

    @PostMapping
    public void addSlot(@RequestBody Slot[] slots) {
        slotService.addSlots(slots);
    }
}