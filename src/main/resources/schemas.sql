CREATE TABLE IF NOT EXISTS METER (
    id SERIAL PRIMARY KEY,
    serial_number int,
    manufacturer varchar(64)
);

CREATE TABLE IF NOT EXISTS METER_READING (
    timestamp TIMESTAMPTZ NOT NULL,
    meter_id INTEGER REFERENCES METER (id),
    pos_act_inst_power int,
    pos_act_energy_total int,
    neg_act_inst_power int,
    neg_act_energy_total int,
    pos_react_energy_total int,
    neg_react_energy_total int,
    sum_act_instant_power int,
    inst_curr_l1 float4,
    inst_volt_l1 float4,
    inst_curr_l2 float4,
    inst_volt_l2 float4,
    inst_curr_l3 float4,
    inst_volt_l3 float4
);

SELECT create_hypertable('METER_READING', 'timestamp')
