package idusw.springboot.domain;

import idusw.springboot.repository.BoardRepository;
import lombok.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@EqualsAndHashCode

public class Board { // 5files
    // board
    private Long bno;  // 유일성
    private String title;
    private String content;

    //join
    private Long writerSeq;
    private String writerEmail;
    private String writerName;

    // auditing
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private Long replyCount;

}
