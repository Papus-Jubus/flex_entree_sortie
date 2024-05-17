package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;



import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private double amount;

    private String category;

    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public enum TransactionType {
        ENTRÉE,
        SORTIE
    }
}


