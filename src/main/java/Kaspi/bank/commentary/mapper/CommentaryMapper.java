package Kaspi.bank.commentary.mapper;

import Kaspi.bank.commentary.entity.Commentary;
import com.netflix.dgs.codegen.generated.types.CommentaryPhonesInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentaryMapper {
    List<Commentary> mapToCommentaryList(List<CommentaryPhonesInput> commentaryPhonesInputList);
}
