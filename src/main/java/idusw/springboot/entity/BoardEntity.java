package idusw.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="a202112031_board")

@ToString(exclude = "writer")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a202112031_board_seq_gen")
    @SequenceGenerator(sequenceName = "a202112031_board_seq", name = "a202112031_board_seq_gen", initialValue = 1, allocationSize = 1)
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "seq")
    private MemberEntity writer; // BoardEntity : MemberEntity = N : 1
}
