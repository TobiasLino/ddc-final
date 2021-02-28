create table ddc_address (
    cod_address number(10) constraint PK_ADDR_COD_ADDR primary key,
    add_zip number(15) not null,
    add_street varchar(100),
    add_number varchar(10),
    add_comp varchar(30),
    add_city varchar(30),
    add_neighborhood varchar(40),
    add_state varchar(2)
);

create table ddc_identification (
    cod_ident number(10) constraint PK_IDE_COD_IDENT primary key,
    ide_doc varchar(30) not null,
    ide_type varchar(6) default 'CNPJ'
);

create table ddc_supplier (
    cod_supplier number(10) constraint PK_SUP_COD_SUP primary key,
    sup_data_cria date default sysdate,
    cod_ident number(10) not null constraint FK_SUP_COD_IDENT references ddc_identification(cod_ident),
    sup_name varchar(100) not null,
    sup_ie varchar(30),
    sup_site varchar(256),
    cod_address number(10) not null constraint FK_SUP_COD_ADDR references ddc_address(cod_address)
);

create table ddc_client (
    cod_client number(10) constraint PK_CLI_COD_CLI primary key,
    cli_data_cria date default sysdate,
    cli_name varchar(100) not null constraint UK_CLI_NAME unique,
    cod_ident number(10) not null constraint FK_CLI_COD_IDENT references ddc_identification(cod_ident)
);

create table ddc_instalation (
    cod_inst number(10) constraint PK_INST_COD_INST primary key,
    inst_data_cria date default sysdate,
    inst_number varchar(30) not null constraint UK_INST_NUMBER unique,
    cod_client number(10) not null constraint FK_INST_COD_CLI references ddc_client(cod_client),
    cod_supplier number(10) not null constraint FK_INST_COD_SUP references ddc_supplier(cod_supplier),
    cod_address number(10) not null constraint FK_INST_COD_ADDR references ddc_address(cod_address)
);

create table ddc_meter (
    cod_meter number(10) constraint PK_MET_COD_MET primary key,
    met_data_cria date default sysdate,
    met_number varchar(30) not null constraint UK_MET_NUMBER unique,
    cod_inst number(10) not null constraint FK_MET_COD_INST references ddc_instalation(cod_inst)
);

create table ddc_bill(
    cod_bill number(10) constraint PK_BILL_COD_BILL primary key,
    bill_num varchar(30) constraint UK_BILL_NUM unique,
    cod_inst number(10) constraint FK_BILL_COD_INST references ddc_instalation(cod_inst),
    bill_emission date,
    bill_ref_month date not null,
    bill_data_cria date default sysdate,
    bill_actual_read date not null,
    bill_atual_value number(5,2),
    bill_due_date date not null,
    bill_consum number(6) not null,
    bill_consum_period number(3),
    cod_meter number(10) constraint FK_BILL_COD_METER references ddc_meter(cod_meter)
);

create table ddc_energy_group (
    cod_group number(4) constraint PK_GRP_COD_GRP primary key,
    grp_name varchar(4) not null
);

create table ddc_energy_sub_group (
    cod_sub_group number(4) constraint PK_SGRP_COD_SUB primary key,
    cod_group number(4) constraint FK_GRP_COD_GRP references ddc_energy_group(cod_group),
    sgrp_name varchar(4) not null
);

create table ddc_energy_class (
    cod_class number(4) constraint PK_CLA_COD_CLA primary key,
    cla_name varchar(4) not null
);

create table ddc_energy_sub_class (
    cod_sub_class number(4) constraint PK_SCLA_COD_SUB primary key,
    cod_class number(4) constraint FK_SCLA_COD_CLA references ddc_energy_class(cod_class),
    scla_name varchar(4) not null
);

create table ddc_energy_bill (
    cod_bill number(10) constraint FK_ENE_COD_BILL references ddc_bill(cod_bill),
    cod_sub_group number(4) constraint FK_ENE_SUB_GRP references ddc_energy_sub_group(cod_sub_group),
    cod_sub_class number(4) constraint FK_ENE_COD_CLA references ddc_energy_sub_class(cod_sub_class),
    ene_tension number(5),
    ene_phase varchar(10) constraint CK_ENE_PHASE check(ene_phase in ('MONOFASICA', 'BIFASICA', 'TRIFASICA'))
);

create table ddc_energy_flag (
    cod_flag number(10) constraint PK_FLAG_COD_FLAG primary key,
    fla_data_start date,
    fla_data_end date,
    fla_color varchar(25) not null,
    cod_bill number(10) constraint FK_FLAG_COD_BILL references ddc_bill(cod_bill)
);

create table ddc_product (
    cod_prod number(10) constraint PK_PRO_COD_PRO primary key,
    pro_type varchar(100) not null,
    pro_value number(10,2) not null,
    pro_quant number(10,6) not null,
    cod_bill number(10) constraint FK_PRO_COD_BILL references ddc_bill(cod_bill)
);

select * from ddc_bill b
join ddc_energy_bill e on b.cod_bill = e.cod_bill;

--drop table ddc_ cascade constraints;