package idusw.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="board_a202112031")

@ToString(exclude = "writer")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_a202112031_seq_gen")
    @SequenceGenerator(sequenceName = "board_a202112031_seq", name = "board_a202112031_seq_gen", initialValue = 1, allocationSize = 1)
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne
    //@JoinColumn(name = "seq")
    private MemberEntity writer; // BoardEntity : MemberEntity = N : 1
}
