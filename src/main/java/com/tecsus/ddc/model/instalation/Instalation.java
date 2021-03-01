package com.tecsus.ddc.model.instalation;

import com.tecsus.ddc.model.address.Address;
import com.tecsus.ddc.model.client.Client;
import com.tecsus.ddc.model.supplier.Supplier;
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
@Table(name = "DDC_INSTALATION")
@SequenceGenerator(sequenceName = "DDC_SEQ_INSTALATION", name = "INSTALATION_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Instalation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTALATION_SEQUENCE")
    @Column(name = "COD_INST")
    private Long id;

    @CreatedDate
    @Column(name = "INST_DATA_CRIA")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataCria;

    @Column(name = "INSTA_NUMBER", unique = true)
    @NotNull
    private String number;

    @ManyToOne
    @JoinColumn(name = "COD_CLIENT")
    @NotNull
    private Client client;

    @ManyToOne
    @JoinColumn(name = "COD_SUPPLIER")
    @NotNull
    private Supplier supplier;

    @OneToOne
    @JoinColumn(name = "COD_ADDRESS")
    @NotNull
    private Address address;
}
