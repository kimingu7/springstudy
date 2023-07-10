package com.example.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentListDto {
    private List<CreateCommentDto> commentList;

}
