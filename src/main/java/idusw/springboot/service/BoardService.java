package idusw.springboot.service;

import idusw.springboot.domain.Board;
import idusw.springboot.domain.PageRequestDTO;
import idusw.springboot.domain.PageResultDTO;
import idusw.springboot.entity.BoardEntity;
import idusw.springboot.entity.MemberEntity;

import java.util.List;
import java.util.Objects;

public interface BoardService {
    int registerBoard(Board board);
    Board findBoardById(Board board); // 게시물 ID - bno 조회
    PageResultDTO<Board, Object[]> findBoardAll(PageRequestDTO pageRequestDTO); //게시물 목록 출력
    int updateBoard(Board board); // 게시물 정보
    int deleteBoard(Board board); // 게시물 ID값 삭제

    default BoardEntity dtoToEntity(Board dto) {
        MemberEntity member = MemberEntity.builder()
                .seq(dto.getWriterSeq())
                .build();
        BoardEntity entity = BoardEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return entity;
    }

    default Board entityToDto(BoardEntity entity, MemberEntity memberEntity, Long replyCount) {
        Board dto = Board.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writerSeq(memberEntity.getSeq())
                .writerEmail(memberEntity.getEmail())
                .writerName(memberEntity.getName())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
