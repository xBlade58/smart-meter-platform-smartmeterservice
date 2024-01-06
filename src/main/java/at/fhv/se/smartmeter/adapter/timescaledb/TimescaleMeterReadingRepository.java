package at.fhv.se.smartmeter.adapter.timescaledb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterReadingDBEntity;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterReadingRepository;

@Repository
public class TimescaleMeterReadingRepository implements MeterReadingRepository {

    @Autowired
    private TimescaleJPAMeterReading timescaleJPARepo;

    @Override
    public void save(MeterReading mr) {
        MeterReadingDBEntity m = 
            new MeterReadingDBEntity(mr.getReadingTime(), mr.getMeterIndividualId(), mr.getPosActInstPower(), 
                                    mr.getPosActEnergyTotal(), mr.getNegActInstPower(), mr.getNegActEnergyTotal(),
                                    mr.getPosReactEnergyTotal(), mr.getNegReactEnergyTotal(), mr.getSumActInstantPower(),
                                    mr.getInstCurr_l1(), mr.getInstVolt_l1(), mr.getInstCurr_l2(),
                                    mr.getInstVolt_l2(), mr.getInstCurr_l3(), mr.getInstVolt_l3());
        timescaleJPARepo.save(m);
    }

    @Override
    public List<MeterReading> getAllMeterReadings() {
        List<MeterReadingDBEntity> entites = timescaleJPARepo.findAll();
        return entites.stream()
                    .map(TimescaleMeterReadingRepository::mapToMeterReading)
                    .collect(Collectors.toList());

    }

    private static MeterReading mapToMeterReading(MeterReadingDBEntity entity) {
        return new MeterReading(
                entity.getTimestamp(),
                entity.getMeterId(),
                entity.getPosActInstPower(),
                entity.getPosActEnergyTotal(),
                entity.getNegActInstPower(),
                entity.getNegActEnergyTotal(),
                entity.getPosReactEnergyTotal(),
                entity.getNegReactEnergyTotal(),
                entity.getSumActInstantPower(),
                entity.getInstCurr_l1(),
                entity.getInstVolt_l1(),
                entity.getInstCurr_l2(),
                entity.getInstVolt_l2(),
                entity.getInstCurr_l3(),
                entity.getInstVolt_l3()
        );
    }
    
}
