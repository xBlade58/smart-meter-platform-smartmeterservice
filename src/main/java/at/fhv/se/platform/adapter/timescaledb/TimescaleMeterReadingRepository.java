package at.fhv.se.platform.adapter.timescaledb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.platform.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.platform.model.MeterReading;

@Repository
public class TimescaleMeterReadingRepository implements MeterReadingRepository {

    @Autowired
    private TimescaleJPAMeterReading timescaleJPARepo;

    @Override
    public void save(MeterReading mr) {
        timescaleJPARepo.save(mr);
    }

    @Override
    public List<MeterReading> getAllMeterReadings() {
        return timescaleJPARepo.findAll();
    }
    
}
