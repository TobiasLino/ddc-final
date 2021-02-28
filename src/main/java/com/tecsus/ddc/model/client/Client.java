package com.tecsus.ddc.model.client;

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
@Table(name = "DDC_CLIENT")
@SequenceGenerator(sequenceName = "DDC_SEQ_CLIENT", name = "CLIENT_SEQUENCE", allocationSize = 1)
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQUENCE")
    @Column(name = "COD_CLIENT")
    private Long id;

    @Column(name = "CLI_DATA_CRIA")
    @CreatedDate
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataCria;

    @Column(name = "CLI_NAME", unique = true)
    @NotNull
    private String name;

    @Column(name = "COD_IDENT")
    @NotNull
    private Identification identity;
}
