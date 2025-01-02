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

    public List<Slot> getAvailableSlots() {
        return slotRepository.findByDoctorIdAndIsReservedFalse();
    }

    public List<Slot> getSlots() {
        return slotRepository.getAllDoctors();
    }

    public void addSlot(Slot slot) {
        slotRepository.save(slot);
    }

    public void addSlots(Slot[] slots) {
        for (Slot slot : slots) {
            slotRepository.save(slot);
        }
    }
}
