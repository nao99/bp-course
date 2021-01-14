CREATE TABLE courses (
    id          BIGSERIAL,
    name        VARCHAR (255) NOT NULL,
    description TEXT DEFAULT NULL,
    created_at  TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP(0),

    CONSTRAINT pk_courses__id PRIMARY KEY (id)
);
