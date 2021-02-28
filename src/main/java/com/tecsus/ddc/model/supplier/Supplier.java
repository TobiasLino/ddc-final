package com.tecsus.ddc.model.supplier;

import com.tecsus.ddc.model.address.Address;
import com.tecsus.ddc.model.identification.Identification;
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
@Table(name = "DDC_SUPPLIER")
@SequenceGenerator(sequenceName = "DDC_SEQ_SUPPLIER", name = "SUPPLIER_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_SEQUENCE")
    @Column(name = "COD_SUPPLIER")
    private Long id;

    @Column(name = "SUP_DATA_CRIA")
    @CreatedDate
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataCria;

    @Column(name = "COD_IDENT")
    private Identification identity;

    @NotNull
    @Column(name = "SUP_NAME")
    private String name;

    @Column(name = "SUP_IE")
    private String ie;

    @Column(name = "SUP_SITE")
    private String site;

    @Column(name = "COD_ADDRESS")
    private Address address;
}

