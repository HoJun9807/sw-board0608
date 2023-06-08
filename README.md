# sw-board0608

   public int updateBoard(Board board) {
        BoardEntity entity = BoardEntity.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .build();
        if (boardRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }
