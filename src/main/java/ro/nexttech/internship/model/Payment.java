package ro.nexttech.internship.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity

@Setter
@Getter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "sum")
    private long sum;

    @Column(name = "data")
    private LocalDateTime data;

    @ManyToMany(mappedBy = "paymentSet")
    Set<Invoice> invoiceSet;
}
