CREATE TABLE IF NOT EXISTS SMART_METER (
    id char(36) primary key,
    manufacturer varchar(64)
);

CREATE TABLE IF NOT EXISTS SMART_METER (
    time_stamp timestamp primary key,
    pos_act_inst_power int,
    pos_act_energy_total int,
    neg_act_inst_power int,
    neg_act_energy_total int,
    pos_react_energy_total int,
    neg_react_energy_total int,
    sum_act_instant_power int,
    inst_curr_l1 double,
    inst_volt_l1 double,
    inst_curr_l2 double,
    inst_volt_l2 double,
    inst_curr_l3 double,
    inst_volt_l3 double
);