package idusw.springboot.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="reply_a202112031")

@ToString(exclude = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_a202112031_seq_gen")
    @SequenceGenerator(sequenceName = "reply_a202112031_seq", name = "reply_a202112031_seq_gen", initialValue = 1, allocationSize = 1)
    private Long bno;

    private String text;
    private String replier;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity board; // BoardEntity : MemberEntity = N : 1
}
