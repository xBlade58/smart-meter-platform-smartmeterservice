package at.fhv.se.smartmeter.application.service.meter;

import at.fhv.se.smartmeter.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.model.Meter;

public class MeterService implements CreateMeterUseCase {

    private final MeterRepository meterRepo;

    public MeterService(MeterRepository meterRepo) {
        this.meterRepo = meterRepo;
    }

    @Override
    public long createMeter(int serialNumber, String manufacturer) {
        Meter m = new Meter(serialNumber, manufacturer);
        long id = meterRepo.save(m);
        return id;
    }
    
}
