package com.tecsus.ddc.model.identification;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DDC_IDENTIFICATION")
@SequenceGenerator(sequenceName = "ddc_seq_identification", name = "IDENTIFICATION_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDENTIFICATION_SEQUENCE")
    @Column(name = "COD_IDENT")
    private Long id;

    @Column(name = "IDE_DOC")
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "IDE_TYPE")
    private IdentityType type;
}
