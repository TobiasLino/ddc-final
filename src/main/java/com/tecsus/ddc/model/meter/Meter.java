package com.tecsus.ddc.model.meter;

import com.tecsus.ddc.model.instalation.Instalation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DDC_METER")
@SequenceGenerator(sequenceName = "DDC_SEQ_METER", name = "METER_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "METER_SEQUENCE")
    @Column(name = "COD_METER")
    private Long id;

    @CreatedDate
    @Column(name = "MET_DATA_CRIA")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataCria;

    @NotNull
    @Column(name = "MET_NUMBER")
    private String number;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "COD_INST")
    private Instalation instalation;
}
