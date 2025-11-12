package com.myprojects.pauldirac.mappers;

import com.myprojects.pauldirac.dto.StudentPatchDTO;
import com.myprojects.pauldirac.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface StudentMapper {

    void updateStudentFromDto(StudentPatchDTO dto, @MappingTarget Student entity);

}
