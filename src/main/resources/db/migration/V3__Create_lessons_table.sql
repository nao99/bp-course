CREATE TABLE lessons (
    id         BIGSERIAL,
    section    BIGINT NOT NULL,
    name       VARCHAR (255) NOT NULL,
    content    TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP(0),

    CONSTRAINT pk_lessons__id PRIMARY KEY (id),

    CONSTRAINT fk_lessons__section_id FOREIGN KEY (section)
        REFERENCES sections (id)
            ON UPDATE NO ACTION
            ON DELETE CASCADE
);
