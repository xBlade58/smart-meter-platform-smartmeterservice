package at.fhv.se.platform.application.service.meter;

import at.fhv.se.platform.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.platform.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.platform.model.Meter;

public class MeterService implements CreateMeterUseCase {

    private final MeterRepository meterRepo;

    public MeterService(MeterRepository meterRepo) {
        this.meterRepo = meterRepo;
    }

    @Override
    public int createMeter(int id, String manufacturer) {
        Meter m = new Meter(id, manufacturer);
        meterRepo.save(m);
        return id; //TODO: Refactor generation and usage of meterId
    }
    
}
