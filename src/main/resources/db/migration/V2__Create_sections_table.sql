CREATE TABLE sections (
    id          BIGSERIAL,
    course      BIGINT NOT NULL,
    name        VARCHAR (255) NOT NULL,
    description TEXT DEFAULT NULL,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP(0),

    CONSTRAINT pk_sections__id PRIMARY KEY (id),

    CONSTRAINT fk_sections__course_id FOREIGN KEY (course)
        REFERENCES courses (id)
            ON UPDATE NO ACTION
            ON DELETE CASCADE
);
