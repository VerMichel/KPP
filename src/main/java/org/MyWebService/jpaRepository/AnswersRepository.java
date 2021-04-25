package org.MyWebService.jpaRepository;

import org.springframework.stereotype.Repository;
import org.MyWebService.entityes.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnswersRepository extends JpaRepository <AnswerEntity,Integer> {

}
