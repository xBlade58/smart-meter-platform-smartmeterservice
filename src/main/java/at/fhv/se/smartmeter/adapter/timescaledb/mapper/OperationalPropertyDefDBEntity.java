package at.fhv.se.smartmeter.adapter.timescaledb.mapper;



import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "property_def")
public class OperationalPropertyDefDBEntity {
    @Id
    private String id; // OBIS Code, e.g. 1.7.0
    private String name;
    
    @ElementCollection(targetClass = Unit.class)
    @CollectionTable(name = "property_def_allowedUnits")
    @Enumerated(EnumType.STRING)
    private Unit[] allowedUnits;

    public OperationalPropertyDefDBEntity(String id, String name, Unit[] allowedUnits) {
        this.id = id;
        this.name = name;
        this.allowedUnits = allowedUnits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit[] getAllowedUnits() {
        return allowedUnits;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllowedUnits(Unit[] allowedUnits) {
        this.allowedUnits = allowedUnits;
    }

    private OperationalPropertyDefDBEntity() {}

    
    
}
