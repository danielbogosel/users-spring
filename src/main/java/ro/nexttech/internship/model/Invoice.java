package ro.nexttech.internship.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "invoice_number")
    private int invoiceNumber;

    @Column(name = "maturity_date")
    private LocalDateTime maturityDate;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "id_supplier")
    private int idSupplier;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "value")
    private long value;

    @ManyToMany
    @JoinTable(
            name = "paymant_has_invoice",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    Set<Payment> paymentSet;

}
