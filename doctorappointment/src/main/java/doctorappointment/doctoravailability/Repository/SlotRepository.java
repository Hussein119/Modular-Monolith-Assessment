package doctorappointment.doctoravailability.Repository;

import doctorappointment.doctoravailability.Entity.Slot;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class SlotRepository {
    private final List<Slot> slots = new ArrayList<>();

    public List<Slot> findByDoctorIdAndIsReservedFalse() {
        return slots.stream()
                .filter(slot -> slot.isReserved())
                .toList();
    }

    public List<Slot> getAllDoctors() {
        return slots.stream().toList();
    }

    public void save(Slot slot) {
        slots.add(slot);
    }

    public Slot findById(UUID slotId) {
        return slots.stream()
                .filter(slot -> slot.getId().equals(slotId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }
}