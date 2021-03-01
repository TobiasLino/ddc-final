package com.tecsus.ddc.model.bill.energy.subgroup;

import com.tecsus.ddc.model.bill.energy.group.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DDC_ENERGY_SUB_GROUP")
@SequenceGenerator(sequenceName = "DDC_SEQ_SUB_GROUP", name = "SUB_GROUP_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class SubGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUB_GROUP_SEQUENCE")
    @Column(name = "COD_SUB_GROUP")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COD_GROUP")
    private Group group;

    @Column(name = "SGRP_NAME", nullable = false)
    private String name;
}
