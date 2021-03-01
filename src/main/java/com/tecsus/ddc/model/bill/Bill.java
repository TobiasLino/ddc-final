package com.tecsus.ddc.model.bill;

import com.tecsus.ddc.model.instalation.Instalation;
import com.tecsus.ddc.model.meter.Meter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Table(name = "DDC_BILL")
@SequenceGenerator(sequenceName = "DDC_SEQ_BILL", name = "BILL_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_SEQUENCE")
    @Column(name = "COD_BILL")
    private Long id;

    @Column(name = "BILL_NUM", unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "COD_INST")
    private Instalation instalation;

    @Column(name = "BILL_EMISSION")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime emission;

    @Column(name = "BILL_REF_MONTH")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime refMonth;

    @CreatedDate
    @Column(name = "BILL_DATA_CRIA")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataCria;

    @Column(name = "BILL_ACTUAL_READ")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime actualRead;

    @Column(name = "BILL_ACTUAL_VALUE")
    private Double actualValue;

    @Column(name = "BILL_DUE_DATE")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dueDate;

    @Column(name = "BILL_CONSUM")
    private Double consum;

    @Column(name = "BILL_CONSUM_PERIOD")
    private Integer consumPeriod;

    @ManyToOne
    @JoinColumn(name = "COD_METER")
    private Meter meter;
}
