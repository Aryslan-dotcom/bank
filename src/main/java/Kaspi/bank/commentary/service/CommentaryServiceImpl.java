package Kaspi.bank.commentary.service;

import Kaspi.bank.commentary.entity.Commentary;
import Kaspi.bank.commentary.repository.CommentaryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryServiceImpl implements CommentaryService{
    @Autowired
    private CommentaryRepositories commentaryRepositories;
    @Override
    public Commentary addCommentary(Commentary comment) {
        return  commentaryRepositories.save(comment);
    }

    @Override
    public List<Commentary> getAllComents() {
        return commentaryRepositories.findAll();
    }
}
