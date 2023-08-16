package com.fachrizal.booklist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Book\''s Title cannot be empty.")
    private String title;
    @NotBlank(message = "Book\''s Author Name cannot be empty.")
    private String authorName;
    @NotBlank(message = "Book\''s ISBN cannot be empty.")
    @Size(min = 10, message = "ISBN minimum length is 10 characters")
    private String isbn;
    @NotBlank(message = "Book\''s Description cannot be empty.")
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, updatable = false)
    @Temporal (TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
