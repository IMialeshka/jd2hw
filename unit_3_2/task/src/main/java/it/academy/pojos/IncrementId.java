package it.academy.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class IncrementId {
    @Id
    @Column
    @GeneratedValue(generator = "increment-generator")
    @GenericGenerator(name = "increment-generator", strategy = "increment")
    private Integer ID;
}
