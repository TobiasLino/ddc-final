package com.tecsus.ddc.model.bill.energy.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DDC_ENERGY_GROUP")
@SequenceGenerator(sequenceName = "DDC_SEQ_GROUP", name = "GROUP_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_SEQUENCE")
    @Column(name = "COD_GROUP")
    private Long id;

    @Column(name = "GRP_NAME")
    private String name;
}
