package Kaspi.bank.commentary.service;

import Kaspi.bank.commentary.entity.Commentary;

import java.util.List;

public interface CommentaryService {
    Commentary addCommentary(Commentary comment);
    List<Commentary>getAllComents();
}
