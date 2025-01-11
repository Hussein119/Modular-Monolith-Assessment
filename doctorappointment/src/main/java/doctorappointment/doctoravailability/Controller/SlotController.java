package doctorappointment.doctoravailability.Controller;

import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.doctoravailability.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor-slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    // Get all slots
    @GetMapping("")
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> allSlots = slotService.getAllSlots();
        return new ResponseEntity<>(allSlots, HttpStatus.OK);
    }

    // Add one or more slots
    @PostMapping
    public ResponseEntity<String> addSlots(@RequestBody Slot[] slots) {
        slotService.addSlots(slots);
        return new ResponseEntity<>("Slots added successfully", HttpStatus.CREATED);
    }
}