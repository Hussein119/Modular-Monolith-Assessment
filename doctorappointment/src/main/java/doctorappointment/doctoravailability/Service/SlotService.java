package doctorappointment.doctoravailability.Service;

import doctorappointment.doctoravailability.Entity.Slot;
import doctorappointment.doctoravailability.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    // Get all slots
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    // Add multiple slots
    public void addSlots(Slot[] slots) {
        for (Slot slot : slots) {
            slotRepository.save(slot);
        }
    }
}