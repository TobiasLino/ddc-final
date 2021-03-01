package com.tecsus.ddc.model.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DDC_ADDRESS")
@SequenceGenerator(sequenceName = "ddc_seq_address", name = "ADDRESS_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQUENCE")
    @Column(name = "COD_ADDRESS")
    private Long id;

    @NotNull
    @Column(name = "ADD_ZIP")
    private Long zip;

    @Column(name = "ADD_STREET")
    private String street;

    @Column(name = "ADD_NUMBER")
    private String number;

    @Column(name = "ADD_COMP")
    private String complement;

    @Column(name = "ADD_CITY")
    private String city;

    @Column(name = "ADD_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "ADD_STATE")
    private String uf;
}
