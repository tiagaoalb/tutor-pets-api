package com.tutorpets.repository;

import com.tutorpets.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Tutor findTutorByName(String tutorName);

    @Query("""
            select t
            from Tutor t
            left join fetch t.pets p
            where lower(t.name) like lower(concat('%', :name, '%'))
            """)
    List<Tutor> findTutorByNameContainingIgnoreCase(@Param("name") String name);

    @Query("""
            select t
            from Tutor t
            left join fetch t.pets p
            """)
    List<Tutor> findAllTutors();

    @Query("""
            select t
            from Tutor t
            left join fetch t.pets p
            where t.id = :tutorId
            """)
    Tutor findTutorById(@Param("tutorId") Long tutorId);
}
