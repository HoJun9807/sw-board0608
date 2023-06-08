package idusw.springboot.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="a202112031_reply")

@ToString(exclude = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a202112031_reply_seq_gen")
    @SequenceGenerator(sequenceName = "a202112031_reply_seq", name = "a202112031_reply_seq_gen", initialValue = 1, allocationSize = 1)
    private Long rno;

    private String text; // 댓글 내용
    private String replier; // 댓글 사용자



    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity board; // BoardEntity : MemberEntity = N : 1,

}
